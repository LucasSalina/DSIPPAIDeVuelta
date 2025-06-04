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

    // Listas que contendrán las instancias
    public List<Estado>                 listaEstados;
    public List<Rol>                    listaRoles;
    public List<Permiso>                listaPermisos;
    public List<Perfil>                 listaPerfiles;
    public List<Usuario>                listaUsuarios;
    public List<Fabricante>             listaFabricantes;
    public List<ModeloSismografo>       listaModelos;
    public List<EstacionSismologica>    listaEstaciones;
    public List<Sismografo>             listaSismografos;
    public List<ClasificacionSismo>     listaClasificaciones;
    public List<OrigenDeGeneracion>     listaOrigenes;
    public List<AlcanceSismo>           listaAlcances;
    public List<MagnitudRitcher>        listaMagnitudes;
    public List<TipoDeDato>             listaTiposDeDato;
    public List<DetalleMuestraSismica>  listaDetalles;
    public List<MuestraSismica>         listaMuestras;
    public List<SerieTemporal>          listaSeries;
    public List<Empleado>               listaEmpleados;
    public List<CambioEstado>           listaCambios;
    public List<EventoSismico>          listaEventos;

    /**
     * Genera todas las instancias de ejemplo y las almacena en las listas NO estáticas.
     * Debe invocarse una sola vez, al iniciar la aplicación.
     */
    public void initializeAll() {
        crearEstados();
        crearRolesPermisosPerfilesUsuarios();
        crearFabricantesModelosEstaciones();
        crearClasificacionesOrigenesAlcancesMagnitudes();
        crearTiposYDetallesMuestras();
        crearEmpleadosYCambiosEstado();
        crearSeriesYMuestras();
        crearSismografos();
        crearEventosSismicos();  // Ahora crea 12 eventos de distintos estados
    }

    // ——————————————————————————————————————————————————————————————
    // 1) ESTADOS
    // ——————————————————————————————————————————————————————————————
    private void crearEstados() {
        listaEstados = new ArrayList<>();
        // Estados para ámbito “Sismografo”
        listaEstados.add(new Estado("Sismografo", "Disponible"));
        listaEstados.add(new Estado("Sismografo", "EnInstalacion"));
        listaEstados.add(new Estado("Sismografo", "EnLinea"));
        listaEstados.add(new Estado("Sismografo", "FueraDeServicio"));
        listaEstados.add(new Estado("Sismografo", "Reparacion"));
        listaEstados.add(new Estado("Sismografo", "InhabilitadoPorInspeccion"));

        // Estados para ámbito “EventoSismico”
        listaEstados.add(new Estado("EventoSismico", "Autodetectado"));
        listaEstados.add(new Estado("EventoSismico", "PendienteRevision"));
        listaEstados.add(new Estado("EventoSismico", "BloqueadoEnRevision"));
        listaEstados.add(new Estado("EventoSismico", "DerivadoAExperto"));
        listaEstados.add(new Estado("EventoSismico", "Confirmado"));
        listaEstados.add(new Estado("EventoSismico", "Rechazado"));
        listaEstados.add(new Estado("EventoSismico", "Cerrado"));
    }

    // ——————————————————————————————————————————————————————————————
    // 2) ROLES, PERMISOS, PERFILES y USUARIOS
    // ——————————————————————————————————————————————————————————————
    private void crearRolesPermisosPerfilesUsuarios() {
        // PERMISOS
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

        // ROLES
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

        // PERFILES
        listaPerfiles = new ArrayList<>();
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
        Perfil perfilAdminRed = new Perfil(
            "Perfil para administradores de red sísmica",
            "PERFIL_ADMIN_RED",
            Arrays.asList(
                listaPermisos.get(5), // RegistrarSismografo
                listaPermisos.get(6)  // RegistrarEstacion
            )
        );
        Perfil perfilAnalista = new Perfil(
            "Perfil para analistas de sismos",
            "PERFIL_ANALISTA",
            Arrays.asList(
                listaPermisos.get(7)  // RevisarEvento
            )
        );
        Perfil perfilSupervisor = new Perfil(
            "Perfil para supervisores de sismos",
            "PERFIL_SUPERVISOR",
            Arrays.asList(
                listaPermisos.get(7)  // RevisarEvento
            )
        );
        Perfil perfilInspeccion = new Perfil(
            "Perfil para responsable de inspecciones",
            "PERFIL_INSPECCION",
            Arrays.asList(
                listaPermisos.get(9)  // GestionarMantenimiento
            )
        );
        Perfil perfilReportes = new Perfil(
            "Perfil para consultor de reportes",
            "PERFIL_REPORTES",
            Arrays.asList(
                listaPermisos.get(8)  // GenerarReporte
            )
        );
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

        // USUARIOS
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("pass123",   "adminUsuarios",   Arrays.asList(perfilAdminUsuarios)));
        listaUsuarios.add(new Usuario("redpass456","adminRed",        Arrays.asList(perfilAdminRed)));
        listaUsuarios.add(new Usuario("analistapw","analista001",     Arrays.asList(perfilAnalista)));
        listaUsuarios.add(new Usuario("superpw",   "supervisor001",   Arrays.asList(perfilSupervisor)));
        listaUsuarios.add(new Usuario("inspw123",  "inspeccion001",   Arrays.asList(perfilInspeccion)));
        listaUsuarios.add(new Usuario("reponente", "reportero001",    Arrays.asList(perfilReportes)));
        listaUsuarios.add(new Usuario("interespw", "interesado001",   Arrays.asList(perfilInteresado)));
    }

    // ——————————————————————————————————————————————————————————————
    // 3) FABRICANTES, MODELOS y ESTACIONES
    // ——————————————————————————————————————————————————————————————
    private void crearFabricantesModelosEstaciones() {
        // FABRICANTES
        listaFabricantes = new ArrayList<>();
        listaFabricantes.add(new Fabricante("SeismoCorp", "SeismoCorp S.A."));
        listaFabricantes.add(new Fabricante("GeoSense",  "GeoSense Ltd."));
        listaFabricantes.add(new Fabricante("EarthTech", "EarthTech GmbH"));

        // MODELOS de Sismógrafos
        listaModelos = new ArrayList<>();
        listaModelos.add(new ModeloSismografo("Alta sensibilidad, 100Hz", "SS-100", listaFabricantes.get(0)));
        listaModelos.add(new ModeloSismografo("Mediana sensibilidad, 50Hz","GS-50",  listaFabricantes.get(1)));
        listaModelos.add(new ModeloSismografo("Baja sensibilidad, 25Hz","ET-25",  listaFabricantes.get(2)));

        // ESTACIONES SISMOLÓGICAS
        listaEstaciones = new ArrayList<>();
        listaEstaciones.add(new EstacionSismologica(
            "EST001", "DOC-EST001", LocalDateTime.now().minusDays(30),
            -31.4201f, -64.1888f, "Estación Córdoba Centro", 1234.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST002", "DOC-EST002", LocalDateTime.now().minusDays(20),
            -31.4167f, -64.1833f, "Estación Córdoba Norte", 1235.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST003", "DOC-EST003", LocalDateTime.now().minusDays(25),
            -31.3522f, -64.2073f, "Estación Villa María", 1236.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST004", "DOC-EST004", LocalDateTime.now().minusDays(15),
            -31.5560f, -64.1858f, "Estación Alta Córdoba", 1237.0
        ));
        listaEstaciones.add(new EstacionSismologica(
            "EST005", "DOC-EST005", LocalDateTime.now().minusDays(10),
            -31.6404f, -64.3344f, "Estación Calamuchita", 1238.0
        ));
    }

    // ——————————————————————————————————————————————————————————————
    // 4) CLASIFICACIONES, ORÍGENES, ALCANCES y MAGNITUDES
    // ——————————————————————————————————————————————————————————————
    private void crearClasificacionesOrigenesAlcancesMagnitudes() {
        // CLASIFICACIONES
        listaClasificaciones = new ArrayList<>();
        listaClasificaciones.add(new ClasificacionSismo( 0.0f, 10.0f,  "Superficial"));
        listaClasificaciones.add(new ClasificacionSismo(10.0f, 30.0f,  "Intermedia"));
        listaClasificaciones.add(new ClasificacionSismo(30.0f, 70.0f,  "Profunda"));

        // ORÍGENES
        listaOrigenes = new ArrayList<>();
        listaOrigenes.add(new OrigenDeGeneracion("Punto de falla tectónica", "Tectonico"));
        listaOrigenes.add(new OrigenDeGeneracion("Actividad volcánica subterránea", "Volcánico"));
        listaOrigenes.add(new OrigenDeGeneracion("Explosión artificial", "Inducido"));

        // ALCANCES
        listaAlcances = new ArrayList<>();
        listaAlcances.add(new AlcanceSismo("Afecta solo zona local",       "Local"));
        listaAlcances.add(new AlcanceSismo("Se percibe en varias provincias","Regional"));
        listaAlcances.add(new AlcanceSismo("Se percibe a nivel nacional",   "Nacional"));

        // MAGNITUDES
        listaMagnitudes = new ArrayList<>();
        listaMagnitudes.add(new MagnitudRitcher("Micro",    2));
        listaMagnitudes.add(new MagnitudRitcher("Menor",    3));
        listaMagnitudes.add(new MagnitudRitcher("Ligero",   4));
        listaMagnitudes.add(new MagnitudRitcher("Moderado", 5));
        listaMagnitudes.add(new MagnitudRitcher("Fuerte",   6));
    }

    // ——————————————————————————————————————————————————————————————
    // 5) TIPOS DE DATO, DETALLES y MUESTRAS
    // ——————————————————————————————————————————————————————————————
    private void crearTiposYDetallesMuestras() {
        // TIPOS DE DATO
        listaTiposDeDato = new ArrayList<>();
        listaTiposDeDato.add(new TipoDeDato("Velocidad",    "m/s",  0.5));
        listaTiposDeDato.add(new TipoDeDato("Aceleración",  "m/s2", 0.2));
        listaTiposDeDato.add(new TipoDeDato("Desplazamiento","m",    0.1));

        // DETALLES de Muestra
        listaDetalles = new ArrayList<>();
        listaDetalles.add(new DetalleMuestraSismica(0.12f, listaTiposDeDato.get(0)));  // Velocidad
        listaDetalles.add(new DetalleMuestraSismica(0.07f, listaTiposDeDato.get(1)));  // Aceleración
        listaDetalles.add(new DetalleMuestraSismica(0.005f, listaTiposDeDato.get(2))); // Desplazamiento

        // MUESTRAS SÍSMICAS
        listaMuestras = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LocalDateTime timestamp = LocalDateTime.now().minusSeconds(60 - i * 5);
            List<DetalleMuestraSismica> detallesDeLaMuestra = new ArrayList<>(listaDetalles);
            listaMuestras.add(new MuestraSismica(timestamp, detallesDeLaMuestra));
        }
    }

    // ——————————————————————————————————————————————————————————————
    // 6) EMPLEADOS y CAMBIOS DE ESTADO
    // ——————————————————————————————————————————————————————————————
    private void crearEmpleadosYCambiosEstado() {
        // EMPLEADOS
        listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Gómez",     "gomez@ccrs.utn",     "Juan",       "3511234567", listaRoles.get(2))); // Analista
        listaEmpleados.add(new Empleado("Fernández", "fernandez@ccrs.utn", "María",      "3512345678", listaRoles.get(3))); // Supervisor
        listaEmpleados.add(new Empleado("López",     "lopez@ccrs.utn",     "Carlos",     "3513456789", listaRoles.get(4))); // Responsable Inspección
        listaEmpleados.add(new Empleado("Pérez",     "perez@ccrs.utn",     "Lucía",      "3514567890", listaRoles.get(5))); // Consultor Reportes

        // CAMBIOS DE ESTADO
        listaCambios = new ArrayList<>();
        Estado estInstalacion   = encontrarEstado("Sismografo",    "EnInstalacion");
        Estado estLinea         = encontrarEstado("Sismografo",    "EnLinea");
        Estado evAutodetectado  = encontrarEstado("EventoSismico", "Autodetectado");
        Estado evPendRevision   = encontrarEstado("EventoSismico", "PendienteRevision");

        CambioEstado c1 = new CambioEstado(estInstalacion,   listaEmpleados.get(2), LocalDateTime.now().minusHours(5));
        c1.setFechaHoraFin(LocalDateTime.now().minusHours(3));
        listaCambios.add(c1);

        CambioEstado c2 = new CambioEstado(estLinea,         listaEmpleados.get(2), LocalDateTime.now().minusHours(3));
        c2.setFechaHoraFin(LocalDateTime.now().minusHours(1));
        listaCambios.add(c2);

        CambioEstado c3 = new CambioEstado(evAutodetectado,  listaEmpleados.get(0), LocalDateTime.now().minusMinutes(20));
        c3.setFechaHoraFin(LocalDateTime.now().minusMinutes(5));
        listaCambios.add(c3);

        CambioEstado c4 = new CambioEstado(evPendRevision,   listaEmpleados.get(0), LocalDateTime.now().minusMinutes(5));
        listaCambios.add(c4);
    }

    // ——————————————————————————————————————————————————————————————
    // 7) SERIES TEMPORALES y MUESTRAS
    // ——————————————————————————————————————————————————————————————
    private void crearSeriesYMuestras() {
        // Creamos primero algunas muestras locales para asociar
        List<MuestraSismica> muestrasLocales = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LocalDateTime ts = LocalDateTime.now().minusSeconds(60 - i * 5);
            muestrasLocales.add(new MuestraSismica(ts, new ArrayList<>(listaDetalles)));
        }

        // SERIES TEMPORALES
        listaSeries = new ArrayList<>();
        Estado estadoSerieOK = encontrarEstado("Sismografo", "EnLinea");
        for (int i = 0; i < 5; i++) {
            String condicion = (i % 2 == 0) ? "SinAlarma" : "AlarmaActivo";
            LocalDateTime inicioRegistro = LocalDateTime.now().minusMinutes(15 + i * 2);
            LocalDateTime finRegistro    = LocalDateTime.now().minusMinutes(5 + i * 2);
            double freq                  = 50.0 + i * 5.0;

            List<MuestraSismica> muestrasSerie = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                muestrasSerie.add(muestrasLocales.get((i + j) % muestrasLocales.size()));
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

    // ——————————————————————————————————————————————————————————————
    // 8) SISMÓGRAFOS
    // ——————————————————————————————————————————————————————————————
    private void crearSismografos() {
        listaSismografos = new ArrayList<>();
        Estado estadoActual = encontrarEstado("Sismografo", "EnLinea");

        for (int i = 0; i < 5; i++) {
            LocalDateTime fechaAdq = LocalDateTime.now().minusDays(30).plusDays(i * 5);
            String idSismo        = "SISMO-" + String.format("%03d", i + 1);
            Double numSerie       = 1000.0 + i;

            EstacionSismologica est = listaEstaciones.get(i % listaEstaciones.size());
            ModeloSismografo modelo = listaModelos.get(i % listaModelos.size());

            List<SerieTemporal> seriesDelSismografo = new ArrayList<>();
            seriesDelSismografo.add(listaSeries.get(i % listaSeries.size()));
            seriesDelSismografo.add(listaSeries.get((i + 1) % listaSeries.size()));

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

    // ——————————————————————————————————————————————————————————————
    // 9) EVENTOS SÍSMICOS (12, con estados revisados y no revisados)
    // ——————————————————————————————————————————————————————————————
    private void crearEventosSismicos() {
        listaEventos = new ArrayList<>();

        // Obtener referencias a todos los estados
        Estado evAutodetectado = encontrarEstado("EventoSismico", "Autodetectado");
        Estado evPendRevision  = encontrarEstado("EventoSismico", "PendienteRevision");
        Estado evConfirmado    = encontrarEstado("EventoSismico", "Confirmado");
        Estado evRechazado     = encontrarEstado("EventoSismico", "Rechazado");
        Estado evCerrado       = encontrarEstado("EventoSismico", "Cerrado");

        for (int i = 0; i < 12; i++) {
            LocalDateTime inicioEv = LocalDateTime.now().minusHours(2).plusMinutes(i * 10);
            LocalDateTime finEv    = inicioEv.plusMinutes(5);

            float latEpic = -31.4201f + i * 0.005f;
            float lonEpic = -64.1888f + i * 0.005f;
            float latHipo = latEpic - 0.003f;
            float lonHipo = lonEpic - 0.003f;
            int magValue  = 3 + (i % 5);

            // Historial de cambios (rotamos sobre listaCambios)
            List<CambioEstado> cambiosLocales = new ArrayList<>();
            cambiosLocales.add(listaCambios.get(i % listaCambios.size()));
            cambiosLocales.add(listaCambios.get((i + 1) % listaCambios.size()));

            // Asignación de estados:
            // i=0..3   → Autodetectado
            // i=4..6   → PendienteRevision
            // i=7..8   → Confirmado
            // i=9..10  → Rechazado
            // i=11     → Cerrado
            Estado estadoActual;
            if (i <= 3) {
                estadoActual = evAutodetectado;
            } else if (i <= 6) {
                estadoActual = evPendRevision;
            } else if (i <= 8) {
                estadoActual = evConfirmado;
            } else if (i <= 10) {
                estadoActual = evRechazado;
            } else {
                estadoActual = evCerrado;
            }

            // Series asociadas (dos por evento, rotando sobre listaSeries)
            List<SerieTemporal> seriesLocales = new ArrayList<>();
            seriesLocales.add(listaSeries.get(i % listaSeries.size()));
            seriesLocales.add(listaSeries.get((i + 2) % listaSeries.size()));

            // Clasificación, magnitud, origen, alcance, analista supervisor
            ClasificacionSismo clasif = listaClasificaciones.get(i % listaClasificaciones.size());
            MagnitudRitcher magnit    = listaMagnitudes.get(i % listaMagnitudes.size());
            OrigenDeGeneracion origen  = listaOrigenes.get(i % listaOrigenes.size());
            AlcanceSismo alcance       = listaAlcances.get(i % listaAlcances.size());
            Empleado supervisor        = listaEmpleados.get(i % listaEmpleados.size());

            EventoSismico evento = new EventoSismico(
                inicioEv,
                finEv,
                latEpic,
                lonEpic,
                lonHipo,
                latHipo,
                magValue,
                cambiosLocales,
                estadoActual,
                seriesLocales,
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
     * Busca un objeto Estado por su ámbito y nombre de estado.
     * Retorna null si no lo encuentra.
     */
    private Estado encontrarEstado(String ambito, String nombreEstado) {
        if (listaEstados == null) return null;
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
                // Ignoramos fallo de reflexión
            }
        }
        return null;
    }
}
