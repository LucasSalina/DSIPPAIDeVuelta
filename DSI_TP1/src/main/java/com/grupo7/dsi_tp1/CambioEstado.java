/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.dsi_tp1;
public class CambioEstado {
    
    private Estado estado;
    
    public CambioEstado(Estado estado) {
       this.estado = estado; 
    }
    public boolean esEstadoActual() {
        return true;
    }
    
    public boolean sosAutoDetectado() {
        return this.estado.sosAutoDetectado();
    }
    
    public boolean sosPendienteRevision() {
        return this.estado.sosPendienteRevision();
    }
}
