package com.grupo7.dsi_tp1;

// Dependencies
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

// Entities
import com.grupo7.dsi_tp1.SerieTemporal;
import com.grupo7.dsi_tp1.CambioEstado;
import com.grupo7.dsi_tp1.Estado;
import com.grupo7.dsi_tp1.ClasificacionSismo;
import com.grupo7.dsi_tp1.MagnitudRitcher;
import com.grupo7.dsi_tp1.OrigenDeGeneracion;
import com.grupo7.dsi_tp1.AlcanceSismo;
import com.grupo7.dsi_tp1.Empleado;

public class EventoSismico {
    
    private LocalDateTime fechaHoraOcurrencia;
    private LocalDateTime fechaHoraFin;
    private float latitudEpicentro;
    private float longitudEpicentro;
    private float latitudHipocentro;
    private float longitudHipocentro;
    private int valorMagnitud;
    
    // Relaciones
    private List<CambioEstado> cambioEstado = new ArrayList<>();
    private Estado estadoActual;
    private List<SerieTemporal> serieTemporal = new ArrayList<>();
    private ClasificacionSismo clasificacion;
    private MagnitudRitcher magnitud; 
    private OrigenDeGeneracion origenGeneracion;
    private AlcanceSismo alcanceSismo; 
    private Empleado analistaSupervisor; 

    // Constructor
    public EventoSismico(LocalDateTime fechaHoraOcurrencia, LocalDateTime fechaHoraFin, 
            float latitudEpicentro, float longitudEpicentro, float longitudHipocentro, 
            float latitudHipocentro, int valorMagnitud, List<CambioEstado> cambioEstado, 
            Estado estadoActual, List<SerieTemporal> serieTemporal, ClasificacionSismo clasificacion,
            MagnitudRitcher magnitud, OrigenDeGeneracion origenGeneracion,
            AlcanceSismo alcanceSismo, Empleado analistaSupervisor) {
        
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
        this.fechaHoraFin = fechaHoraFin;
        this.latitudEpicentro = latitudEpicentro;
        this.longitudEpicentro = longitudEpicentro;
        this.latitudHipocentro = latitudHipocentro;
        this.longitudHipocentro = longitudHipocentro;
        this.valorMagnitud = valorMagnitud; 
        this.cambioEstado = cambioEstado;
        this.estadoActual = estadoActual;
        this.serieTemporal = serieTemporal;
        this.clasificacion = clasificacion;
        this.magnitud = magnitud;
        this.origenGeneracion = origenGeneracion;
        this.alcanceSismo = alcanceSismo;
        this.analistaSupervisor = analistaSupervisor; 
    }
    
    // Comportamiento
    public List<String> obtenerDatosPrincipales() {
       
        // Definiendo la lista de datos principales del evento sismico
        List<String> datosPrincipales = new ArrayList<>();
        
        // Obteniendo los datos principales
        datosPrincipales.add(getFechaHoraOcurrencia().toString());
        datosPrincipales.add(String.valueOf(getLatitudEpicentro()));
        datosPrincipales.add(String.valueOf(getLongitudEpicentro()));
        datosPrincipales.add(String.valueOf(getLatitudHipocentro()));
        datosPrincipales.add(String.valueOf(getLongitudHipocentro()));
        
        // Retornando los datos principales del evento sismico
        return datosPrincipales; 
        
    }
    
    // Método para saber si un evento sismico es No Revisado
    public boolean esAutoDetectadoOPendienteRevision() {
        
       // Recorriendo los cambios de estado del evento sismico
       for (CambioEstado cambioDeEstado : cambioEstado) {
       
           // Verificando si el cambio de estado es estado actual
           if (cambioDeEstado.esEstadoActual()) {
           
               // Verificando si es AutoDetectado
               if (cambioDeEstado.sosAutoDetectado()) {
                   
                   // Afirmando que el evento sismico es no revisado
                   return true;
                   
               }
               
               // Verificando si es PendienteRevision
               if (cambioDeEstado.sosPendienteRevision()) {
               
                   // Afirmando que el evento sismico es no revisado
                   return true; 
               }
           }
       }
       
       // Afirmando que el evento sismico es revisado
       return false; 
       
    }
    
    // Getters
    public LocalDateTime getFechaHoraOcurrencia() {
        return this.fechaHoraOcurrencia;
    }
    
    public float getLatitudEpicentro() {
        return this.latitudEpicentro;
    }
    
    public float getLongitudEpicentro() {
        return this.longitudEpicentro;
    }
    
    public float getLatitudHipocentro() {
        return this.latitudHipocentro;
    }
    
    public float getLongitudHipocentro() {
        return this.longitudHipocentro;
    }

    public LocalDateTime getFechaHoraFin() {
        return this.fechaHoraFin;
    }
    
    public AlcanceSismo getAlcance() {
        return this.alcanceSismo; 
    }
    
    public int valorMagnitud() {
        return this.valorMagnitud; 
    }
    
    public OrigenDeGeneracion getOrigen() {
        return origenGeneracion; 
    }
    
    public ClasificacionSismo getClasificacion() {
        return clasificacion; 
    }
    
}
