/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

/* Representa la mercancia a transportar, junto al precio y disponibilidad */
public class Producto {
    private int idProducto;
    private String tipoProducto;
    private String estadoProducto;
    private double precioUnitario;
    private int stockDisponible; // Atributo requerido para operar el inventario

    public Producto(int idProducto, String tipoProducto, String estadoProducto, double precioUnitario, int stockDisponible) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.estadoProducto = estadoProducto;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    /* Ajusta el inventario al sumar entradas o restar salidas (ventas) de unidades
    Evita valores negativos, actualiza automaticamente si esta Agotado o Disponible*/
    public void actualizarStock(int cantidad) {
        // Toma el stock disponible y suma la cantidad entrante (o resta si es una venta/valor negativo)
        if (this.stockDisponible + cantidad >= 0) {
            this.stockDisponible += cantidad;
            this.estadoProducto = (this.stockDisponible == 0) ? "Agotado" : "Disponible";
        }
    }
    
    /* Actualiza el precio unitario del producto solo si es positivo */
    public void actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio >= 0) {
            this.precioUnitario = nuevoPrecio;
        }
    }
    
    // Getters y Setters

    public int getIdProducto() {
        return idProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
}