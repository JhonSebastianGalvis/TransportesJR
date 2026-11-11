/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

import java.util.Date;

/* Es el comprobante del pago realizado al pedido  */
public class Factura {
    private int idFactura;
    private int idPedido;
    private Date fechaFactura;
    private double valorFactura;

    public Factura(int idFactura, Date fechaFactura, double valorFactura) {
        this.idFactura = idFactura;
        this.idPedido = idPedido;
        this.fechaFactura = fechaFactura;
        this.valorFactura = valorFactura;
    }

    public Factura(int i, int i0, Date date, double calcularTotalPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /* Valida el método de pago y si fue aceptado*/
        public boolean procesarPago(String metodo) {
        if ("Efectivo".equalsIgnoreCase(metodo) || "Tarjeta".equalsIgnoreCase(metodo)) {
            exportarFactura();
            return true; // En caso de que se haya realizado exitosamente
        }
        return false; // En caso de que no sea valido
    }

    /* Imprime en consola la factura*/
    public void exportarFactura() {
        System.out.println("=== FACTURA #" + idFactura + " ===");
        System.out.println("Pedido ID: " + idPedido);
        System.out.println("Fecha: " + fechaFactura);
        System.out.println("Valor Total: $" + valorFactura);
    }
    
    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }
}