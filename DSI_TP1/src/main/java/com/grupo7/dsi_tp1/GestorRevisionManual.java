package com.grupo7.dsi_tp1;

// Dependencies
import java.util.List; 
import java.util.ArrayList;

// Entities
import com.grupo7.dsi_tp1.EventoSismico;
import com.grupo7.dsi_tp1.Estado;
import com.grupo7.dsi_tp1.Usuario;

public class GestorRevisionManual {
   
    private EventoSismico eventoSismicoSeleccionado;
    private List<EventoSismico> eventosSismicos = new ArrayList<>(); 
    private List<Estado> estados = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    
    // Constructor
    public GestorRevisionManual(List<EventoSismico> eventosSismicos, List<Estado> estados, List<Usuario> usuarios) {
        
        this.eventosSismicos = eventosSismicos;
        this.estados = estados; 
        this.usuarios = usuarios; 
    }

    // Comportamiento
    public List<List<String>> buscarEventosSismicosNoRevisados() {
        
        // Inicializando la matriz de datos principales de eventos sismicos no revisados
        List<List<String>> eventosSismicosNoRevisados = new ArrayList<>();
        
        // Recorriendo todos los eventos sismicos 
        for (EventoSismico eventoSismico : eventosSismicos) {
        
            // Revisando si el evento sismico es no revisado
            if (eventoSismico.esAutoDetectadoOPendienteRevision()) {
                
                // Agregando el evento sismico al la matriz de datos registrados
                eventosSismicosNoRevisados.add(eventoSismico.obtenerDatosPrincipales());
            }
            
        }
        
        // Devolviendo la matriz de datos principales
        return eventosSismicosNoRevisados;
    }
    
    
}
