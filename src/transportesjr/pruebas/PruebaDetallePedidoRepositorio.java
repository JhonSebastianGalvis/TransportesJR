/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.pruebas;

import transportesjr.modelo.DetallePedido;
import transportesjr.repositorio.DetallePedidoRepositorio;

/* Permite verificar el funcionamiento correcto del CRUD */
public class PruebaDetallePedidoRepositorio {
    public static void main(String[] args) {
        DetallePedidoRepositorio repo = new DetallePedidoRepositorio();

        // Inserta los registros de prueba asociados al 2 pedidos diferentes
        repo.guardar(new DetallePedido(5001, 101, 5, 32000));
        repo.guardar(new DetallePedido(5001, 102, 2, 28500));
        repo.guardar(new DetallePedido(5002, 101, 10, 32000));

        // Verifica las consultas por pedido y listado general
        System.out.println("Detalles del pedido 5001: " + repo.buscarPorPedido(5001).size()); // Esperado: 2
        System.out.println("Total detalles guardados: " + repo.listarTodos().size()); // Esperado: 3

        // Permite actualizar los parametros de un producto ya existente
        repo.actualizar(5001, 101, 8, 32000);
        System.out.println("Nueva cantidad producto 101: " + repo.buscarPorPedido(5001).get(0).getCantidad()); // Esperado: 8

        // Verifica el borrado en cascada por ID del pedido
        repo.eliminarPorPedido(5001);
        System.out.println("Detalles tras eliminar pedido 5001: " + repo.listarTodos().size()); // Esperado: 1
    }
}