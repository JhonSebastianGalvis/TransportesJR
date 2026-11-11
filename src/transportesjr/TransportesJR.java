/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package transportesjr;

import java.util.Date;
import transportesjr.modelo.*;

/* El Main del proyecto */
public class TransportesJR {
 
    public static void main(String[] args) {
        // 1. Cliente y Producto
        Cliente cliente = new Cliente(1, "Carlos Mendoza", "Calle 10 # 45-20", "3105551234");
        Producto producto = new Producto(101, "Cemento 50kg", "Disponible", 32000, 50);
        producto.actualizarStock(-10); // Se descuentan 10 unidades del inventario

        // 2. Creacion del Pedido y Factura
        Pedido pedido = new Pedido(5001, new Date(), "Efectivo");
        pedido.agregarDetalle(new DetallePedido(5001, 101, 10, 32000));
        
        Factura factura = new Factura(9001, 5001, new Date(), pedido.calcularTotalPedido());
        factura.procesarPago("Efectivo");

        // 3. Vehículo, Conductor y Trayecto (licencia válida por 10 días)
        Date licenciaValida = new Date(System.currentTimeMillis() + 864000000L);
        Conductor conductor = new Conductor(10, "Andrés Gómez", "Disponible", "3159876543", "C2-987", licenciaValida);
        Vehiculo vehiculo = new Vehiculo(201, 3500, "KLM-456", "Chevrolet NQR", "Camión");

        Trayecto trayecto = new Trayecto();
        if (vehiculo.verificarCapacidad(1200) && trayecto.asignarConductorVehiculo(conductor, vehiculo)) {
            trayecto.registrarSalida();
            trayecto.agregarGasto(new Gasto(1, 3001, "Peaje", 18500));
            trayecto.registrarLlegada();
        }

        // 4. Registra el cierre de entrega y salida de resultados por consola
        Entrega entrega = new Entrega(7001, 3001, "En camino", null);
        entrega.registrarEstadoEntrega("Entregado");

        System.out.println("Cliente: " + cliente.getNombre() + " | Stock restante: " + producto.getStockDisponible());
        System.out.println("Gastos ruta: $" + trayecto.calcularGastosTotal() + " | Entrega: " + entrega.getEstado());
    }
}