package View;

import Logic.Grafo;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trayecto más corto");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            Grafo grafo = new Grafo();

            grafo.agregarCiudad("Medellin", "Cartagena", 500);
            grafo.agregarCiudad("Cali", "Barranquilla", 600);
            grafo.agregarCiudad("Bogota", "Medellin", 300);
            grafo.agregarCiudad("Bogota", "Cali", 400);
            grafo.agregarCiudad("Bogota", "Tunja", 157);
            grafo.agregarCiudad("Bogota", "Tunja", 157);
            grafo.agregarCiudad("Tunja", "Chiquinquira", 45);
            grafo.agregarCiudad("Tunja", "Sachica", 35);
            grafo.agregarCiudad("Tunja", "Ibague", 120);
            grafo.agregarCiudad("Paipa", "Tunja", 41);
            grafo.agregarCiudad("Paipa", "Duitama", 25);
            grafo.agregarCiudad("Paipa", "Tuta", 14);
            grafo.agregarCiudad("Duitama", "SantaRosa", 14);
            grafo.agregarCiudad("Duitama", "Nobsa", 8);
            grafo.agregarCiudad("Duitama", "Tibasosa", 8);
            grafo.agregarCiudad("Sogamoso", "Gameza", 21);
            grafo.agregarCiudad("Sogamoso", "Aquitania", 22);
            grafo.agregarCiudad("Sogamoso", "Firavitoba", 18);
            grafo.agregarCiudad("Sogamoso", "Iza", 20);
            grafo.agregarCiudad("Sogamoso", "Morca", 10);
            grafo.agregarCiudad("Sogamoso", "Nobsa", 12);
            grafo.agregarCiudad("Sogamoso", "Tibasosa", 7);
            grafo.agregarCiudad("SantaRosa", "Cerinza", 10);
            grafo.agregarCiudad("SantaRosa", "Tobasia", 8);
            grafo.agregarCiudad("Belen", "Cerinza", 7);
            grafo.agregarCiudad("Belen", "PazDelRio", 22);
            grafo.agregarCiudad("Jerico", "PazDelRio", 20);
            grafo.agregarCiudad("Tasco", "PazDelRio", 12);
            grafo.agregarCiudad("Corrales", "Tasco", 18);
            grafo.agregarCiudad("Corrales", "Gameza", 19);
            grafo.agregarCiudad("Corrales", "Topaga", 11);
            grafo.agregarCiudad("Corrales", "Busbanza", 4);
            grafo.agregarCiudad("Floresta", "Busbanza", 7);
            grafo.agregarCiudad("Tobasia", "Floresta", 4);
            grafo.agregarCiudad("Nazareth", "Nobsa", 4);
            grafo.agregarCiudad("Nazareth", "Corrales", 15);
            grafo.agregarCiudad("Mongui", "Morca", 12);
            grafo.agregarCiudad("Mongui", "Topaga", 6);

            grafo.agregarCiudad("Iza", "Cuitiva", 10);
            grafo.agregarCiudad("Cuitiva", "Tota", 15);
            grafo.agregarCiudad("Tota", "Aquitania", 12);
            grafo.agregarCiudad("Aquitania", "Gameza", 18);
            grafo.agregarCiudad("Gameza", "Soata", 14);
            grafo.agregarCiudad("Soata", "Susacon", 10);
            grafo.agregarCiudad("Susacon", "Chita", 12);
            grafo.agregarCiudad("Chita", "Jerico", 18);
            grafo.agregarCiudad("Tuta", "Pajarito", 10);
            grafo.agregarCiudad("LabranzaGrande", "Pajarito", 12);
            grafo.agregarCiudad("Chiquinquira", "Velez", 60);
            grafo.agregarCiudad("Velez", "Socota", 40);
            grafo.agregarCiudad("Socota", "Guateque", 30);
            grafo.agregarCiudad("Guateque", "Sachica", 20);





            PanelPrincipal panel = new PanelPrincipal(grafo);
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);
        });
    }
}