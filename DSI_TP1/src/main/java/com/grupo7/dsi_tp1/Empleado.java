package com.grupo7.dsi_tp1;

// Entities
import com.grupo7.dsi_tp1.Rol;

/**
 *
 * @author Daniel Dragún
 */
public class Empleado {
    
    private String apellido; 
    private String mail; 
    private String nombre; 
    private String telefono; 
    
    // Relaciones
    private Rol rol;
    
    // Constructor
    public Empleado(String apellido, String mail, String nombre, String telefono, Rol rol) {
    
        this.apellido = apellido;
        this.mail = mail; 
        this.nombre = nombre;
        this.telefono = telefono; 
        this.rol = rol;
    }
    
    // Constructor sin parametros
    public Empleado() {
    
    }
    
    // Comportamiento
    public boolean esResponsableDeReparacion( ){
        
        return true;
    }
    
    // Getter
    public String obtenerMail() {
        return mail; 
    }
}
