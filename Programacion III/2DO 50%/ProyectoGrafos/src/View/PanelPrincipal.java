package View;

import Logic.Grafo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelPrincipal extends JPanel {
    private final Grafo grafo;
    private final JComboBox<String> listaOrigen;
    private final JComboBox<String> listaDestino;
    private final JButton botonBuscar;
    private final JTextArea areaRutas;

    public PanelPrincipal(Grafo grafo) {
        this.grafo = grafo;

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Ciudad de Origen:"));
        List<String> nombresCiudades = grafo.obtenerNombresCiudades();
        listaOrigen = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        add(listaOrigen);

        add(new JLabel("Ciudad de Destino:"));
        listaDestino = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        add(listaDestino);

        botonBuscar = new JButton("Buscar Trayecto");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origen = (String) listaOrigen.getSelectedItem();
                String destino = (String) listaDestino.getSelectedItem();

                String trayecto = grafo.encontrarTrayectoCorto(origen, destino);
                areaRutas.setText(trayecto);
            }
        });
        add(botonBuscar);

        areaRutas = new JTextArea(10, 20);
        areaRutas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaRutas);
        add(scrollPane);
    }
}