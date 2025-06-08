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
import com.grupo7.dsi_tp1.Sismografo;
import com.grupo7.dsi_tp1.Ventana1;

public class GestorRevisionManual {
   
    private EventoSismico eventoSismicoSeleccionado;
    private List<EventoSismico> eventosSismicos = new ArrayList<>(); 
    private List<Estado> estados = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Sismografo> sismografos = new ArrayList<>();
    private Ventana1 pantallaRevisionManual;
    
    // Constructor
    public GestorRevisionManual(List<EventoSismico> eventosSismicos, List<Estado> estados,
            List<Usuario> usuarios, List<Sismografo> sismografos, Ventana1 pantallaRevisionManual) {
        this.eventosSismicos = eventosSismicos;
        this.estados = estados; 
        this.usuarios = usuarios; 
        this.sismografos = sismografos; 
        this.pantallaRevisionManual = pantallaRevisionManual;
    }

    // Comportamiento
    
    // Registrar Resultado de Revision Manual - Flujo
    public void registrarResultadoRevisionManual() {
        
        // Mostrar el pantalla los datos principales de lso evento sissmicos no registrados
        this.pantallaRevisionManual.mostarEventosSismicosYSolicitarSeleccion(buscarEventosSismicosNoRevisados());
    }
    
    // Buscar los eventos sismicos no revisados, es decir, que tengan estado PendienteRevision o AutoDetectado
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
    
    // Ordenar los datos principales de los eventos sismicos no seleccionados
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
    
    // Tomar los datos principales del evento sismico seleccioando y encontrar al evento sismico seleccionado
    public void tomarSeleccionEventoSismico(List<String> datosPrincipales) {
        System.out.println("Evento sísmico seleccionado:");
        for (String s : datosPrincipales) {
            System.out.println("- " + s);
        }

        // Obtener el evento sismico seleccionado
        for (EventoSismico eventoSismico : eventosSismicos) {
            if (eventoSismico.sonMisDatosPrincipales(datosPrincipales)) {
                this.eventoSismicoSeleccionado = eventoSismico;
                System.out.println("EventoSismicoSeleccionado del gestor: " + this.eventoSismicoSeleccionado);
                break;
            }
        }

        // Bloquear el evento sismico seleccionado
        if (this.eventoSismicoSeleccionado != null) {
            bloquearEventoSismicoSeleccioando();
            System.out.println("El evento sismico seleccionado ha sido bloqueado.");
        }

        // Obtener metadatos del evento
        List<String> metadatosEvento = obtenerMetadatosDelEvento();
        System.out.println("Metadatos del evento: " + metadatosEvento);

        // Obtener datos registrados de series temporales
        List<List<Object>> datosSeries = buscarDatosRegistrados(sismografos);

        // Ordenar por Estación Sismológica
        List<List<Object>> datosSeriesOrdenados = ordenarDatosRegistrados(datosSeries);

        // Mostrar en la pantalla (invocar el método nuevo de la pantalla)
        pantallaRevisionManual.mostrarDatosSismicosRegistrados(
            datosPrincipales,
            metadatosEvento,
            datosSeriesOrdenados
        );
    }

    
    // Obtener la fecha y la hora actual del sistema
    public LocalDateTime getFechaHoraActual() {
        return LocalDateTime.now();
    } 
    
    // Cambiar el estado del evento sismico seleccioando a BloqueadoEnRevision
    public void bloquearEventoSismicoSeleccioando() {
    
        // Obteniendo la fecha y la hora actual del sistema
        LocalDateTime fechaHoraActual = getFechaHoraActual();
        
        // Defiendo el estado bloqueado
        Estado estadoBloqueado = new Estado();
        
        // Definiendo el empleado responsable del cambio de estado
        Empleado empleadoResponsableDeInspeccion = new Empleado(); 
        
        // Obtener el esatdo BloqueadoEnRevision
        for (Estado estado : estados) {
            
            if (estado.sosBloqueadoEnRevision()) {
            
                // Estado bloqueado en revision encontrado
                estadoBloqueado = estado; 
                
                break; 
            }
        }
        
        // Obtener al emplaado logueado responsable del cambio de estado del evento sismico selecionado
        for (Usuario usuario : usuarios) {
            
            // Verificando si el usuario está logueado
            if (usuario.getRILogueado() != null) {
                
                // Asignando el empleado 
                empleadoResponsableDeInspeccion = usuario.getRILogueado();
            }
        }
        
        // Bloqueando el evento sismico selccionado
        this.eventoSismicoSeleccionado.bloquearPorRevision(estadoBloqueado, fechaHoraActual, empleadoResponsableDeInspeccion);
        System.out.println("Evento Sismico bloqueado por revision: " + this.eventoSismicoSeleccionado + estadoBloqueado);
        
    }
    
    // Obtener los metadatos del evento sismico selccioando: alcance, origen de generacion y clasificacion
    public List<String> obtenerMetadatosDelEvento() {
        
        List<String> metadatosEventoSismico = this.eventoSismicoSeleccionado.obtenerMetadatosDelEvento();
        
        return metadatosEventoSismico;
        
    }
    
    public List<List<Object>> buscarDatosRegistrados(List<Sismografo> sismografos) {
        
        // Definiendo la lista de datos registrados
        List<List<Object>> listaDatosRegistrados = new ArrayList<>();

        // consumir buscar dartosRegistrados de evento sismico seleccionado
        listaDatosRegistrados = this.eventoSismicoSeleccionado.buscarDatosRegistrados(sismografos);    

        // Retornando los datos registrados desordenados del evento sismico seleccionado 
        return listaDatosRegistrados; 
    
    }
    
    // Ordenar datos registrados de evento sismico
    public List<List<Object>> ordenarDatosRegistrados(List<List<Object>> datosRegistrados) {

        datosRegistrados.sort((serie1, serie2) -> {

            // Si la lista está vacía, la mandamos al final
            if (serie1.isEmpty()) return 1;
            if (serie2.isEmpty()) return -1;

            // Si el primer elemento no es String, lo mandamos al final
            if (!(serie1.get(0) instanceof String) || !(serie2.get(0) instanceof String)) return 0;

            String codigo1 = (String) serie1.get(0); // codigoEstacion
            String codigo2 = (String) serie2.get(0);

            return codigo1.compareTo(codigo2);
        });

        return datosRegistrados;
    }
}