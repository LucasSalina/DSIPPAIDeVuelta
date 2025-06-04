package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class AlcanceSismo {
    
    private String descripcion;
    private String nombre;
    
    // Constructor
    public AlcanceSismo(String descripcion, String nombre) {
        this.descripcion = descripcion; 
        this.nombre = nombre; 
    }
    
    // Getter
    public String getNombre() {
        return nombre;
    }
    
}
