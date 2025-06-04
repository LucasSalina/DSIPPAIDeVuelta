package com.grupo7.dsi_tp1;

// Dependencies
import java.util.ArrayList;
import java.util.List; 

// Entities
import com.grupo7.dsi_tp1.Permiso;

/**
 *
 * @author Daniel Dragún
 */
public class Perfil {
    
    private String descripcion; 
    private String nombre;
    
    // Relaciones
    private List<Permiso> permiso = new ArrayList<>();
    
    // Constructor 
    public Perfil(String descripcion, String nombre, List<Permiso> permiso) {
        
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.permiso = permiso;
              
    }
    
    // Setter y Getters
    public String getDescripcion() {
        return descripcion; 
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Permiso> getPermisos() {
        return permiso; 
    }
    
    public void setPermisos(List<Permiso> permiso) {
        this.permiso = permiso;
    }
}
