/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;
import java.util.Date;

/* Representa a la persona encargada de gestionar los trayectos de productos y vehiculos
Gestiona su disponibilidad y vigencia de licencia de conducir*/
public class Conductor {

    private int idConductor;
    private String nombre;
    private String estado;
    private String telefono;
    private String licencia;
    private Date vencimientoLicencia; // Atributo necesario para el método 4

    public Conductor(int idConductor, String nombre, String estado, String telefono, String licencia, Date vencimientoLicencia) {
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.estado = estado;
        this.telefono = telefono;
        this.licencia = licencia;
        this.vencimientoLicencia = vencimientoLicencia;
    }

    /* Verifica si la licencia del conductor sigue vigente según la fecha actual del sistema*/
    public boolean validarLicencia() {
        Date fechaActual = new Date();
        // Compara matemáticamente la fecha actual del sistema
        // Si la fecha actual es menor a la de vencimiento, el conductor puede manejar
        return !this.vencimientoLicencia.before(fechaActual);
    }
    
    /*Cambia el estado operativo del conductor*/
    public void cambiarDisponibilidad(boolean disponible) {
        this.estado = disponible ? "Disponible" : "No Disponible";
    }

    // Getters y Setters

    public int getIdConductor() {
        return idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getLicencia() {
        return licencia;
    }

    public Date getVencimientoLicencia() {
        return vencimientoLicencia;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setVencimientoLicencia(Date vencimientoLicencia) {
        this.vencimientoLicencia = vencimientoLicencia;
    }
}
