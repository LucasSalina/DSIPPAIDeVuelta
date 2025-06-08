package com.grupo7.dsi_tp1;

import java.util.List;
import java.util.ArrayList; 

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
    public List<Object> getDatos() {
        
        // Definiendo la lista de datos del detalle la muestra simsica
        List<Object> datosDetalleMuestraSismica = new ArrayList<>();
        
        // Obtener la denominación y el nombre de la unidad de medida y el valor del tipo de dato
        datosDetalleMuestraSismica.add(this.tipoDeDato.getDenominacion());
        datosDetalleMuestraSismica.add(this.tipoDeDato.getNombreUnidadMedida());
        datosDetalleMuestraSismica.add(getValor());
        
        // retornando los datos del detalle de la muestra sismica
        return datosDetalleMuestraSismica; 
    }
    
    // Getters y Setters
    public float getValor() {
        return valor;
    }
    
    public void getValor(float valor) {
        this.valor = valor;
    }
    
    public TipoDeDato getTipoDeDato() {
        return tipoDeDato; 
    }
    
    public void setTipoDeDato(TipoDeDato tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }
    
}
