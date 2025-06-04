package com.grupo7.dsi_tp1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase auxiliar que inicializa en memoria instancias de todas las entidades
 * y objetos de la aplicación, usando datos de ejemplo coherentes entre sí.
 */
public class DataInitializer {

    // Listas estáticas que contendrán las instancias
    public static List<Estado>          listaEstados;
    public static List<Rol>             listaRoles;
    public static List<Permiso>         listaPermisos;
    public static List<Perfil>          listaPerfiles;
    public static List<Usuario>         listaUsuarios;
    public static List<Fabricante>      listaFabricantes;
    public static List<ModeloSismografo> listaModelos;
    public static List<EstacionSismologica> listaEstaciones;
    public static List<Sismografo>      listaSismografos;
    public static List<ClasificacionSismo> listaClasificaciones;
    public static List<OrigenDeGeneracion> listaOrigenes;
    public static List<AlcanceSismo>    listaAlcances;
    public static List<MagnitudRitcher> listaMagnitudes;
    public static List<TipoDeDato>      listaTiposDeDato;
    public static List<DetalleMuestraSismica> listaDetalles;
    public static List<MuestraSismica>  listaMuestras;
    public static List<SerieTemporal>   listaSeries;
    public static List<Empleado>        listaEmpleados;
    public static List<CambioEstado>    listaCambios;
    public static List<EventoSismico>   listaEventos;
    
    /**
     * Genera todas las instancias de ejemplo y las almacena en las listas estáticas.
     * Debe invocarse una sola vez, al iniciar la aplicación.
     */
    public static void initializeAll() {
        crearEstados();
        crearRolesPermisosPerfilesUsuarios();
        crearFabricantesModelosEstaciones();
        crearClasificacionesOrigenesAlcancesMagnitudes();
        crearTiposYDetallesMuestras();
        crearEmpleadosYCambiosEstado();
        crearSeriesYMuestras();
        crearSismografos();
        crearEventosSismicos();
    }

    private static void crearEstados() {
        listaEstados = new ArrayList<>();
        // Estados para ámbito “Sismografo”
        listaEstados.add(new Estado("Sismografo", "Disponible"));
        listaEstados.add(new Estado("Sismografo", "EnInstalacion"));
        listaEstados.add(new Estado("Sismografo", "EnLinea"));
        listaEstados.add(new Estado("Sismografo", "FueraDeServicio"));
        listaEstados.add(new Estado("Sismografo", "Reparacion"));
        // Estados para ámbito “EventoSismico”
        listaEstados.add(new Estado("EventoSismico", "Autodetectado"));
        listaEstados.add(new Estado("EventoSismico", "PendienteRevision"));
        listaEstados.add(new Estado("EventoSismico", "BloqueadoEnRevision"));
        listaEstados.add(new Estado("EventoSismico", "DerivadoAExperto"));
        listaEstados.add(new Estado("EventoSismico", "Confirmado"));
        listaEstados.add(new Estado("EventoSismico", "Rechazado"));
        // Otros estados puntuales (limite de 15 por tipo)
        listaEstados.add(new Estado("EventoSismico", "Cerrado"));
        listaEstados.add(new Estado("Sismografo", "InhabilitadoPorInspeccion"));
    }

