/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.pruebas;

import transportesjr.controlador.PedidoControlador;
import transportesjr.modelo.Pedido;
import transportesjr.modelo.Producto;
import transportesjr.repositorio.DetallePedidoRepositorio;
import transportesjr.repositorio.PedidoRepositorio;

/* Permite verificar las reglas del negocio:
Como la creación, validación de stock, cálculo total y cambio de estado */
public class PruebaPedidoControlador {
    public static void main(String[] args) {
        // Dependencias del repositorio y controlador
        PedidoRepositorio pedidoRepo = new PedidoRepositorio();
        DetallePedidoRepositorio detalleRepo = new DetallePedidoRepositorio();
        PedidoControlador controlador = new PedidoControlador(pedidoRepo, detalleRepo);

        Producto cemento = new Producto(101, "Cemento 50kg", "Disponible", 32000, 20);

        // 1. Creación del pedido
        Pedido pedido = controlador.crearPedido(5001, 1, 3001, "Tarjeta", "Calle 10 # 45-20");
        System.out.println("Pedido creado: #" + pedido.getIdPedido() + " | Estado: " + pedido.getEstadoPedido());

        // 2. Agrega un producto con stock suficiente (20 disponibles, pide 5)
        boolean agregado = controlador.agregarProductoAPedido(5001, cemento, 5);
        System.out.println("Producto agregado: " + agregado + " | Stock restante: " + cemento.getStockDisponible());

        // 3. Intenta agregar más de lo disponible (15 disponibles, pide 30)
        boolean falloStock = controlador.agregarProductoAPedido(5001, cemento, 30);
        System.out.println("Intento sin stock (debe ser false): " + falloStock);

        // 4. Prueba el calculo financiero y cierre del estado del pedido
        System.out.println("Total pedido: $" + controlador.obtenerTotalPedido(5001));
        controlador.cambiarEstadoPedido(5001, "Completado");
        System.out.println("Estado final: " + controlador.consultarPedido(5001).getEstadoPedido());
        
        // 5. Elimina la información del pedido
        boolean eliminado = controlador.eliminarPedido(5001);
        System.out.println("Pedido eliminado: " + eliminado + " | Total pedidos: " + controlador.listarPedidos().size());
    }
}