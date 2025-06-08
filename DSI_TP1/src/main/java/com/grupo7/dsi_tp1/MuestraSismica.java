package com.grupo7.dsi_tp1;

// Dependencies
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Entities
import com.grupo7.dsi_tp1.DetalleMuestraSismica;

/**
 *
 * @author Daniel Dragún
 */
public class MuestraSismica {
    
    private LocalDateTime fechaHoraMuestra;
    
    // 1..* relación con MuestraSismica:
    private List<DetalleMuestraSismica> detalleMuestraSismica = new ArrayList<>();
    
    // Constructor 
    public MuestraSismica(LocalDateTime fechaHoraMuestra, List<DetalleMuestraSismica> detalleMuestraSismica) {
        this.fechaHoraMuestra = fechaHoraMuestra; 
        this.detalleMuestraSismica = detalleMuestraSismica;
    }
    
    // Comportamiento
    public List<Object> getDatos() {
        
        // Definiendo la lista de datos de la muestra sismica
        List<Object> datosMuestrasSismicas = new ArrayList<>();    
        
        for (DetalleMuestraSismica dMuestraSismica : detalleMuestraSismica) {
            
            // Agregando los detalle de la musetra sismica
            datosMuestrasSismicas.add(dMuestraSismica.getDatos());
        }
        
        // retornando los datos registrados de las muestras sismicas
        return datosMuestrasSismicas;
    }
    
    // Getters y Setters
    public LocalDateTime getFechaHoraMuestra() {
        return fechaHoraMuestra;
    }
    
}
