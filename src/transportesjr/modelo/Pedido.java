/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Es la orden de transporte o compra realizada por el cliente */
public class Pedido {
    private int idPedido;
    private int idCliente;
    private int idTrayecto;
    private Date fechaPedido;
    private String estadoPedido;
    private String metodoPago;
    private String direccion;
    private List<DetallePedido> detalles; // Asociación 1 a 1..* del diagrama de clases

    /* Inicia el pedido con el estado Pendiente */
    public Pedido(int idPedido, Date fechaPedido, String metodoPago) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.metodoPago = metodoPago;
        this.estadoPedido = "Pendiente";
        this.detalles = new ArrayList<>();
    }

    /* El constructor completo de los datos del cliente, trayecto y dirección de entrega */
    public Pedido(int idPedido, int idCliente, int idTrayecto, Date fechaPedido, String estadoPedido, String metodoPago, String direccion) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idTrayecto = idTrayecto;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = (estadoPedido != null) ? estadoPedido : "Pendiente";
        this.metodoPago = metodoPago;
        this.direccion = direccion;
        this.detalles = new ArrayList<>();
    }

    /* Agrega otra linea de producto o detalle al pedido actual */
    public void agregarDetalle(DetallePedido detalle) {
        if (detalle != null) {
            this.detalles.add(detalle);
        }
    }

    /* Se suma el subtotal cada detalle asociado y obtiene el valor total del pedido */
    public double calcularTotalPedido() {
        double suma = 0;
        for (DetallePedido d : detalles) {
            suma += d.calcularSubtotal();
        }
        return suma; // Retorna el valor total del pedido
    }

    /* Modifica el estado actual del pedido */
    public void cambiarEstado(String nuevoEstado) {
        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            this.estadoPedido = nuevoEstado;
        }
    }

    // Getters y Setters

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdTrayecto() {
        return idTrayecto;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdTrayecto(int idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

}