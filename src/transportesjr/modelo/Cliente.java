/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.modelo;

import java.util.ArrayList;
import java.util.List;

/*Almacena los datos de contacto y el historial de pedidos realizador por un cliente
dentro del sistema de Transportes JR*/
public class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Pedido> historialPedidos;

    /* Inicia un nuevo cliente con un historial vacio*/
    public Cliente(int idCliente, String nombre, String direccion, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.historialPedidos = new ArrayList<>();
    }
    
    /* Valida que el nombre y el telefono sean datos obligatorios minimos*/
    public boolean registrarCliente() { 
        return this.nombre != null && !this.nombre.trim().isEmpty() 
            && this.telefono != null && !this.telefono.trim().isEmpty(); 
    }
    
    /* Permite actualizar la dirección y/o teléfono del cliente
    mientras los nuevos valores no esten vacios*/    
    public void datosCliente(String direccion, String telefono) {
        if (direccion != null && !direccion.trim().isEmpty()) {
            this.direccion = direccion;
        }
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono;
        }
    }

    /* Añade un pedido válido al historial del cliente */
    public void agregarPedidoHistorial(Pedido pedido) {
        if (pedido != null) {
            this.historialPedidos.add(pedido);
        }
    }
    
    /* Devuelve una copia de la lista de pedidos para proteger el original*/
    public List<Pedido> consultarHistorialPedidos() { 
        return new ArrayList<>(this.historialPedidos); 
    }

    // Getters y Setters

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
