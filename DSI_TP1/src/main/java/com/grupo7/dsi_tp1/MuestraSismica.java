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
    public void getDatos() {
        // TODO
    }
    
    // Getters y Setters
    public LocalDateTime getFechaHoraMuestra() {
        return fechaHoraMuestra;
    }
    
}
