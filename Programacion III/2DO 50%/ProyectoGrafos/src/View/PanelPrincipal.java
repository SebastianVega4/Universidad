package View;

import Logic.Grafo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PanelPrincipal extends JPanel {
    private final Grafo grafo;
    private final JComboBox<String> listaOrigen;
    private final JComboBox<String> listaDestino;
    private final JButton botonBuscar;
    private final JTextArea areaRutas;

    public PanelPrincipal(Grafo grafo) {
        this.grafo = grafo;

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Labels and combo boxes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Ciudad de Origen:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        List<String> nombresCiudades = grafo.obtenerNombresCiudades();
        listaOrigen = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        add(listaOrigen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Ciudad de Destino:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        listaDestino = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        add(listaDestino, gbc);

        // Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        botonBuscar = new JButton("Buscar Trayecto");
        botonBuscar.addActionListener(this::buscarTrayecto);
        add(botonBuscar, gbc);

        // Text area
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        areaRutas = new JTextArea(20, 40);
        areaRutas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaRutas);
        add(scrollPane, gbc);

        // Visual enhancements
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);
        listaOrigen.setFont(new Font("Arial", Font.PLAIN, 14));
        listaDestino.setFont(new Font("Arial", Font.PLAIN, 14));
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        areaRutas.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private void buscarTrayecto(ActionEvent e) {
        String origen = (String) listaOrigen.getSelectedItem();
        String destino = (String) listaDestino.getSelectedItem();

        String trayecto = grafo.encontrarTrayectoMasCorto(origen, destino);
        if (trayecto.startsWith("No se encontró")) {
            areaRutas.setText(trayecto);
        } else {
            double distanciaTotal = grafo.calcularDistanciaTotal(trayecto);
            int tiempoEstimadoHoras = (int) grafo.calcularTiempoEstimado(trayecto, 70); // Velocidad promedio de 60 km/h
            int tiempoEstimadoMinutos = (int) ((grafo.calcularTiempoEstimado(trayecto, 70) * 60) % 60); // Obtener los minutos restantes
            String informacionTrayecto = "Ruta más corta: " + trayecto +
                    "\nDistancia total: " + distanciaTotal + " km" +
                    "\nTiempo estimado: " + tiempoEstimadoHoras + " Horas " + tiempoEstimadoMinutos + " Minutos";
            areaRutas.setText(informacionTrayecto);
        }
    }
}