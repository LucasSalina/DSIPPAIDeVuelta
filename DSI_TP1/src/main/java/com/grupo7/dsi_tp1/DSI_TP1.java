/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.grupo7.dsi_tp1;
import javax.swing.JFrame;

public class DSI_TP1 {
    public static void main(String[] args) {
        Ventana1 ventana = new Ventana1();
        JFrame frame = new JFrame("Aplicación de Revisión Sísmica");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
                frame.add(ventana); // Add your JPanel to the frame
                frame.pack(); // Size the frame to fit its contents
                frame.setLocationRelativeTo(null); // Center the frame on the screen
                frame.setVisible(true); // Make the frame visible
    }
}
