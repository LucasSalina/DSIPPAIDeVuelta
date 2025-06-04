package com.grupo7.dsi_tp1;

// Dependencies
import java.util.ArrayList;
import java.util.List;

// Entities
import com.grupo7.dsi_tp1.Perfil; 

/**
 *
 * @author Daniel Dragún
 */
public class Usuario {
    
   private String contraseña;
   private String nombreUsuario; 
   
   // Relaciones 
   private List<Perfil> perfil = new ArrayList<>();
   
   // Constructor
   public Usuario(String contraseña, String nombreUsuario, List<Perfil> pefil) {
       
       this.contraseña = contraseña;
       this.nombreUsuario = nombreUsuario;
       this.perfil = perfil; 
   }
   
   // Método para obtener el RI (Responsable de Inspeccion) Logueado
   public void getRILogueado() {
       // TODO 
   }
    
}