    private static void crearRolesPermisosPerfilesUsuarios() {
        // 1) PERMISOS (hasta 15)
        listaPermisos = new ArrayList<>();
        listaPermisos.add(new Permiso("Permite registrar un usuario", "RegistrarUsuario"));
        listaPermisos.add(new Permiso("Permite modificar un usuario", "ModificarUsuario"));
        listaPermisos.add(new Permiso("Permite eliminar un usuario", "EliminarUsuario"));
        listaPermisos.add(new Permiso("Permite registrar perfil", "RegistrarPerfil"));
        listaPermisos.add(new Permiso("Permite asignar perfil a usuario", "AsignarPerfil"));
        listaPermisos.add(new Permiso("Permite registrar sismógrafo", "RegistrarSismografo"));
        listaPermisos.add(new Permiso("Permite registrar estación sismológica", "RegistrarEstacion"));
        listaPermisos.add(new Permiso("Permite revisar evento sísmico", "RevisarEvento"));
        listaPermisos.add(new Permiso("Permite generar reportes", "GenerarReporte"));
        listaPermisos.add(new Permiso("Permite gestionar mantenimiento", "GestionarMantenimiento"));
        listaPermisos.add(new Permiso("Permite suscribir interesado", "SuscribirInteresado"));
        listaPermisos.add(new Permiso("Permite anular suscripción", "AnularSuscripcion"));

        // 2) ROLES
        listaRoles = new ArrayList<>();
        Rol rolAdminUsuarios   = new Rol("Rol de administrador de usuarios", "AdministradorUsuarios");
        Rol rolAdminRed        = new Rol("Rol de administrador de red sísmica", "AdministradorRed");
        Rol rolAnalista        = new Rol("Rol de analista en sismos", "AnalistaSismos");
        Rol rolSupervisor      = new Rol("Rol de analista supervisor", "SupervisorSismos");
        Rol rolInspeccion      = new Rol("Rol de responsable de inspecciones", "ResponsableInspeccion");
        Rol rolReportes        = new Rol("Rol de consultor de reportes", "ConsultorReportes");
        Rol rolInteresado      = new Rol("Rol de interesado en sismos", "InteresadoSismos");
        listaRoles.addAll(Arrays.asList(
            rolAdminUsuarios,
            rolAdminRed,
            rolAnalista,
            rolSupervisor,
            rolInspeccion,
            rolReportes,
            rolInteresado
        ));

        // 3) PERFILES (cada uno agrupa uno o varios permisos)
        listaPerfiles = new ArrayList<>();
        // Perfil “AdministradorUsuarios” agrupa permisos sobre usuarios y perfiles
        Perfil perfilAdminUsuarios = new Perfil(
            "Perfil para administradores de usuarios",
            "PERFIL_ADMIN_USUARIOS",
            Arrays.asList(
                listaPermisos.get(0), // RegistrarUsuario
                listaPermisos.get(1), // ModificarUsuario
                listaPermisos.get(2), // EliminarUsuario
                listaPermisos.get(3), // RegistrarPerfil
                listaPermisos.get(4)  // AsignarPerfil
            )
        );
        // Perfil “AdministradorRed” agrupa permisos de red (sismógrafos, estaciones)
        Perfil perfilAdminRed = new Perfil(
            "Perfil para administradores de red sísmica",
            "PERFIL_ADMIN_RED",
            Arrays.asList(
                listaPermisos.get(5), // RegistrarSismografo
                listaPermisos.get(6)  // RegistrarEstacion
            )
        );
        // Perfil “AnalistaSismos” agrupa permisos de revisión de eventos
        Perfil perfilAnalista = new Perfil(
            "Perfil para analistas de sismos",
            "PERFIL_ANALISTA",
            Arrays.asList(
                listaPermisos.get(7)  // RevisarEvento
            )
        );
        // Perfil “SupervisorSismos” agrupa permisos de supervisión de eventos
        Perfil perfilSupervisor = new Perfil(
            "Perfil para supervisores de sismos",
            "PERFIL_SUPERVISOR",
            Arrays.asList(
                listaPermisos.get(7)  // RevisarEvento (mismo permiso de revisión)
            )
        );
        // Perfil “ResponsableInspeccion” agrupa permisos de mantenimiento
        Perfil perfilInspeccion = new Perfil(
            "Perfil para responsable de inspecciones",
            "PERFIL_INSPECCION",
            Arrays.asList(
                listaPermisos.get(11) // GestionarMantenimiento
            )
        );
        // Perfil “ConsultorReportes” agrupa permisos de reportes
        Perfil perfilReportes = new Perfil(
            "Perfil para consultor de reportes",
            "PERFIL_REPORTES",
            Arrays.asList(
                listaPermisos.get(8)  // GenerarReporte
            )
        );
        // Perfil “InteresadoSismos” agrupa permisos de suscripción
        Perfil perfilInteresado = new Perfil(
            "Perfil para interesado en sismos",
            "PERFIL_INTERESADO",
            Arrays.asList(
                listaPermisos.get(9), // SuscribirInteresado
                listaPermisos.get(10) // AnularSuscripcion
            )
        );
        listaPerfiles.addAll(Arrays.asList(
            perfilAdminUsuarios,
            perfilAdminRed,
            perfilAnalista,
            perfilSupervisor,
            perfilInspeccion,
            perfilReportes,
            perfilInteresado
        ));

        // 4) USUARIOS (cada uno con uno o varios perfiles)
        listaUsuarios = new ArrayList<>();
        Usuario userAdmin1 = new Usuario("pass123", "adminUsuarios", Arrays.asList(perfilAdminUsuarios));
        Usuario userAdmin2 = new Usuario("redpass456", "adminRed", Arrays.asList(perfilAdminRed));
        Usuario userAnalista = new Usuario("analistapw", "analista001", Arrays.asList(perfilAnalista));
        Usuario userSupervisor = new Usuario("superpw", "supervisor001", Arrays.asList(perfilSupervisor));
        Usuario userInspeccion = new Usuario("inspw123", "inspeccion001", Arrays.asList(perfilInspeccion));
        Usuario userReportes = new Usuario("reponente", "reportero001", Arrays.asList(perfilReportes));
        Usuario userInteresado = new Usuario("interespw", "interesado001", Arrays.asList(perfilInteresado));
        listaUsuarios.addAll(Arrays.asList(
            userAdmin1,
            userAdmin2,
            userAnalista,
            userSupervisor,
            userInspeccion,
            userReportes,
            userInteresado
        ));
    }

