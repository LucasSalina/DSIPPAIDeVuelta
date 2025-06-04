package com.grupo7.dsi_tp1;

/**
 *
 * @author alumno
 */
public class Estado {
    
    private String ambito;
    private String nombreEstado;
    
    // Constructor
    public Estado(String ambito, String nombreEstado) {
        
        this.ambito = ambito; 
        this.nombreEstado = nombreEstado;
    }
    
    // Comportamiento
    public boolean sosAutoDetectado() {
        return "Autodetectado".equals(nombreEstado);
    }
    
    public boolean sosPendienteRevision() {
        return "PendienteRevision".equals(nombreEstado);
    }
    
    public boolean sosBloqueadoEnRevision() {
        return "PendienteRevision".equals(nombreEstado);
    }
    
    public boolean sosDerivadoAExperto() {
        return "DeivadoAExperto".equals(nombreEstado);
    }
}
