/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

/* Engloba los costos operativos de un trayecto, como gasolina o peajes*/
public class Gasto {
    private int idGasto;
    private int idTrayecto;
    private String tipoGasto;
    private double totalGasto;

    public Gasto(int idGasto, int idTrayecto, String tipoGasto, double totalGasto) {
        this.idGasto = idGasto;
        this.idTrayecto = idTrayecto;
        this.tipoGasto = tipoGasto;
        this.totalGasto = totalGasto;
    }

    // Getters y Setters
    public int getIdGasto() {
        return idGasto;
    }

    public int getIdTrayecto() {
        return idTrayecto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public void setIdTrayecto(int idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public void setTotalGasto(double totalGasto) {
        this.totalGasto = totalGasto;
    }
}