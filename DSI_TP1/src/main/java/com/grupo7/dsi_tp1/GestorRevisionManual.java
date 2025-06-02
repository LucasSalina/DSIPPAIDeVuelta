package com.grupo7.dsi_tp1;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class GestorRevisionManual {
    
    private ArrayList<EventoSismico> eventosSismicos;
    
    public GestorRevisionManual() {
        
    }
    
    public ArrayList<String> buscarEventosSismicosNoRevisados() {
        ArrayList<EventoSismico> eventosSismicosNoRevisados = null;
        for (EventoSismico eventoSismico : eventosSismicos) {
            if (eventoSismico.esAutoDetectadoOPendienteRevision()) {
                return eventoSismico.obtenerDatosPrincipales();
            }
        }
        return null;
    }
    
}
