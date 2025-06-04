package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class Permiso {
    
    private String descripcion; 
    private String nombre; 
    
    // Constructor
    public Permiso(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    
    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre; 
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
}
