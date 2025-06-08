package com.grupo7.dsi_tp1;

/**
 *
 * @author Daniel Dragún
 */
public class TipoDeDato {
    
    private String denominacion; 
    private String nombreUnidadMedida; 
    private Double valorUmbral; 
    
    public TipoDeDato(String denominacion, String nombreUnidadMedida, Double valorUmbral) {
        this.denominacion = denominacion; 
        this.nombreUnidadMedida = nombreUnidadMedida;
        this.valorUmbral = valorUmbral; 
    }
    
    
    public String getDenominacion() {
        
        return denominacion; 
    }
    
    public String getNombreUnidadMedida() {
        
        return nombreUnidadMedida;
    }
    
}
