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
            grafo.agregarCiudad("Bogota", "Medellin", 300);
            grafo.agregarCiudad("Bogota", "Cali", 400);
            grafo.agregarCiudad("Medellin", "Cartagena", 500);
            grafo.agregarCiudad("Cali", "Barranquilla", 600);

            String trayecto = grafo.encontrarTrayectoCorto("Bogota", "Cartagena");
            System.out.println(trayecto); // "Bogota -> Medellin -> Cartagena"
            System.out.println(grafo);


            PanelPrincipal panel = new PanelPrincipal(grafo);System.out.println(grafo);
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);
        });
    }
}