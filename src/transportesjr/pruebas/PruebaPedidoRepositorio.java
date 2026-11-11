/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.pruebas;

import java.util.Date;
import transportesjr.modelo.Pedido;
import transportesjr.repositorio.PedidoRepositorio;

/* Valida el registro, búsqueda, cambio de estado y eliminación */
public class PruebaPedidoRepositorio {
    public static void main(String[] args) {
        PedidoRepositorio repo = new PedidoRepositorio();
        
        // Crea y guarda pedidos de prueba
        Pedido p1 = new Pedido(5001, new Date(), "Efectivo");
        Pedido p2 = new Pedido(5002, new Date(), "Tarjeta");

        repo.guardar(p1);
        repo.guardar(p2);
        
        System.out.println("Pedidos registrados: " + repo.listarTodos().size()); // Esperado: 2

        // Actualiza el estado y la consulta individual
        repo.actualizarEstado(5001, "Pagado");
        System.out.println("Estado pedido 5001: " + repo.buscarPorId(5001).getEstadoPedido()); // Esperado: Pagado

        // Eliminación por ID
        repo.eliminar(5002);
        System.out.println("Pedidos tras eliminar 5002: " + repo.listarTodos().size()); // Esperado: 1
    }
}