/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.dsi_tp1;

/**
 *
 * @author alumno
 */
public class Estado {
    
    private String ambito;
    private String nombreEstado;
    
    public Estado() {
    
    }
    
    public boolean sosAutoDetectado() {
        return "Autodetectado".equals(nombreEstado);
    }
    
    public boolean sosPendienteRevision() {
        return "PendienteRevision".equals(nombreEstado);
    }
}
