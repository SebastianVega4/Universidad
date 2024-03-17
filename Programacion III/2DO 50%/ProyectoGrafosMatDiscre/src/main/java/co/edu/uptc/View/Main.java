package co.edu.uptc.View;

import co.edu.uptc.Logic.Grafo;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trayecto más corto con Algoritmo Dikstra(Grafos)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Grafo grafo = new Grafo();

            // Tunja
            grafo.agregarCiudad("Tunja", "Motavita", 4.8);
            grafo.agregarCiudad("Tunja", "Soraca", 8.5);
            grafo.agregarCiudad("Tunja", "Puente de Boyaca", 13.8);
            grafo.agregarCiudad("Tunja", "Cucaita", 17.8);
            grafo.agregarCiudad("Tunja", "Combita", 15);
            grafo.agregarCiudad("Tunja", "Paipa", 41.5);
            grafo.agregarCiudad("Tunja", "Sutamarchan", 44.3);
            grafo.agregarCiudad("Tunja", "Villa de Leyva", 38.3);
            grafo.agregarCiudad("Tunja", "Sachica", 33.3);
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
            grafo.agregarCiudad("Sogamoso", "Alcaparral", 12.8);

            // Conexiones Santa Rosa de Viterbo
            grafo.agregarCiudad("Santa Rosa de Viterbo", "Tobasia", 10.3);
            grafo.agregarCiudad("Santa Rosa de Viterbo", "Chuche", 8);
            grafo.agregarCiudad("Santa Rosa de Viterbo", "Cerinza", 11);
            grafo.agregarCiudad("Santa Rosa de Viterbo","Belen",17);

            // Conexiones Belén
            grafo.agregarCiudad("Belen", "Cerinza", 5.7);
            grafo.agregarCiudad("Belen", "Las puentes", 10.3);
            grafo.agregarCiudad("Belen", "Paz del Rio", 24.9);
            grafo.agregarCiudad("Belen", "Tutaza", 14.1);
            grafo.agregarCiudad("Belen", "Beteitiva", 26.3);

            // Conexiones Tasco
            grafo.agregarCiudad("Tasco", "Beteitiva", 17.9);
            grafo.agregarCiudad("Tasco", "Paz del Rio", 14.3);
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
            grafo.agregarCiudad("Pesca", "Alcaparral", 10.7);
            grafo.agregarCiudad("Pesca", "Tota", 13.3);
            grafo.agregarCiudad("Pesca", "Toca", 30);

            // Conexiones Chivata
            grafo.agregarCiudad("Chivata", "Toca", 14.3);
            grafo.agregarCiudad("Chivata", "Oicata", 5.8);
            grafo.agregarCiudad("Chivata", "Tunja", 11.8);

            // Conexiones Oicata
            grafo.agregarCiudad("Oicata", "Tunja", 14.3);
            grafo.agregarCiudad("Oicata", "Combita",8.7);
            grafo.agregarCiudad("Oicata", "Tuta", 18.4);
            grafo.agregarCiudad("Oicata", "Sotaquira", 30.6);
            grafo.agregarCiudad("Oicata", "Paipa", 35.3);

            // Conexiones Siachoque
            grafo.agregarCiudad("Siachoque", "Toca", 10.7);
            grafo.agregarCiudad("Siachoque", "Tunja", 19.4);

            // Conexiones Santa Teresita
            grafo.agregarCiudad("Santa Teresita", "Cucaita", 15.3);
            grafo.agregarCiudad("Santa Teresita", "Villa de Leyva", 6);

            // Conexiones de Paipa
            grafo.agregarCiudad("Paipa", "Sotaquira", 18.4);
            grafo.agregarCiudad("Paipa", "Tuta",19.5);
            grafo.agregarCiudad("Paipa", "Duitama", 13.4);
            grafo.agregarCiudad("Paipa", "Toca", 30.3);
            grafo.agregarCiudad("Paipa", "Pantano de Vargas", 10.7);

            // Conexiones de Duitama
            grafo.agregarCiudad("Duitama", "Santa Rosa de Viterbo", 9.4);
            grafo.agregarCiudad("Duitama", "Punta larga",8.1);
            grafo.agregarCiudad("Duitama", "Tibasosa", 11.7);
            grafo.agregarCiudad("Duitama", "Sogamoso", 20.3);
            grafo.agregarCiudad("Duitama", "Santa Ana", 6.3);

            // Conexiones Pantano de Vargas
            grafo.agregarCiudad("Pantano de Vargas", "Duitama", 13);
            grafo.agregarCiudad("Pantano de Vargas", "Firavitoba", 18.8);

            // Conexiones Tuta
            grafo.agregarCiudad("Tuta", "Toca", 23.2);

            // Conexiones Punta larga
            grafo.agregarCiudad("Punta larga", "Nobsa", 9.7);
            grafo.agregarCiudad("Punta larga", "Chameza Mayor",10.8 );

            // Conexiones Belencito
            grafo.agregarCiudad("Belencito", "Chameza Mayor", 4.3);

            // Conexiones Tutaza
            grafo.agregarCiudad("Tutaza", "Beteitiva", 26.8);
            grafo.agregarCiudad("Tutaza", "Cartavita", 6.6);

            // Conexiones Páramo
            grafo.agregarCiudad("Páramo", "Cartavita", 11.3);
            grafo.agregarCiudad("Páramo", "Belen", 23.2);

            // Conexiones Chameza Mayor
            grafo.agregarCiudad("Chameza Mayor", "La esperanza", 14.2);
            grafo.agregarCiudad("Chameza Mayor", "Gameza", 17.5);

            // Conexiones Iza
            grafo.agregarCiudad("Iza", "Firavitoba", 7);
            grafo.agregarCiudad("Iza", "Alcaparral", 5.5);

            // Conexiones Firavitoba
            grafo.agregarCiudad("Firavitoba", "Alcaparral", 4.8);

            // Conexiones Buenavista
            grafo.agregarCiudad("Buenavista", "Arcabuco", 10.8);
            grafo.agregarCiudad("Buenavista", "Combita", 15.8);

            // Conexiones Arcabuco
            grafo.agregarCiudad("Arcabuco", "Patio bonito", 17.1);
            grafo.agregarCiudad("Arcabuco", "Villa de Leyva", 25.9);

            // Conexiones Combita
            grafo.agregarCiudad("Combita", "Tuta", 22.4);
            grafo.agregarCiudad("Combita", "Sotaquira", 34.7);
            grafo.agregarCiudad("Combita", "Paipa", 39.3);

            // Conexiones Motavia
            grafo.agregarCiudad("Motavita", "Combita", 13.3);

            // Conexiones Sotaquira
            grafo.agregarCiudad("Sotaquira", "Tuta", 16.4);

            // Conexiones Gameza
            grafo.agregarCiudad("Gameza", "La esperanza", 15.6);

            PanelPrincipal panel = new PanelPrincipal(grafo);
            frame.getContentPane().add(panel);
            frame.setVisible(true);
        });
    }
}