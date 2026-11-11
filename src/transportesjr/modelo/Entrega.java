/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

import java.util.Date;

/* Revisa el seguimiento, estado de entrega y observaciones
respecto a la entrega asociada al trayecto */
public class Entrega {
    private int idEntrega;
    private int idTrayecto;
    private String estado;
    private Date fechaEntrega;
    private String observaciones; // Atributo operacional para el método 9

    /* Registra los datos basicos de la entrega */
    public Entrega(int idEntrega, int idTrayecto, String estado, Date fechaEntrega) {
        this.idEntrega = idEntrega;
        this.idTrayecto = idTrayecto;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
    }

    /* Funciona como lugar para registrar posibles problemas respecto a la entrega */
    public void registrarNovedad(String descripcion) {
        this.estado = "Incidente";
        this.observaciones = descripcion;
    }

    /* Actualiza el estado de entrega y lo registra */
    public void registrarEstadoEntrega(String nuevoEstado) {
        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            this.estado = nuevoEstado;
            if ("Entregado".equalsIgnoreCase(nuevoEstado)) {
                this.fechaEntrega = new Date();
            }
        }
    }

    // Getters y Setters

    public int getIdEntrega() {
        return idEntrega;
    }

    public int getIdTrayecto() {
        return idTrayecto;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public void setIdTrayecto(int idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}