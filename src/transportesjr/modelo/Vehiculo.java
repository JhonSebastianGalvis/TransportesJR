/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

/* El vehículo de carga que maneja la empresa */
public class Vehiculo {
    private int idVehiculo;
    private int capacidad;
    private String matricula;
    private String modelo;
    private String tipo;

    public Vehiculo(int idVehiculo, int capacidad, String matricula, String modelo, String tipo) {
        this.idVehiculo = idVehiculo;
        this.capacidad = capacidad;
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /* Verifica si el vehículo soporta el peso de un pedido sin exceder su capacidad maxima */
    public boolean verificarCapacidad(double pesoPedido) {
        // Compara el peso del pedido con el atributo capacidad del vehículo
        return pesoPedido > 0 && pesoPedido <= this.capacidad; // Solo si el peso es mayor a 0 y menor o igual a la capacidad
    }

    // Getters y Setters

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}