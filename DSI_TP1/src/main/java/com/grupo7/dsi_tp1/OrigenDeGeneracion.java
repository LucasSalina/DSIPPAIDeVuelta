package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class OrigenDeGeneracion {
    
    private String descripcion;
    private String nombre;
    
    // Constructor 
    public OrigenDeGeneracion(String descripcion, String nombre) {
        this.descripcion = descripcion; 
        this.nombre = nombre; 
    }
    
    public String getNombre() {
        return nombre; 
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
