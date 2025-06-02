/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.dsi_tp1;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class EventoSismico {
    
    private LocalDateTime fechaHoraOcurrencia;
    private LocalDateTime fechaHoraFin;
    private ArrayList<CambioEstado> cambiosEstados;
    private float latitudEpicentro;
    private float longitudEpicentro;
    private float latitudHipocentro;
    private float longitudHipocentro;
    
    public EventoSismico(ArrayList<CambioEstado> cambiosEstados, LocalDateTime fechaHoraOcurrencia, LocalDateTime fechaHoraFin, float latitudEpicentro, float longitudEpicentro, float longitudHipocentro, float latitudHipocentro) {
        this.cambiosEstados = cambiosEstados;
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
        this.fechaHoraFin = fechaHoraFin;
        this.latitudEpicentro = latitudEpicentro;
        this.longitudEpicentro = longitudEpicentro;
        this.latitudHipocentro = latitudHipocentro;
        this.longitudHipocentro = longitudHipocentro;
    }
    
    public LocalDateTime getFechaHoraOcurrencia() {
        return this.fechaHoraOcurrencia;
    }
    
    public float getLatitudEpicentro() {
        return latitudEpicentro;
    }
    
    public float getLongitudEpicentro() {
        return longitudEpicentro;
    }
    
    public float getLatitudHipocentro() {
        return latitudHipocentro;
    }
    
    public float getLongitudHipocentro() {
        return longitudHipocentro;
    }
    
    
    public ArrayList<String> obtenerDatosPrincipales() {
        ArrayList<String> resultado = new ArrayList<String>();
        resultado.add(getFechaHoraOcurrencia().toString());
        resultado.add(String.valueOf(getLatitudEpicentro()));
        resultado.add(String.valueOf(getLongitudEpicentro()));
        resultado.add(String.valueOf(getLatitudHipocentro()));
        resultado.add(String.valueOf(getLongitudHipocentro()));
        return resultado;
    }
    
    public boolean esAutoDetectadoOPendienteRevision() {
        CambioEstado cambioEstadoActual = null;
        for (CambioEstado cambioEstado : cambiosEstados) {
            if (cambioEstado.esEstadoActual()) {
                cambioEstadoActual = cambioEstado;
                break;
            }
        }
        if (cambioEstadoActual != null) {
            return (cambioEstadoActual.sosAutoDetectado() || cambioEstadoActual.sosPendienteRevision());
        }
        else {
            return false;
        }
    }
    
}
