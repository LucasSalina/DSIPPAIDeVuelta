package com.grupo7.dsi_tp1;

// Dependencies
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Entities
import com.grupo7.dsi_tp1.MuestraSismica;
import com.grupo7.dsi_tp1.Estado; 

/**
 *
 * @author Daniel Dragún
 */
public class SerieTemporal {
    
    private String condicionAlarma;
    private LocalDateTime fechaHoraInicioRegistroMuestras;
    private LocalDateTime fechaHoraRegistros; 
    private double frecuenciaMuestreo;

    // Relaciones
    private List<MuestraSismica> muestraSismica = new ArrayList<>();
    private Estado estado; 
    
    // Constructor
    public SerieTemporal(String condicionAlarma, LocalDateTime fechaHoraInicioRegistroMuestras,
            LocalDateTime fechaHoraRegistros, double frecuenciaMuestreo, 
            List<MuestraSismica> muestraSismica, Estado estado) {

        this.condicionAlarma = condicionAlarma; 
        this.fechaHoraInicioRegistroMuestras = fechaHoraInicioRegistroMuestras;
        this.fechaHoraRegistros = fechaHoraRegistros; 
        this.frecuenciaMuestreo = frecuenciaMuestreo; 
        this.muestraSismica = muestraSismica; 
        this.estado = estado; 
        
    }
    
    // Comportamiento
    public void getDatos() { // TODO
        for (MuestraSismica m : muestraSismica) {
            // procesar cada muestra
            System.out.println("Muestra en: " + m.getFechaHoraMuestra());
        }
    }

    
    // Getters y setters 
    public String getCondicionAlarma() {
        return condicionAlarma;
    }
    public void setCondicionAlarma(String condicionAlarma) {
        this.condicionAlarma = condicionAlarma;
    }
    public LocalDateTime getFechaHoraInicioRegistroMuestras() {
        return fechaHoraInicioRegistroMuestras;
    }
    public void setFechaHoraInicioRegistroMuestras(LocalDateTime fechaHoraRegistroMuestras) {
        this.fechaHoraInicioRegistroMuestras = fechaHoraRegistroMuestras;
    }
    public LocalDateTime getFechaHoraRegistros() {
        return fechaHoraRegistros;
    }
    public void setFechaHoraRegistros(LocalDateTime fechaHoraRegistros) {
        this.fechaHoraRegistros = fechaHoraRegistros;
    }
    public double getFrecuenciaMuestreo() {
        return frecuenciaMuestreo;
    }
    public void setFrecuenciaMuestreo(double frecuenciaMuestreo) {
        this.frecuenciaMuestreo = frecuenciaMuestreo;
    }

    public void setMuestrasSismicas(List<MuestraSismica> muestrasSismicas) {
        this.muestraSismica = muestrasSismicas;
    }
}