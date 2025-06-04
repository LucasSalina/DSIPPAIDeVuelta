package com.grupo7.dsi_tp1;

// Entities 
import com.grupo7.dsi_tp1.Fabricante;

/**
 *
 * @author Daniel Dragún 
 */
public class ModeloSismografo {
    
    private String características; 
    private String nombreModelo; 
    
    // Relacion
    private Fabricante fabricante; 
    
    // Constructor
    public ModeloSismografo(String caracteristicas, String nombreModelo, Fabricante fabricante) {
        this.características = caracteristicas; 
        this.nombreModelo = nombreModelo;
        this.fabricante = fabricante; 
    }
    
    // Getters
    public Fabricante getFabricante() {
        return fabricante; 
    }
    
    public String getNombreModelo() {
        return nombreModelo;
    }
}
