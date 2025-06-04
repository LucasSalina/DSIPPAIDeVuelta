package com.grupo7.dsi_tp1;

// Dependencies 
import java.time.LocalDateTime; 

/**
 *
 * @author Daniel Dragún
 */
public class EstacionSismologica {
    
    private String codigoEstacion; 
    private String documentoCertificacionAdq; 
    private LocalDateTime fechaSolicitudCertificacion; 
    private float latitud; 
    private float longitud; 
    private String nombre; 
    private Double nroCertificacionAdquisicion; 
    
    // Constructor
    public EstacionSismologica(String codigoEstacion, String documentoCertificacionAdq,
            LocalDateTime fechaSolicitudCertificacion, float latitud, float longitud,
            String nombre, Double nroCertificacionAdquisicion) {
    
        this.codigoEstacion = codigoEstacion; 
        this.documentoCertificacionAdq = documentoCertificacionAdq;
        this.fechaSolicitudCertificacion = fechaSolicitudCertificacion; 
        this.latitud = latitud; 
        this.longitud = longitud; 
        this.nombre = nombre; 
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion; 
        
    }
    
    // Getters
    public String getCodigoEstacion() {
        return codigoEstacion; 
    }
    
    public String getNombre() {
        return nombre; 
    }
}
