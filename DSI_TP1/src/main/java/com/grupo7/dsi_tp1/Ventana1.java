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

/**
 * Ventana1 actualizada: ahora el JScrollPane muestra siempre la barra vertical
 * a la derecha cuando el contenido desborda.
 */
public class Ventana1 extends JPanel {

    private GestorRevisionManual gestorRevisionManual;
    private JList<List<String>> eventList;
    private DefaultListModel<List<String>> listModel;
    private int hoverIndex = -1;

    public Ventana1(List<EventoSismico> listaEventos,
                    List<Estado> listaEstados,
                    List<Usuario> listaUsuarios) {
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

        // Botón en la zona norte para cargar datos
        javax.swing.JButton jButton1 = new javax.swing.JButton("Registrar resultado revisión manual");
        jButton1.addActionListener(evt -> cargarDatosEnLista());
        add(jButton1, BorderLayout.NORTH);

        // Instanciar el gestor
        this.gestorRevisionManual = new GestorRevisionManual(
            listaEventos, listaEstados, listaUsuarios
        );

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
        });

        // Al agregar a un JFrame, pedir maximizar
        SwingUtilities.invokeLater(() -> {
            JFrame top = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (top != null) {
                top.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    private void cargarDatosEnLista() {
        listModel.clear();
        List<List<String>> datosPrincipales =
            gestorRevisionManual.buscarEventosSismicosNoRevisados();

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
}
