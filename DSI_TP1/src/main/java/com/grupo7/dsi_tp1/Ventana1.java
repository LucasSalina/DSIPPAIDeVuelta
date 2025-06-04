package com.grupo7.dsi_tp1;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane; // Import JScrollPane

public class Ventana1 extends javax.swing.JPanel {

    private GestorRevisionManual gestorRevisionManual; // Field to hold the instance
    private JList<String> eventList; // JList to display the data
    private DefaultListModel<String> listModel; // Model for the JList

    public Ventana1() {
        // Initialize the list model
        listModel = new DefaultListModel<>();
        initComponents();
        // Set the model for the JList
        eventList.setModel(listModel);

        // Instantiate the GestorRevisionManual
        // In a real application, this might be passed in or managed by a larger system
        this.gestorRevisionManual = new GestorRevisionManual();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        eventList = new javax.swing.JList<>(); // Initialize the JList
        JScrollPane scrollPane = new JScrollPane(eventList); // Wrap JList in JScrollPane

        jButton1.setText("Registrar resultado revisión manual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Add scrollPane
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Add some space
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE) // Add scrollPane and set preferred height
                .addContainerGap(50, Short.MAX_VALUE)) // Adjust padding
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        listModel.clear();

        // ArrayList<ArrayList<String>> eventosNoRevisados = gestorRevisionManual.buscarEventosSismicosNoRevisados();

        // Check if the returned list is not null (though it should be initialized as empty)
        // if (eventosNoRevisados != null && !eventosNoRevisados.isEmpty()) {
        //  for (ArrayList<String> eventData : eventosNoRevisados) {
        //        // Example: ["Magnitud: 5.2", "Fecha: 2025-06-03"] -> "Magnitud: 5.2, Fecha: 2025-06-03"
        //        String formattedEvent = String.join(", ", eventData);
        //        listModel.addElement(formattedEvent);
        //    }
        //} else {
        //    listModel.addElement("No hay eventos sísmicos no revisados para mostrar.");
        //}
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    // End of variables declaration
}