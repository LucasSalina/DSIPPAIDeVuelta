package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class ClasificacionSismo {
    
    private float kmProfundidadDesde;
    private float kmProfundidadHasta; 
    private String nombre; 
    
    // Constructor
    public ClasificacionSismo(float kmProfundidadDesde, float kmProfundidadHasta, 
            String nombre) {
        
        this.kmProfundidadDesde = kmProfundidadDesde; 
        this.kmProfundidadHasta = kmProfundidadHasta; 
        this.nombre = nombre;
    }
    
    // Getter
    public String getNombre() {
        return nombre;
    }
    
}
