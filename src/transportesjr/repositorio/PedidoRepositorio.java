/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.repositorio;

import java.util.ArrayList;
import java.util.List;
import transportesjr.modelo.Pedido;

/* Repositorio encargado de administrar la memoria de los pedidos
evitando duplicados por ID y permitir consultar*/
public class PedidoRepositorio {
    private List<Pedido> pedidos = new ArrayList<>();

    /* Guarda un pedido que no este vacio y que no tenga una id ya existente */
    public void guardar(Pedido pedido) {
        if (pedido != null && buscarPorId(pedido.getIdPedido()) == null) {
            pedidos.add(pedido);
        }
    }

    /* Busca un pedido especifico mediante su clave primaria / id */
    public Pedido buscarPorId(int idPedido) {
        for (Pedido p : pedidos) {
            if (p.getIdPedido() == idPedido) {
                return p; // Retorna el pedido si se encontro
            }
        }
        return null; // Retorna si no se encontro el pedido
    }

    /* Devuelve una copia de la lista con todos los pedidos almacenados */
    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }

    /* Busca un pedido por id y actualiza su estado */
    public boolean actualizarEstado(int idPedido, String nuevoEstado) {
        Pedido pedido = buscarPorId(idPedido);
        if (pedido != null) {
            pedido.cambiarEstado(nuevoEstado);
            return true; // Retorna si existe el pedido
        }
        return false; // Retorna si no se encontro el pedido
    }

    /* Elimina un pedido del repositorio según su id */
    public boolean eliminar(int idPedido) {
        return pedidos.removeIf(p -> p.getIdPedido() == idPedido); // Retorna si se elimino exitosamente
    }
}