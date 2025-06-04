package com.grupo7.dsi_tp1;

// Dependencies
import java.util.List; 
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Comparator;

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
                // Agregando el evento sismico a la matriz de datos registrados
                eventosSismicosNoRevisados.add(eventoSismico.obtenerDatosPrincipales());
            }
        }
        
        // Devolviendo la matriz de datos principales ordenados
        return ordenarPorFechaHoraOcurrencia(eventosSismicosNoRevisados);
    }
    
    public List<List<String>> ordenarPorFechaHoraOcurrencia(List<List<String>> datosPrincipales) {
        // Ordenamos en sitio (ascendente) según el campo 0 parseado a LocalDateTime
        datosPrincipales.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                LocalDateTime dt1 = LocalDateTime.parse(o1.get(0));
                LocalDateTime dt2 = LocalDateTime.parse(o2.get(0));
                return dt1.compareTo(dt2);
            }
        });
        return datosPrincipales;
    }
}
