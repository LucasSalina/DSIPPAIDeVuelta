package com.grupo7.dsi_tp1;

// Dependencies
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Entities
import com.grupo7.dsi_tp1.MuestraSismica;
import com.grupo7.dsi_tp1.Estado; 
import com.grupo7.dsi_tp1.Sismografo;

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
    public List<Object> getDatos(List<Sismografo> sismografos) { 

        List<Object> datosRegistradosMuestraSismica = new ArrayList<>();

        // Buscar el sismografo dueño de esta serie
        for (Sismografo sismografo : sismografos) {
            
            List<String> datosEstacion = sismografo.esTuSeriaTemporal(this);
            
            if (datosEstacion != null && datosEstacion.size() >= 2) {
                
                datosRegistradosMuestraSismica.add(datosEstacion.get(0));
                datosRegistradosMuestraSismica.add(datosEstacion.get(1));
                
                break;
            }

        }

        // Agregar las muestras sismicas 
        for (MuestraSismica mSismica : muestraSismica) {
            datosRegistradosMuestraSismica.add(mSismica.getDatos());
        }

        // Retornando los datos registrados
        return datosRegistradosMuestraSismica;
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