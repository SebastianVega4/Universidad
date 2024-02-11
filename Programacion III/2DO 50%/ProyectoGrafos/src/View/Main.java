package View;

import Logic.Grafo;

import javax.swing.*;

// Clase principal que contiene la lógica principal del programa
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trayecto más corto");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            Grafo grafo = new Grafo();
// Agregar ciudades y distancias aquí, por ejemplo:
// grafo.agregarCiudad("Bogotá", "Medellín", 300);
            grafo.agregarCiudad("Bogotá", "Medellín", 300);
            grafo.agregarCiudad("Bogotá", "Cali", 400);
            grafo.agregarCiudad("Medellín", "Cartagena", 500);
            grafo.agregarCiudad("Cali", "Barranquilla", 600);

            String trayecto = grafo.encontrarTrayectoCorto("Bogotá", "Cartagena");
            System.out.println(trayecto); // Imprime "Bogotá -> Medellín -> Cartagena"


            PanelPrincipal panel = new PanelPrincipal(grafo);
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);
        });
    }
}