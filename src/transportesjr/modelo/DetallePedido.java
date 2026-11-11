/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

/* Clase intermedia que especifica la información del pedido */
public class DetallePedido {
    private int idPedido;
    private int idProducto;
    private int cantidad;
    private double precio;

    public DetallePedido(int idPedido, int idProducto, int cantidad, double precio) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /* Multiplica la cantidad con el precio unitario
    Devuelve el valor subtotal del detalle*/
    public double calcularSubtotal() {
        return this.cantidad * this.precio;
    }
    
    // Get y Set

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}