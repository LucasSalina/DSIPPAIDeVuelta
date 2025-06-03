package com.grupo7.dsi_tp1;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class GestorRevisionManual {
    
    private ArrayList<EventoSismico> eventosSismicos;
    private EventoSismico eventoSismicoSeleccionado;
    
    public GestorRevisionManual() {
        
    }
    
    public ArrayList<ArrayList<String>> buscarEventosSismicosNoRevisados() {
        ArrayList<ArrayList<String>> datosEventosSismicosNoRevisados = new ArrayList<>();
        for (EventoSismico eventoSismico : eventosSismicos) {
            if (eventoSismico.esAutoDetectadoOPendienteRevision()) {
                datosEventosSismicosNoRevisados.add(eventoSismico.obtenerDatosPrincipales());
            }
        }
        return ordenarPorFechaHoraOcurrencia(datosEventosSismicosNoRevisados);
    }
    
    
    public ArrayList<ArrayList<String>> ordenarPorFechaHoraOcurrencia(ArrayList<ArrayList<String>> datosEventosSismicos) {
        if (datosEventosSismicos == null || datosEventosSismicos.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        ArrayList<ArrayList<String>> listaTemporal = new ArrayList<>(datosEventosSismicos);
        for (int i = 0; i < datosEventosSismicos.size(); i++) {
            int minVal = Integer.MAX_VALUE; // Initialize with a very large value
            int minIndex = -1;

            // Find the smallest element in the current 'temporaryList'
            for (int j = 0; j < listaTemporal.size(); j++) {
                if (listaTemporal.get(j) < minVal) {
                    minVal = listaTemporal.get(j);
                    minIndex = j;
                }
            }

            // Add the found minimum value to the sorted list
            sortedList.add(minVal);

            // Remove the element from the temporary list
            // This ensures it's not selected again in subsequent iterations
            if (minIndex != -1) {
                temporaryList.remove(minIndex);
            }
        }

        return sortedList;
    }
    
    public ArrayList<String> tomarSeleccionEventoSismico(EventoSismico seleccionEventoSismico) {
        
        return null;
    }
    
    public ArrayList<String> bloquearEventoSismicoSeleccionado() {
        return null;
    }
}
