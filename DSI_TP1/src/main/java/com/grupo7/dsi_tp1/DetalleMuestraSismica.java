package com.grupo7.dsi_tp1;

// Entities
import com.grupo7.dsi_tp1.TipoDeDato;

/**
 *
 * @author Daniel Dragún
 */
public class DetalleMuestraSismica {
    
    private float valor; 
    
    // Relacion
    private TipoDeDato tipoDeDato;
    
    // Constructor 
    public DetalleMuestraSismica(float valor, TipoDeDato tipoDeDato) {
        this.valor = valor; 
        this.tipoDeDato = tipoDeDato; 
    }
    
    // Comportamiento
    public void getDatos() {
        // implementar
    }
    
}
