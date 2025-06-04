package com.grupo7.dsi_tp1;

// Dependencies 
import java.time.LocalDateTime; 
import java.util.ArrayList; 
import java.util.List;

// Entities
import com.grupo7.dsi_tp1.EstacionSismologica;
import com.grupo7.dsi_tp1.ModeloSismografo;
import com.grupo7.dsi_tp1.SerieTemporal;
import com.grupo7.dsi_tp1.Estado; 
import com.grupo7.dsi_tp1.CambioEstado;

/**
 *
 * @author Daniel Dragún
 */
public class Sismografo {
    
    private LocalDateTime fechaAdquisicion; 
    private String identificadorSismografo; 
    private Double nroSerie; 
    
    // Relaciones
    private EstacionSismologica estacionSismologica;
    private ModeloSismografo modelo; 
    private List<SerieTemporal> serieTemporal = new ArrayList<>();
    private Estado estadoActual;
    private List<CambioEstado> cambioEstado = new ArrayList<>();
    
    // Constructor 
    public Sismografo(LocalDateTime fechaAdquisicion, String identificadorSismografo,
            Double nroSerie, EstacionSismologica estacionSismologica, 
            ModeloSismografo modelo, List<SerieTemporal> serieTemporal, 
            Estado estadoActual, List<CambioEstado> cambioEstado) {
        
        this.fechaAdquisicion = fechaAdquisicion;
        this.identificadorSismografo = identificadorSismografo; 
        this.nroSerie = nroSerie; 
        this.estacionSismologica = estacionSismologica; 
        this.modelo = modelo; 
        this.serieTemporal = serieTemporal; 
        this.estadoActual = estadoActual;
        this.cambioEstado = cambioEstado; 
    }
    
    // Getters y Setters
    public String getIdentificadorSismografo() {
        return identificadorSismografo; 
    }
    
    public void setEstadoActual(Estado estado) {
        this.estadoActual = estado; 
    } 
}
