package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class Rol {
    
    private String descripcionRol;
    private String nombre; 
    
    // Constructor
    public Rol(String descripcionRol, String nombre) {
    
        this.descripcionRol = descripcionRol;
        this.nombre = nombre;
    }
    
    public String getNombreRol() {
        return nombre; 
    }
    
}
