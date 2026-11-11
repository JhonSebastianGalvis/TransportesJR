/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.controlador;

import java.util.Date;
import java.util.List;
import transportesjr.modelo.DetallePedido;
import transportesjr.modelo.Pedido;
import transportesjr.modelo.Producto;
import transportesjr.repositorio.DetallePedidoRepositorio;
import transportesjr.repositorio.PedidoRepositorio;

/* Controla la lógica del negocio entre los pedidos, sus detalles y el control de inventario
"Repo" funciona como abreviatura para Repositorio */
public class PedidoControlador {
    private PedidoRepositorio pedidoRepo;
    private DetallePedidoRepositorio detalleRepo;

    /* Ingresa los repositorios necesarios para operar pedidos y detalles */
    public PedidoControlador(PedidoRepositorio pedidoRepo, DetallePedidoRepositorio detalleRepo) {
        this.pedidoRepo = pedidoRepo;
        this.detalleRepo = detalleRepo;
    }

    /* Crea y registra un nuevo pedido
    Valida que la id no esté repetida */
    public Pedido crearPedido(int idPedido, int idCliente, int idTrayecto, String metodoPago, String direccion) {
        if (pedidoRepo.buscarPorId(idPedido) != null) {
            return null; // Evita duplicación de id
        }
        Pedido nuevo = new Pedido(idPedido, idCliente, idTrayecto, new Date(), "Pendiente", metodoPago, direccion);
        pedidoRepo.guardar(nuevo);
        return nuevo; 
    }

    /* Valida la disposición del stock, descuenta el inventario y vincula el producto */
    public boolean agregarProductoAPedido(int idPedido, Producto producto, int cantidad) {
        Pedido pedido = pedidoRepo.buscarPorId(idPedido);
        if (pedido == null || producto == null || cantidad <= 0) {
            return false;
        }
        if (producto.getStockDisponible() < cantidad) {
            return false; // En caso de que el producto este agotado o se solicite un valor mayor al disponible
        }

        /* Actualiza el inventario, crea la relación en el pedido y su repositorio */
        producto.actualizarStock(-cantidad);
        DetallePedido detalle = new DetallePedido(idPedido, producto.getIdProducto(), cantidad, producto.getPrecioUnitario());
        
        pedido.agregarDetalle(detalle);
        detalleRepo.guardar(detalle);
        return true;
    }

    /* Calcula el valor monetario total del pedido registrado */
    public double obtenerTotalPedido(int idPedido) {
        Pedido pedido = pedidoRepo.buscarPorId(idPedido);
        return (pedido != null) ? pedido.calcularTotalPedido() : 0.0; // Si no existe su valor es 0.0
    }

    /* Mediante el repositorio actualiza el estado del pedido */
    public boolean cambiarEstadoPedido(int idPedido, String nuevoEstado) {
        return pedidoRepo.actualizarEstado(idPedido, nuevoEstado);
    }

    /* Consulta y retorna un pedido especifico mediante su id */
    public Pedido consultarPedido(int idPedido) {
        return pedidoRepo.buscarPorId(idPedido);
    }
    
    // Elimina los detalles asociados y luego el pedido del repositorio
    public boolean eliminarPedido(int idPedido) {
        detalleRepo.eliminarPorPedido(idPedido);
        return pedidoRepo.eliminar(idPedido);
    }

    /* Retorna la lista completa de los pedidos gestionados */
    public List<Pedido> listarPedidos() {
        return pedidoRepo.listarTodos();
    }
}