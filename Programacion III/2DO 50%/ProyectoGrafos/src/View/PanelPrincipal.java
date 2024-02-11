package View;

// Clase que representa el panel principal de la interfaz gráfica

import Logic.Grafo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase que representa el panel principal de la interfaz gráfica
class PanelPrincipal extends JPanel {
    private final Grafo grafo;
    private final JTextField campoOrigen;
    private final JTextField campoDestino;
    private final JButton botonBuscar;

    public PanelPrincipal(Grafo grafo) {
        this.grafo = grafo;

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Ciudad de Origen:"));
        campoOrigen = new JTextField();
        add(campoOrigen);

        add(new JLabel("Ciudad de Destino:"));
        campoDestino = new JTextField();
        add(campoDestino);

        botonBuscar = new JButton("Buscar Trayecto");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origen = campoOrigen.getText();
                String destino = campoDestino.getText();

                String trayecto = grafo.encontrarTrayectoCorto(origen, destino);
                System.out.println(grafo);
                System.out.println(origen);
                System.out.println(destino);
                // Mostrar el resultado en la interfaz gráfica
                System.out.println(trayecto);
            }
        });
        add(botonBuscar);
    }
}