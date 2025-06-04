package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class Fabricante {
    
    private String nombre; 
    private String razonSocial; 
    
    // Constructor
    public Fabricante(String nombre, String razonSocial) {
        
        this.nombre = nombre; 
        this.razonSocial = razonSocial; 
    }
    
    // Getter
    public String getNombreFabricante() {
        return nombre; 
    }
}