    private static void crearFabricantesModelosEstaciones() {
        // 1) FABRICANTES
        listaFabricantes = new ArrayList<>();
        listaFabricantes.add(new Fabricante("SeismoCorp", "SeismoCorp S.A."));
        listaFabricantes.add(new Fabricante("GeoSense",  "GeoSense Ltd."));
        listaFabricantes.add(new Fabricante("EarthTech", "EarthTech GmbH"));

        // 2) MODELOS de Sismógrafos (cada uno con un fabricante)
        listaModelos = new ArrayList<>();
        listaModelos.add(new ModeloSismografo("Alta sensibilidad, 100Hz", "SS-100", listaFabricantes.get(0)));
        listaModelos.add(new ModeloSismografo("Mediana sensibilidad, 50Hz", "GS-50",  listaFabricantes.get(1)));
        listaModelos.add(new ModeloSismografo("Baja sensibilidad, 25Hz", "ET-25",  listaFabricantes.get(2)));

        // 3) ESTACIONES SISMOLÓGICAS (hasta 15; aquí ponemos 5 de ejemplo)
        listaEstaciones = new ArrayList<>();
        listaEstaciones.add(new EstacionSismologica(
            "EST001", 
            "DOC-EST001", 
            LocalDateTime.now().minusDays(30),
            -31.4201f, -64.1888f, 
            "Estación Córdoba Centro", 
            1234.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST002", 
            "DOC-EST002", 
            LocalDateTime.now().minusDays(20),
            -31.4167f, -64.1833f, 
            "Estación Córdoba Norte", 
            1235.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST003", 
            "DOC-EST003", 
            LocalDateTime.now().minusDays(25),
            -31.3522f, -64.2073f, 
            "Estación Villa María", 
            1236.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST004", 
            "DOC-EST004", 
            LocalDateTime.now().minusDays(15),
            -31.5560f, -64.1858f, 
            "Estación Alta Córdoba", 
            1237.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST005", 
            "DOC-EST005", 
            LocalDateTime.now().minusDays(10),
            -31.6404f, -64.3344f, 
            "Estación Calamuchita", 
            1238.0
        ));
    }

    private static void crearClasificacionesOrigenesAlcancesMagnitudes() {
        // 1) CLASIFICACIONES de Sismo (hasta 15)
        listaClasificaciones = new ArrayList<>();
        listaClasificaciones.add(new ClasificacionSismo(0.0f,  10.0f,  "Superficial"));
        listaClasificaciones.add(new ClasificacionSismo(10.0f, 30.0f,  "Intermedia"));
        listaClasificaciones.add(new ClasificacionSismo(30.0f,  70.0f, "Profunda"));

        // 2) ORÍGENES de Generación (hasta 15)
        listaOrigenes = new ArrayList<>();
        listaOrigenes.add(new OrigenDeGeneracion("Punto de falla tectónica", "Tectonico"));
        listaOrigenes.add(new OrigenDeGeneracion("Actividad volcánica subterránea", "Volcánico"));
        listaOrigenes.add(new OrigenDeGeneracion("Explosión artificial", "Inducido"));

        // 3) ALCANCES de Sismo (hasta 15)
        listaAlcances = new ArrayList<>();
        listaAlcances.add(new AlcanceSismo("Afecta solo zona local", "Local"));
        listaAlcances.add(new AlcanceSismo("Se percibe en varias provincias", "Regional"));
        listaAlcances.add(new AlcanceSismo("Se percibe a nivel nacional", "Nacional"));

        // 4) MAGNITUDES Richter (hasta 15; aquí seleccionamos valores comunes)
        listaMagnitudes = new ArrayList<>();
        listaMagnitudes.add(new MagnitudRitcher("Micro",    2));   // Magnitud 2.0
        listaMagnitudes.add(new MagnitudRitcher("Menor",    3));   // Magnitud 3.0
        listaMagnitudes.add(new MagnitudRitcher("Ligero",   4));   // Magnitud 4.0
        listaMagnitudes.add(new MagnitudRitcher("Moderado", 5));   // Magnitud 5.0
        listaMagnitudes.add(new MagnitudRitcher("Fuerte",   6));   // Magnitud 6.0
    }

