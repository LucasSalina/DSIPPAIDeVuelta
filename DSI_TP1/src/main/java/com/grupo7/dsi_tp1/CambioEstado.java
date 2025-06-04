package com.grupo7.dsi_tp1;

// Dependencies
import java.time.LocalDateTime; 

// Entities
import com.grupo7.dsi_tp1.Estado;
import com.grupo7.dsi_tp1.Empleado;

public class CambioEstado {
    
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio; 
    
    // Relaciones
    private Estado estado;
    private Empleado responsableInspeccion; 

    // Constructor
    public CambioEstado(Estado estado, Empleado responsableInspeccion, LocalDateTime fechaHoraInicio) {
       this.estado = estado; 
       this.responsableInspeccion = responsableInspeccion;
       this.fechaHoraInicio = fechaHoraInicio; 
    }
    
    // Comportamiento
    
    // Verificando si es el estado actual del evento sismico
    public boolean esEstadoActual() {
        
        // Verificando que la fechaFin sea null
        if (this.fechaHoraFin == null) {
            return true;
        }
        
        return false;
    }
    
    public boolean sosAutoDetectado() {
        return this.estado.sosAutoDetectado();
    }
    
    public boolean sosPendienteRevision() {
        return this.estado.sosPendienteRevision();
    }
    
    // Getter
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin; 
    }
    
}
