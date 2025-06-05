package com.grupo7.dsi_tp1;

// Dependencies
import java.util.ArrayList;
import java.util.List;

// Entities
import com.grupo7.dsi_tp1.Perfil; 
import com.grupo7.dsi_tp1.Empleado; 

/**
 *
 * @author Daniel Dragún
 */
public class Usuario {
    
   private String contraseña;
   private String nombreUsuario; 
   
   // Relaciones 
   private List<Perfil> perfil = new ArrayList<>();
   private Empleado empleado;
   
   // Constructor
   public Usuario(String contraseña, String nombreUsuario, List<Perfil> pefil, Empleado empleado) {
       
       this.contraseña = contraseña;
       this.nombreUsuario = nombreUsuario;
       this.perfil = perfil; 
   }
   
   // Método para obtener el RI (Responsable de Inspeccion) Logueado
   public Empleado getRILogueado() {
       
        // Verificando si soy el usuario con el nombre "analista001"
        if (nombreUsuario.equals("analista001")) {
        
            // Retornando el empleado
            return empleado;
        
        }
        
        return null; 
   }
    
}