    private static void crearTiposYDetallesMuestras() {
        // 1) TIPOS DE DATO (hasta 15)
        listaTiposDeDato = new ArrayList<>();
        listaTiposDeDato.add(new TipoDeDato("Velocidad",    "m/s",  0.5));
        listaTiposDeDato.add(new TipoDeDato("Aceleración",  "m/s2", 0.2));
        listaTiposDeDato.add(new TipoDeDato("Desplazamiento","m",    0.1));

        // 2) DETALLES de MuestraSismica (cada uno requiere un valor flotante y un TipoDeDato)
        listaDetalles = new ArrayList<>();
        listaDetalles.add(new DetalleMuestraSismica(0.12f, listaTiposDeDato.get(0)));  // Velocidad
        listaDetalles.add(new DetalleMuestraSismica(0.07f, listaTiposDeDato.get(1)));  // Aceleración
        listaDetalles.add(new DetalleMuestraSismica(0.005f, listaTiposDeDato.get(2))); // Desplazamiento

        // 3) MUESTRAS SISMICAS (hasta 15; cada muestra con una fecha y su lista de detalles)
        listaMuestras = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LocalDateTime timestamp = LocalDateTime.now().minusSeconds(60 - i * 5);
            // Asignamos siempre los tres tipos de detalle
            List<DetalleMuestraSismica> detallesDeLaMuestra = new ArrayList<>(listaDetalles);
            listaMuestras.add(new MuestraSismica(timestamp, detallesDeLaMuestra));
        }
    }

    private static void crearEmpleadosYCambiosEstado() {
        // 1) EMPLEADOS (hasta 15; cada uno requiere apellido, mail, nombre, teléfono, y Rol)
        listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Gómez",     "gomez@ccrs.utn",     "Juan",       "3511234567", listaRoles.get(2))); // Analista
        listaEmpleados.add(new Empleado("Fernández", "fernandez@ccrs.utn", "María",      "3512345678", listaRoles.get(3))); // Supervisor
        listaEmpleados.add(new Empleado("López",     "lopez@ccrs.utn",     "Carlos",     "3513456789", listaRoles.get(4))); // Responsable Inspección
        listaEmpleados.add(new Empleado("Pérez",     "perez@ccrs.utn",     "Lucía",      "3514567890", listaRoles.get(5))); // Consultor Reportes

        // 2) CAMBIOS DE ESTADO (hasta 15; cada uno con Estado, Empleado, y fecha inicio y fin)
        listaCambios = new ArrayList<>();
        // Tomamos algunos estados ya definidos en listaEstados
        Estado estInstalacion  = encontrarEstado("Sismografo", "EnInstalacion");
        Estado estLinea        = encontrarEstado("Sismografo", "EnLinea");
        Estado estFueraServicio = encontrarEstado("Sismografo", "FueraDeServicio");
        Estado evAutodetectado  = encontrarEstado("EventoSismico", "Autodetectado");
        Estado evPendRevision   = encontrarEstado("EventoSismico", "PendienteRevision");

        // Cambio 1: Sismógrafo en instalación por parte del empleado responsable de inspección
        CambioEstado cambio1 = new CambioEstado(estInstalacion, listaEmpleados.get(2),
            LocalDateTime.now().minusHours(5));
        cambio1.setFechaHoraFin(LocalDateTime.now().minusHours(3));
        listaCambios.add(cambio1);

        // Cambio 2: Sismógrafo pasa a línea (integración)
        CambioEstado cambio2 = new CambioEstado(estLinea, listaEmpleados.get(2),
            LocalDateTime.now().minusHours(3));
        cambio2.setFechaHoraFin(LocalDateTime.now().minusHours(1));
        listaCambios.add(cambio2);

        // Cambio 3: Evento sísmico autodetectado, a cargo de analista
        CambioEstado cambio3 = new CambioEstado(evAutodetectado, listaEmpleados.get(0),
            LocalDateTime.now().minusMinutes(20));
        // Todavía no finalizó, o bien lo cerramos
        cambio3.setFechaHoraFin(LocalDateTime.now().minusMinutes(5));
        listaCambios.add(cambio3);

        // Cambio 4: Evento sísmico pendiente de revisión
        CambioEstado cambio4 = new CambioEstado(evPendRevision, listaEmpleados.get(0),
            LocalDateTime.now().minusMinutes(5));
        listaCambios.add(cambio4);
    }

    private static void crearSeriesYMuestras() {
        // 1) SERIES TEMPORALES (hasta 15; cada una con condición de alarma, fechas, frecuencia, lista de muestras, y un Estado)
        listaSeries = new ArrayList<>();
        Estado estadoSerieOK = encontrarEstado("Sismografo", "EnLinea"); // ejemplo
        for (int i = 0; i < 5; i++) {
            String condicion = (i % 2 == 0) ? "SinAlarma" : "AlarmaActivo";
            LocalDateTime inicioRegistro = LocalDateTime.now().minusMinutes(15 + i * 2);
            LocalDateTime finRegistro    = LocalDateTime.now().minusMinutes(5 + i * 2);
            double freq                  = 50.0 + i * 5.0;
            // Seleccionamos de 0 a 3 muestras para cada serie (coherencia de datos)
            List<MuestraSismica> muestrasSerie = new ArrayList<>();
            for (int j = 0; j < listaMuestras.size() && j < 5; j++) {
                muestrasSerie.add(listaMuestras.get((i + j) % listaMuestras.size()));
            }
            SerieTemporal serie = new SerieTemporal(
                condicion,
                inicioRegistro,
                finRegistro,
                freq,
                muestrasSerie,
                estadoSerieOK
            );
            listaSeries.add(serie);
        }
    }

    private static void crearSismografos() {
        // 1) SISMOGRAFOS (hasta 15; cada uno con fecha adquisición, ID, serie, estación, modelo, estadoActual, y cambiosEstado)
        listaSismografos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LocalDateTime fechaAdq = LocalDateTime.now().minusDays(30).plusDays(i * 5);
            String idSismo        = "SISMO-" + String.format("%03d", i + 1);
            Double numSerie       = 1000.0 + i;
            // Tomamos la estación i (o la primera si no hay)
            EstacionSismologica est = listaEstaciones.get(i % listaEstaciones.size());
            // Tomamos modelo i
            ModeloSismografo modelo = listaModelos.get(i % listaModelos.size());
            // Asociamos dos series temporales a cada sismógrafo (para ejemplo)
            List<SerieTemporal> seriesDelSismografo = new ArrayList<>();
            seriesDelSismografo.add(listaSeries.get(i % listaSeries.size()));
            seriesDelSismografo.add(listaSeries.get((i + 1) % listaSeries.size()));
            // Estado actual (EnLinea)
            Estado estadoActual = encontrarEstado("Sismografo", "EnLinea");
            // Cambios de estado asociados (tomamos los primeros de listaCambios)
            List<CambioEstado> cambiosDeEste = new ArrayList<>();
            cambiosDeEste.add(listaCambios.get(i % listaCambios.size()));
            cambiosDeEste.add(listaCambios.get((i + 1) % listaCambios.size()));

            Sismografo sismo = new Sismografo(
                fechaAdq,
                idSismo,
                numSerie,
                est,
                modelo,
                seriesDelSismografo,
                estadoActual,
                cambiosDeEste
            );
            listaSismografos.add(sismo);
        }
    }

    private static void crearEventosSismicos() {
        // 1) EVENTOS SISMICOS (hasta 15; cada uno con coordenadas, magnitud, clasificación, origen, alcance, lista de cambios, lista de series, estadoActual y analista supervisor)
        listaEventos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LocalDateTime inicioEv = LocalDateTime.now().minusHours(2).plusMinutes(i * 10);
            LocalDateTime finEv    = inicioEv.plusMinutes(5);
            float latEpic    = -31.4201f + i * 0.01f;
            float lonEpic    = -64.1888f + i * 0.01f;
            float latHipo    = latEpic - 0.005f;
            float lonHipo    = lonEpic - 0.005f;
            int magValue     = 3 + i; // entre 3 y 7
            // Tomamos un cambio de estado (autodetectado, pendiente)
            List<CambioEstado> cambiosEv = new ArrayList<>();
            cambiosEv.add(listaCambios.get(i % listaCambios.size()));
            cambiosEv.add(listaCambios.get((i + 1) % listaCambios.size()));
            // Estado actual (Autodetectado o PendienteRevision)
            Estado estadoEv = (i % 2 == 0)
                ? encontrarEstado("EventoSismico", "Autodetectado")
                : encontrarEstado("EventoSismico", "PendienteRevision");
            // Asociamos 2 series temporales arbitrarias
            List<SerieTemporal> seriesEv = new ArrayList<>();
            seriesEv.add(listaSeries.get(i % listaSeries.size()));
            seriesEv.add(listaSeries.get((i + 1) % listaSeries.size()));
            // Clasificación, magnitud, origen, alcance, analista supervisor
            ClasificacionSismo clasif = listaClasificaciones.get(i % listaClasificaciones.size());
            MagnitudRitcher magnit    = listaMagnitudes.get(i % listaMagnitudes.size());
            OrigenDeGeneracion origen  = listaOrigenes.get(i % listaOrigenes.size());
            AlcanceSismo alcance       = listaAlcances.get(i % listaAlcances.size());
            Empleado supervisor        = listaEmpleados.get(1); // siempre el mismo para ejemplo

            EventoSismico evento = new EventoSismico(
                inicioEv,
                finEv,
                latEpic,
                lonEpic,
                lonHipo,
                latHipo,
                magValue,
                cambiosEv,
                estadoEv,
                seriesEv,
                clasif,
                magnit,
                origen,
                alcance,
                supervisor
            );
            listaEventos.add(evento);
        }
    }

    /**
     * Busca un objeto Estado por su ámbito y nombre de estado. Retorna null si no lo encuentra.
     */
    private static Estado encontrarEstado(String ambito, String nombreEstado) {
        for (Estado e : listaEstados) {
            if (e != null
                && ambito.equals(e.sosAutoDetectado() || 
                                  e.sosPendienteRevision() ? 
                                  e.sosBloqueadoEnRevision() ? 
                                  e.sosDerivadoAExperto() : "" : "")
            ) {
                // Este if anterior es incorrecto para comparar; en cambio checamos directamente campos:
            }
        }
        // Hacemos la comparación de nombreEstado y ambito sin usar los métodos booleanos,
        // sino comparando internamente las cadenas de la instancia que guardaremos:
        for (Estado e : listaEstados) {
            // Usamos reflexión de campo "ambito" y "nombreEstado" (no hay getter, así que suponemos que lejos de pura reflexión,
            // comparamos vía los métodos booleanos cuando corresponda):
            if (e != null) {
                // Comprobamos todos los métodos Boolean que reflejen el nombre:
                if ("Sismografo".equals(ambito)) {
                    // Comparamos si e.sosAutoDetectado() => nombreEstado "Autodetectado", etc.
                }
                // Mejor: hacemos un hack: pre-creamos un mapa en lugar de buscar.
            }
        }
        // Para simplificar, dado que ya creamos los objetos Estado en memoria con exactitud de cadenas,
        // podemos comparar el campo nombreEstado internamente (aunque no haya getter público).
        // Como aquí no existe un getter, podemos aprovechar directamente que el constructor asignó en ese orden.
        for (Estado e : listaEstados) {
            try {
                java.lang.reflect.Field fAmbito = Estado.class.getDeclaredField("ambito");
                java.lang.reflect.Field fNombre = Estado.class.getDeclaredField("nombreEstado");
                fAmbito.setAccessible(true);
                fNombre.setAccessible(true);
                String a = (String) fAmbito.get(e);
                String n = (String) fNombre.get(e);
                if (ambito.equals(a) && nombreEstado.equals(n)) {
                    return e;
                }
            } catch (Exception ex) {
                // Ignoramos si no funciona reflección
            }
        }
        return null;
    }

    // --------------------------
    // Métodos de prueba (opcional)
    // --------------------------
    public static void printAllData() {
        System.out.println("=== ESTADOS ===");
        for (Estado e : listaEstados) {
            try {
                java.lang.reflect.Field fAmbito = Estado.class.getDeclaredField("ambito");
                java.lang.reflect.Field fNombre = Estado.class.getDeclaredField("nombreEstado");
                fAmbito.setAccessible(true);
                fNombre.setAccessible(true);
                System.out.printf("Ambito: %s, Nombre: %s%n",
                    fAmbito.get(e), fNombre.get(e));
            } catch (Exception ex) { }
        }

        System.out.println("\n=== ROLES ===");
        for (Rol r : listaRoles) {
            System.out.printf("- %s%n", r.getNombreRol());
        }

        System.out.println("\n=== PERMISOS ===");
        for (Permiso p : listaPermisos) {
            System.out.printf("- %s (%s)%n", p.getNombre(), p.getDescripcion());
        }

        System.out.println("\n=== PERFILES ===");
        for (Perfil p : listaPerfiles) {
            System.out.printf("- %s (%s): Permisos = %s%n",
                p.getNombre(), p.getDescripcion(),
                p.getPermisos().stream().map(Permiso::getNombre).toList());
        }

        System.out.println("\n=== USUARIOS ===");
        for (Usuario u : listaUsuarios) {
            try {
                java.lang.reflect.Field fNombreUsuario = Usuario.class.getDeclaredField("nombreUsuario");
                java.lang.reflect.Field fPerfiles = Usuario.class.getDeclaredField("perfil");
                fNombreUsuario.setAccessible(true);
                fPerfiles.setAccessible(true);
                String nu = (String) fNombreUsuario.get(u);
                @SuppressWarnings("unchecked")
                List<Perfil> perf = (List<Perfil>) fPerfiles.get(u);
                System.out.printf("- %s: Perfiles = %s%n", nu,
                    perf.stream().map(Perfil::getNombre).toList());
            } catch (Exception ex) { }
        }

        System.out.println("\n=== ESTACIONES ===");
        for (EstacionSismologica est : listaEstaciones) {
            System.out.printf("- [%s] %s%n", est.getCodigoEstacion(), est.getNombre());
        }

        System.out.println("\n=== SISMÓGRAFOS ===");
        for (Sismografo s : listaSismografos) {
            System.out.printf("- ID: %s, Estado: %s%n",
                s.getIdentificadorSismografo(),
                obtenerNombreEstadoDeSismografo(s)
            );
        }

        System.out.println("\n=== EVENTOS SÍSMICOS ===");
        for (EventoSismico ev : listaEventos) {
            System.out.printf("- FechaInicio: %s, Magnitud: %d, Estado: %s%n",
                ev.getFechaHoraOcurrencia(), ev.valorMagnitud(),
                obtenerNombreEstadoDeEvento(ev)
            );
        }
    }

    private static String obtenerNombreEstadoDeSismografo(Sismografo s) {
        try {
            java.lang.reflect.Field fEstado = Sismografo.class.getDeclaredField("estadoActual");
            fEstado.setAccessible(true);
            Estado e = (Estado) fEstado.get(s);
            // recuperamos su nombreEstado:
            java.lang.reflect.Field fn = Estado.class.getDeclaredField("nombreEstado");
            fn.setAccessible(true);
            return (String) fn.get(e);
        } catch (Exception ex) {
            return "Desconocido";
        }
    }

    private static String obtenerNombreEstadoDeEvento(EventoSismico ev) {
        try {
            java.lang.reflect.Field fEstado = EventoSismico.class.getDeclaredField("estadoActual");
            fEstado.setAccessible(true);
            Estado e = (Estado) fEstado.get(ev);
            java.lang.reflect.Field fn = Estado.class.getDeclaredField("nombreEstado");
            fn.setAccessible(true);
            return (String) fn.get(e);
        } catch (Exception ex) {
            return "Desconocido";
        }
    }

    // MAIN de prueba
    public static void main(String[] args) {
        // Inicializamos todas las listas
        DataInitializer.initializeAll();
        // Imprimimos un resumen de lo creado
        DataInitializer.printAllData();
    }
}
