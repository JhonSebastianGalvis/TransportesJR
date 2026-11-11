/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.repositorio;

import java.util.ArrayList;
import java.util.List;
import transportesjr.modelo.DetallePedido;

/* Se encarga de gestionar el almacenamiento en memoria de los detalles del pedido (CRUD) */
public class DetallePedidoRepositorio {
    private List<DetallePedido> detalles = new ArrayList<>();

    /* Almacena un nuevo detalle si no esta vacio */
    public void guardar(DetallePedido detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    /* Filtra y retorna las líneas de detalle relacionadas a un pedido específico */
    public List<DetallePedido> buscarPorPedido(int idPedido) {
        List<DetallePedido> resultado = new ArrayList<>();
        for (DetallePedido d : detalles) {
            if (d.getIdPedido() == idPedido) {
                resultado.add(d);
            }
        } return resultado; // Retorna la lista de detalles
    }
    
    /* Actualiza la cantidad y el precio de un producto dentro de un pedido */
    public boolean actualizar(int idPedido, int idProducto, int nuevaCantidad, double nuevoPrecio) {
        for (DetallePedido d : detalles) {
            if (d.getIdPedido() == idPedido && d.getIdProducto() == idProducto) {
                d.setCantidad(nuevaCantidad);
                d.setPrecio(nuevoPrecio);
                return true;
            }
        } return false;
    }

    /* Retorna una copia completa de todos los detalles registrados en el sistema */
    public List<DetallePedido> listarTodos() {
        return new ArrayList<>(detalles);
    }
    
    /* Elimina todos los detalles de una id especifica de pedido */
    public boolean eliminarPorPedido(int idPedido) {
        return detalles.removeIf(d -> d.getIdPedido() == idPedido);
    }
}