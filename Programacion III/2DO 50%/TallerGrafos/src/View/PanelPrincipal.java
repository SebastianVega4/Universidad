package View;

import Logic.Grafo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class PanelPrincipal extends JPanel {
    private final Grafo grafo;
    private final List<JComboBox<String>> listaCiudadesIntermedias;
    private final JButton botonAgregarCiudad;
    private final JButton botonBuscar;
    private final JTextArea areaRutas;

    public PanelPrincipal(Grafo grafo) {
        this.grafo = grafo;
        this.listaCiudadesIntermedias = new ArrayList<>();

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
        JComboBox<String> listaOrigen = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        add(listaOrigen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Ciudad de Destino:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JComboBox<String> listaDestino = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        add(listaDestino, gbc);

        // Button to add intermediate cities
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        botonAgregarCiudad = new JButton("Agregar Ciudad");
        botonAgregarCiudad.addActionListener(this::agregarCiudadIntermedia);
        add(botonAgregarCiudad, gbc);

        // Button to search route
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        botonBuscar = new JButton("Buscar Trayecto");
        botonBuscar.addActionListener(this::buscarTrayecto);
        add(botonBuscar, gbc);

        // Text area
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
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

    private void agregarCiudadIntermedia(ActionEvent e) {
        if (listaCiudadesIntermedias.size() < 5) { // Limit to 5 intermediate cities for simplicity
            JComboBox<String> nuevaLista = new JComboBox<>(grafo.obtenerNombresCiudades().toArray(new String[0]));
            listaCiudadesIntermedias.add(nuevaLista);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = listaCiudadesIntermedias.size() + 1;
            gbc.anchor = GridBagConstraints.LINE_END;
            add(new JLabel("Ciudad intermedia:"), gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            add(nuevaLista, gbc);

            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más de 5 ciudades intermedias.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarTrayecto(ActionEvent e) {
        String origen = (String) ((JComboBox<?>) getComponent(1)).getSelectedItem();
        String destino = (String) ((JComboBox<?>) getComponent(3)).getSelectedItem();

        List<String> ciudadesIntermedias = new ArrayList<>();
        for (JComboBox<String> listaIntermedia : listaCiudadesIntermedias) {
            String ciudadIntermedia = (String) listaIntermedia.getSelectedItem();
            if (ciudadIntermedia != null) {
                ciudadesIntermedias.add(ciudadIntermedia);
            }
        }

        ciudadesIntermedias.add(0, origen);
        ciudadesIntermedias.add(destino);

        String trayecto = grafo.encontrarTrayectoMasCorto(ciudadesIntermedias);
        if (trayecto.startsWith("No se encontró")) {
            areaRutas.setText(trayecto);
        } else {
            double distanciaTotal = grafo.calcularDistanciaTotal(trayecto);
            int tiempoEstimadoHoras = (int) grafo.calcularTiempoEstimado(trayecto, 50); // Velocidad promedio de 50 km/h
            int tiempoEstimadoMinutos = (int) ((grafo.calcularTiempoEstimado(trayecto, 50) * 60) % 60); // Obtener los minutos restantes
            String informacionTrayecto = "Ruta más corta: " + trayecto +
                    "\nDistancia total: " + distanciaTotal + " km" +
                    "\nTiempo estimado: " + tiempoEstimadoHoras + " Horas " + tiempoEstimadoMinutos + " Minutos";
            areaRutas.setText(informacionTrayecto);
        }
    }
}