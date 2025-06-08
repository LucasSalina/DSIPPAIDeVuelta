package com.grupo7.dsi_tp1;
import javax.swing.JFrame;
import com.grupo7.dsi_tp1.DataInitializer;

public class DSI_TP1 {
    
    public static void main(String[] args) {
            
        // Creando todas las intancias del programa
        DataInitializer data = new DataInitializer();
        data.initializeAll();
            
        // Creando la ventana
        Ventana1 pantallaRegistrarRevision = new Ventana1(data.listaEventos, data.listaEstados, data.listaUsuarios, data.listaSismografos);
        JFrame frame = new JFrame("Aplicación de Revisión Sísmica");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
                frame.add(pantallaRegistrarRevision); // Add your JPanel to the frame
                frame.pack(); // Size the frame to fit its contents
                frame.setLocationRelativeTo(null); // Center the frame on the screen
                frame.setVisible(true); // Make the frame visible
    }
}
