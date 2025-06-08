package com.grupo7.dsi_tp1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Ventana1 extends JPanel {

    private GestorRevisionManual gestorRevisionManual;
    private JList<List<String>> eventList;
    private DefaultListModel<List<String>> listModel;
    private int hoverIndex = -1;

    public Ventana1(List<EventoSismico> listaEventos,
                    List<Estado> listaEstados,
                    List<Usuario> listaUsuarios,
                    List<Sismografo> listaSismografos) {
        setLayout(new BorderLayout());

        // Obligar a ocupar pantalla completa
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);

        // Inicializar modelo y JList
        listModel = new DefaultListModel<>();
        eventList = new JList<>(listModel);
        eventList.setCellRenderer(new EventoCellRenderer());
        eventList.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Crear JScrollPane con barra vertical siempre visible
        JScrollPane scrollPane = new JScrollPane(
            eventList,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        add(scrollPane, BorderLayout.CENTER);

        // Instanciar el gestor, pasándole esta Ventana1 para posibles callbacks
        this.gestorRevisionManual = new GestorRevisionManual(
            listaEventos, listaEstados, listaUsuarios, listaSismografos, this
        );

        // Botón en la zona norte para registrar resultado de revisión manual
        javax.swing.JButton jButton1 = new javax.swing.JButton("Registrar resultado revisión manual");
        jButton1.addActionListener(evt -> gestorRevisionManual.registrarResultadoRevisionManual());
        add(jButton1, BorderLayout.NORTH);

        // Controlar hover: actualizar hoverIndex al mover el mouse
        eventList.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int idx = eventList.locationToIndex(e.getPoint());
                if (idx != hoverIndex) {
                    hoverIndex = idx;
                    eventList.repaint();
                }
            }
        });
        // Resetear hoverIndex al salir del área de la lista
        eventList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                hoverIndex = -1;
                eventList.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int idx = eventList.locationToIndex(e.getPoint());
                if (idx >= 0) {
                    eventList.setSelectedIndex(idx);

                    // Obtener los datos principales del evento seleccionado
                    List<String> datosSeleccionados = listModel.getElementAt(idx);

                    // Informar al Gestor → él hace el resto (incluido llamar a mostrarDatosSismicosRegistrados)
                    tomarSeleccionEventoSismico(datosSeleccionados);
                }
            }

        });

        // Al agregar a un JFrame, pedir maximizar
        SwingUtilities.invokeLater(() -> {
            JFrame top = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (top != null) {
                top.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    // Comportamiento: mostrar eventos en pantalla
    public void mostarEventosSismicosYSolicitarSeleccion(List<List<String>> datosPrincipales) {
        cargarDatosEnLista(datosPrincipales);
    }

    // Cargar datos principales de eventos sísmicos en el modelo de la lista
    private void cargarDatosEnLista(List<List<String>> datosPrincipales) {
        listModel.clear();
        if (datosPrincipales == null || datosPrincipales.isEmpty()) {
            listModel.addElement(List.of(
                "No hay eventos sísmicos no revisados para mostrar.",
                "", "", "", ""
            ));
        } else {
            for (List<String> eventoData : datosPrincipales) {
                listModel.addElement(eventoData);
            }
        }
    }

    // Clase interna para el renderizado de cada celda en la lista
    private class EventoCellRenderer extends javax.swing.JLabel implements ListCellRenderer<List<String>> {
        public EventoCellRenderer() {
            setOpaque(true);
            setBorder(new EmptyBorder(8, 8, 8, 8));
        }

        @Override
        public java.awt.Component getListCellRendererComponent(
                JList<? extends List<String>> list,
                List<String> value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            String fechaHora = value.size() > 0 ? value.get(0) : "";
            String latEpic   = value.size() > 1 ? value.get(1) : "";
            String lonEpic   = value.size() > 2 ? value.get(2) : "";
            String latHipo   = value.size() > 3 ? value.get(3) : "";
            String lonHipo   = value.size() > 4 ? value.get(4) : "";

            String html = "<html>"
                        + "<table cellpadding='4'>"
                        + "<tr><td><b>Fecha y Hora de Ocurrencia:</b></td><td>" + fechaHora + "</td></tr>"
                        + "<tr><td><b>Latitud Epicentro:</b></td><td>"       + latEpic   + "</td></tr>"
                        + "<tr><td><b>Longitud Epicentro:</b></td><td>"      + lonEpic   + "</td></tr>"
                        + "<tr><td><b>Latitud Hipocentro:</b></td><td>"      + latHipo   + "</td></tr>"
                        + "<tr><td><b>Longitud Hipocentro:</b></td><td>"     + lonHipo   + "</td></tr>"
                        + "</table>"
                        + "</html>";
            setText(html);

            if (isSelected) {
                setBackground(UIManager.getColor("List.selectionBackground"));
                setForeground(UIManager.getColor("List.selectionForeground"));
            } else if (index == hoverIndex) {
                setBackground(new Color(220, 240, 255));
                setForeground(list.getForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            return this;
        }
    }
    
    // Tomar el evento sismico seleccionado
    private void tomarSeleccionEventoSismico(List<String> datosSelecciondos) {
            
        // Informar al gestor el conjunto de datosPrincipales del evento sismico que fue seleccionado
        gestorRevisionManual.tomarSeleccionEventoSismico(datosSelecciondos);
            
    }
    
    // Mostrar los datos registrados del evento sismico
    public void mostrarDatosSismicosRegistrados(
        List<String> datosPrincipalesEvento,
        List<String> metadatosEvento,
        List<List<Object>> datosSeriesOrdenadas) {
        
        // Quitar todos los componentes del panel
        removeAll();

        // ----- Armar HTML con los datos -----

        StringBuilder html = new StringBuilder();

        // Encabezado con datos principales
        html.append("<html>")
            .append("<h2>Evento Sísmico Seleccionado</h2>")
            .append("<table cellpadding='4' border='1' style='border-collapse:collapse;'>")
            .append("<tr><td><b>Fecha y Hora de Ocurrencia:</b></td><td>").append(datosPrincipalesEvento.get(0)).append("</td></tr>")
            .append("<tr><td><b>Latitud Epicentro:</b></td><td>").append(datosPrincipalesEvento.get(1)).append("</td></tr>")
            .append("<tr><td><b>Longitud Epicentro:</b></td><td>").append(datosPrincipalesEvento.get(2)).append("</td></tr>")
            .append("<tr><td><b>Latitud Hipocentro:</b></td><td>").append(datosPrincipalesEvento.get(3)).append("</td></tr>")
            .append("<tr><td><b>Longitud Hipocentro:</b></td><td>").append(datosPrincipalesEvento.get(4)).append("</td></tr>")
            .append("</table>");

        // Metadatos del evento
        html.append("<h3>Metadatos del Evento</h3>")
            .append("<ul>")
            .append("<li><b>Alcance:</b> ").append(metadatosEvento.get(0)).append("</li>")
            .append("<li><b>Clasificación:</b> ").append(metadatosEvento.get(1)).append("</li>")
            .append("<li><b>Origen:</b> ").append(metadatosEvento.get(2)).append("</li>")
            .append("</ul>");

        // Series temporales
        html.append("<h3>Datos Registrados (Series Temporales por Estación)</h3>");

        for (List<Object> serie : datosSeriesOrdenadas) {
            String codigoEstacion = (String) serie.get(0);
            String nombreEstacion = (String) serie.get(1);

            html.append("<h4>Estación: ").append(codigoEstacion).append(" - ").append(nombreEstacion).append("</h4>");

            html.append("<ul>");
            for (int i = 2; i < serie.size(); i++) {
                Object muestra = serie.get(i);
                html.append("<li>").append(muestra.toString()).append("</li>");
            }
            html.append("</ul>");
        }

        html.append("</html>");

        // Mostrar en un JLabel con scroll
        javax.swing.JLabel label = new javax.swing.JLabel(html.toString());
        label.setBorder(new EmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(label,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        // Agregar al panel
        add(scrollPane, BorderLayout.CENTER);

        // Refrescar la vista
        revalidate();
        repaint();
    }


}
