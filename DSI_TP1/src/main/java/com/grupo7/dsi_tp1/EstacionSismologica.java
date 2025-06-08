package com.grupo7.dsi_tp1;

// Dependencies 
import java.time.LocalDateTime; 
import java.util.List;
import java.util.ArrayList;

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
    
    // Comportamiento 
    
    // Obtener los datos de la estacion sismologica: codigoEstacion y nombre
    public List<String> getDatosEstacion() {
        
        // Definiendo la lista de los datos de la estacion
        List<String> datosEstacion = new ArrayList<>();
        
        // Obteniendo los datos de la estacion
        datosEstacion.add(getCodigoEstacion());
        datosEstacion.add(getNombre());
        
        // Retornando los datos de la estacion sismologica
        return datosEstacion;
    }
    
    // Getters
    public String getCodigoEstacion() {
        return codigoEstacion; 
    }
    
    public String getNombre() {
        return nombre; 
    }
}
