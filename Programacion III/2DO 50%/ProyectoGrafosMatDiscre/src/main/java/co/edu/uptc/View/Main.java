package co.edu.uptc.View;

import co.edu.uptc.Logic.Grafo;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trayecto más corto");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            Grafo grafo = new Grafo();

            // Tunja
            grafo.agregarCiudad("Tunja", "Motavita", 4.8);
            grafo.agregarCiudad("Tunja", "Soraca", 8.5);
            grafo.agregarCiudad("Tunja", "Puente de Boyaca", 13.8);
            grafo.agregarCiudad("Tunja", "Cucaita", 17.8);
            grafo.agregarCiudad("Tunja", "Combita", 15);
            grafo.agregarCiudad("Tunja", "Paipa", 41.5);
            grafo.agregarCiudad("Tunja", "Sutamerchan", 44.3);
            grafo.agregarCiudad("Tunja", "Villa de Leiva", 38.3);
            grafo.agregarCiudad("Tunja", "Sachicha", 33.3);
            grafo.agregarCiudad("Tunja", "Tuta", 24.6);
            grafo.agregarCiudad("Tunja", "Sotaquira", 36.9);

             // Conexiones Sogamoso
            grafo.agregarCiudad("Sogamoso", "Nobsa", 7.1);
            grafo.agregarCiudad("Sogamoso", "Tibasosa", 8.9);
            grafo.agregarCiudad("Sogamoso", "Punta larga", 11);
            grafo.agregarCiudad("Sogamoso", "El crucero", 18.9);
            grafo.agregarCiudad("Sogamoso", "Morca", 7.2);
            grafo.agregarCiudad("Sogamoso", "Chameza Mayor", 7.1);
            grafo.agregarCiudad("Sogamoso", "Firavitoba", 10.7);
            grafo.agregarCiudad("Sogamoso", "Iza", 14.8);
            grafo.agregarCiudad("Sogamoso", "Acaparral", 12.8);

            // Conexiones Santa Rosa de Viterbo
            grafo.agregarCiudad("Santa Rosa de Viterbo", "Tobasia", 10.3);
            grafo.agregarCiudad("Santa Rosa de Viterbo", "Chuche", 8);
            grafo.agregarCiudad("Santa Rosa de Viterbo", "Cerinza", 11);

            // Conexiones Belén
            grafo.agregarCiudad("Belen", "Cerinza", 5.7);
            grafo.agregarCiudad("Belen", "Las puentes", 10.3);
            grafo.agregarCiudad("Belen", "Paz del rio", 24.9);
            grafo.agregarCiudad("Belen", "Tutaza", 14.1);
            grafo.agregarCiudad("Belen", "Beteitiva", 26.3);

            // Conexiones Tasco
            grafo.agregarCiudad("Tasco", "Beteitiva", 17.9);
            grafo.agregarCiudad("Tasco", "Paz del rio", 14.3);
            grafo.agregarCiudad("Tasco", "Corrales", 20);

            // Conexiones Paz del Río
            grafo.agregarCiudad("Paz del Rio", "Sativasur", 21.8);
            grafo.agregarCiudad("Paz del Rio", "Tutaza", 23.2);
            grafo.agregarCiudad("Paz del Rio", "Beteitiva", 15.7);

            // Conexiones Floresta
            grafo.agregarCiudad("Floresta", "Las puentes", 16.2);
            grafo.agregarCiudad("Floresta", "Tobasia", 3.2);
            grafo.agregarCiudad("Floresta", "Busbanza", 7.8);

            // Conexiones Otenga
            grafo.agregarCiudad("Otenga", "Las puentes", 15.7);
            grafo.agregarCiudad("Otenga", "Beteitiva", 9.0);

            // Conexiones Corrales
            grafo.agregarCiudad("Corrales", "Busbanza", 5.4);
            grafo.agregarCiudad("Corrales", "Gameza",9.7);
            grafo.agregarCiudad("Corrales", "Chameza Mayor", 16.0);
            grafo.agregarCiudad("Corrales", "La esperanza", 15.4);

            // Conexiones Mongui
            grafo.agregarCiudad("Mongui", "Mongua", 13.5);
            grafo.agregarCiudad("Mongui", "Morca", 9.4);
            grafo.agregarCiudad("Mongui", "La esperanza", 5.1);

            // Conexiones Topaga
            grafo.agregarCiudad("Topaga", "Mongua", 6.5);
            grafo.agregarCiudad("Topaga", "La esperanza", 2.2);

            // Conexiones Aquitania
            grafo.agregarCiudad("Aquitania", "Tota", 20.5);
            grafo.agregarCiudad("Aquitania", "El crucero", 17.3);

            // Conexiones Cuitiva
            grafo.agregarCiudad("Cuitiva", "Tota", 5.8);
            grafo.agregarCiudad("Cuitiva", "El crucero", 15.5);
            grafo.agregarCiudad("Cuitiva", "Iza", 5.2);

            // Conexiones Pesca
            grafo.agregarCiudad("Pesca", "Acaparral", 10.7);
            grafo.agregarCiudad("Pesca", "Tota", 13.3);
            grafo.agregarCiudad("Pesca", "Toca", 30);

            // Conexiones Chivata
            grafo.agregarCiudad("Chivata", "Toca", 14.3);
            grafo.agregarCiudad("Chivata", "Oicata", 5.8);
            grafo.agregarCiudad("Chivata", "Tunja", 11.8);

            // Conexiones Oicata
            grafo.agregarCiudad("Oicata", "Tunja", distancia);
            grafo.agregarCiudad("Oicata", "Combita", distancia);
            grafo.agregarCiudad("Oicata", "Tuta", distancia);
            grafo.agregarCiudad("Oicata", "Sotaquira", distancia);
            grafo.agregarCiudad("Oicata", "Paipa", distancia);

            // Conexiones Siachoque
            grafo.agregarCiudad("Siachoque", "Toca", distancia);
            grafo.agregarCiudad("Siachoque", "Tunja", distancia);

            // Conexiones Santa Teresita
            grafo.agregarCiudad("Santa Teresita", "Cucaita", distancia);
            grafo.agregarCiudad("Santa Teresita", "Villa de Leyva", distancia);

            // Conexiones de Paipa
            grafo.agregarCiudad("Paipa", "Sotaquira", distancia);
            grafo.agregarCiudad("Paipa", "Tuta", distancia);
            grafo.agregarCiudad("Paipa", "Duitama", distancia);
            grafo.agregarCiudad("Paipa", "Toca", distancia);
            grafo.agregarCiudad("Paipa", "Pantano de Vargas", distancia);

            // Conexiones de Duitama
            grafo.agregarCiudad("Duitama", "Santa rosa de Viterbo", distancia);
            grafo.agregarCiudad("Duitama", "Punta larga", distancia);
            grafo.agregarCiudad("Duitama", "Tibasossa", distancia);
            grafo.agregarCiudad("Duitama", "Sogamoso", distancia);
            grafo.agregarCiudad("Duitama", "Santa Ana", distancia);

            // Conexiones Pantano de Vargas
            grafo.agregarCiudad("Pantano de Vargas", "Duitama", distancia);
            grafo.agregarCiudad("Pantano de Vargas", "Firavitoba", distancia);

            // Conexiones Tuta
            grafo.agregarCiudad("Tuta", "Toca", distancia);

            // Conexiones Punta larga
            grafo.agregarCiudad("Punta larga", "Nobsa", distancia);
            grafo.agregarCiudad("Punta larga", "Chameza Mayor", distancia);

            // Conexiones Belencito
            grafo.agregarCiudad("Belencito", "Chameza Mayor", distancia);

            // Conexiones Tutaza
            grafo.agregarCiudad("Tutaza", "Beteitiva", distancia);
            grafo.agregarCiudad("Tutaza", "Cartavita", distancia);

            // Conexiones Páramo
            grafo.agregarCiudad("Páramo", "Cartavita", distancia);
            grafo.agregarCiudad("Páramo", "Belen", distancia);

            // Conexiones Chameza Mayor
            grafo.agregarCiudad("Chameza Mayor", "La esperanza", distancia);
            grafo.agregarCiudad("Chameza Mayor", "Gameza", distancia);

            // Conexiones Iza
            grafo.agregarCiudad("Iza", "Firavitoba", distancia);
            grafo.agregarCiudad("Iza", "Alcaparral", distancia);

            // Conexiones Firavitoba
            grafo.agregarCiudad("Firavitoba", "Alcaparral", distancia);

            // Conexiones Buenavista
            grafo.agregarCiudad("Buenavista", "Arcabuco", distancia);
            grafo.agregarCiudad("Buenavista", "Combita", distancia);

            // Conexiones Arcabuco
            grafo.agregarCiudad("Arcabuco", "Patio bonito", distancia);
            grafo.agregarCiudad("Arcabuco", "Cucaita", distancia);

            // Conexiones Villa de Leyva
            grafo.agregarCiudad("Villa de Leyva", "Cucaita", distancia);

            // Conexiones Combita
            grafo.agregarCiudad("Combita", "Tuta", distancia);
            grafo.agregarCiudad("Combita", "Sotaquira", distancia);
            grafo.agregarCiudad("Combita", "Paipa", distancia);

            // Conexiones Motavia
            grafo.agregarCiudad("Motavia", "Combita", distancia);

            // Conexiones Sotaquira
            grafo.agregarCiudad("Sotaquira", "Tuta", distancia);

            // Conexiones Gameza
            grafo.agregarCiudad("Gameza", "La esperanza", distancia);

            PanelPrincipal panel = new PanelPrincipal(grafo);
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);
        });
    }
}