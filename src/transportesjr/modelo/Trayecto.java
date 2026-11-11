/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Time;

/* La ruta de transporte a realizar para entregar un pedido */
public class Trayecto {
    private int idTrayecto;
    private int idConductor;
    private int idVehiculo;
    private Date fechaTrayecto;
    private String direccionOrigen;
    private String direccionDestino;
    private Time horaSalida;
    private Time horaLlegada;
    
    // Relación 1 a muchos con Gasto
    private List<Gasto> listaGastos = new ArrayList<>();

    public Trayecto(int idTrayecto, int idConductor, int idVehiculo, Date fechaTrayecto, String direccionOrigen, String direccionDestino, Time horaSalida, Time horaLlegada) {
        this.idTrayecto = idTrayecto;
        this.idConductor = idConductor;
        this.idVehiculo = idVehiculo;
        this.fechaTrayecto = fechaTrayecto;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Trayecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /* Registra un nuego gasto asociado al recorrido */
        public void agregarGasto(Gasto gasto) {
        if (gasto != null) {
            this.listaGastos.add(gasto);
        }
    }

    /* Suma el total de todos los gastos registrados en el trayecto */
    public double calcularGastosTotal() {
        double acumulador = 0;
        for (Gasto gasto : listaGastos) {
            acumulador += gasto.getTotalGasto();
        }
        return acumulador; // Retorna el total de los gastos
    }

    /* Asigna un conductor y vehiculo al trayecto (debe estar disponible y con licencia vigente)
    Al realizar el trayeco, su estado cambia a "No Disponible" */
    public boolean asignarConductorVehiculo(Conductor conductor, Vehiculo vehiculo) {
        if (conductor == null || vehiculo == null) {
            return false;
        }
        if (conductor.validarLicencia() && "Disponible".equalsIgnoreCase(conductor.getEstado())) {
            this.idConductor = conductor.getIdConductor();
            this.idVehiculo = vehiculo.getIdVehiculo();
            conductor.cambiarDisponibilidad(false);
            return true;
        }
        return false;
    }

    /* Captura la hora exacta del sistema como hora de salida */
    public void registrarSalida() {
        this.horaSalida = new Time(System.currentTimeMillis());
    }

    /* Captura la hora exacta del sistema como hora de llegada */
    public void registrarLlegada() {
        this.horaLlegada = new Time(System.currentTimeMillis());
    }
    
    // Getters y Setters

    public int getIdTrayecto() {
        return idTrayecto;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public Date getFechaTrayecto() {
        return fechaTrayecto;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public List<Gasto> getListaGastos() {
        return listaGastos;
    }

    public void setIdTrayecto(int idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setFechaTrayecto(Date fechaTrayecto) {
        this.fechaTrayecto = fechaTrayecto;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setListaGastos(List<Gasto> listaGastos) {
        this.listaGastos = listaGastos;
    }
}