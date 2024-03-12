package co.edu.uptc.View;

import co.edu.uptc.Logic.Grafo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanelPrincipal extends JPanel {
    private final Grafo grafo;
    private final List<JComboBox<String>> listaCiudadesIntermedias;
    private final List<JLabel> listaLabelsCiudadesIntermedias;
    private final List<String> nombresCiudades;
    private final JButton botonAgregarCiudad;
    private final JButton botonBuscar;
    private final JTextArea areaRutas;
    private JPanel panelTop, panelCenter, panelBottom;
    private final JButton botonEliminarCiudad;
    private JLabel mapa;
    private int ciudArega=1;

    public PanelPrincipal(Grafo grafo) {
        this.grafo = grafo;
        this.listaCiudadesIntermedias = new ArrayList<>();
        this.listaLabelsCiudadesIntermedias = new ArrayList<>();

        // Crear paneles top, center y bottom
        panelTop = new JPanel(new GridBagLayout());
        panelCenter = new JPanel(new BorderLayout());
        panelBottom = new JPanel(new GridBagLayout());

        // Añadir paneles al panel principal
        setLayout(new BorderLayout());
        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Labels and combo boxes (en panelTop)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelTop.add(new JLabel("Ciudad de Origen:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        nombresCiudades = grafo.obtenerNombresCiudades();
        Collections.sort(nombresCiudades);
        JComboBox<String> listaOrigen = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        panelTop.add(listaOrigen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelTop.add(new JLabel("Ciudad de Destino:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JComboBox<String> listaDestino = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        panelTop.add(listaDestino, gbc);

        // Button to add intermediate cities (en panelCenter)
        botonAgregarCiudad = new JButton("Agregar Ciudad");
        botonAgregarCiudad.addActionListener(this::agregarCiudadIntermedia);

        // New button to remove intermediate cities (en panelCenter)
        botonEliminarCiudad = new JButton("Eliminar Ciudad Intermedia");
        botonEliminarCiudad.addActionListener(this::eliminarCiudadIntermedia);

        // Button to search route (en panelCenter)
        botonBuscar = new JButton("Buscar Trayecto");
        botonBuscar.addActionListener(this::buscarTrayecto);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(botonAgregarCiudad);
        panelBotones.add(botonEliminarCiudad);
        panelBotones.add(botonBuscar);

        // Load and display map image
        ImageIcon imageIcon = new ImageIcon("src/main/java/co/edu/uptc/View/map.jpg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        mapa = new JLabel(new ImageIcon(newImage));
        panelCenter.add(mapa, BorderLayout.CENTER);
        panelCenter.add(panelBotones, BorderLayout.SOUTH);

        // Text area (en panelBottom)
        areaRutas = new JTextArea(20, 40);
        areaRutas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaRutas);
        panelBottom.add(scrollPane, gbc);

        // Visual enhancements
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);
        listaOrigen.setFont(new Font("Arial", Font.PLAIN, 14));
        listaDestino.setFont(new Font("Arial", Font.PLAIN, 14));
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        areaRutas.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private void agregarCiudadIntermedia(ActionEvent e) {
        if (listaCiudadesIntermedias.size() < 5) { // Limitar a 5 ciudades intermedias por simplicidad
            JComboBox<String> nuevaLista = new JComboBox<>(nombresCiudades.toArray(new String[0]));
            listaCiudadesIntermedias.add(nuevaLista);

            JLabel nuevaEtiqueta = new JLabel(ciudArega++ + ". Ciudad intermedia:");
            listaLabelsCiudadesIntermedias.add(nuevaEtiqueta);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 2 + (listaCiudadesIntermedias.size() - 1) * 2; // Incrementar la columna para cada nueva ciudad intermedia
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.gridy = 0; // Fija la fila a 0 para todas las ciudades intermedias

            panelTop.add(nuevaEtiqueta, gbc);

            gbc.gridy = 1; // Cambia la fila para la lista de ciudades intermedias
            gbc.anchor = GridBagConstraints.LINE_START;
            panelTop.add(nuevaLista, gbc);

            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más de 5 ciudades intermedias.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCiudadIntermedia(ActionEvent e) {
        if (!listaCiudadesIntermedias.isEmpty()) {
            ciudArega--;
            int tamanioActual = listaCiudadesIntermedias.size();
            panelTop.remove(listaLabelsCiudadesIntermedias.get(tamanioActual - 1)); // Eliminar JLabel
            panelTop.remove(listaCiudadesIntermedias.get(tamanioActual - 1)); // Eliminar JComboBox
            panelTop.revalidate();
            panelTop.repaint();

            listaCiudadesIntermedias.removeLast();
            listaLabelsCiudadesIntermedias.removeLast();
        } else {
            JOptionPane.showMessageDialog(this, "No hay ciudades intermedias para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarTrayecto(ActionEvent e) {
        String origen = (String) ((JComboBox<?>) panelTop.getComponent(1)).getSelectedItem();
        String destino = (String) ((JComboBox<?>) panelTop.getComponent(3)).getSelectedItem();

        List<String> ciudadesIntermedias = new ArrayList<>();
        for (JComboBox<String> listaIntermedia : listaCiudadesIntermedias) {
            String ciudadIntermedia = (String) listaIntermedia.getSelectedItem();
            if (ciudadIntermedia != null) {
                ciudadesIntermedias.add(ciudadIntermedia);
            }
        }

        ciudadesIntermedias.addFirst(origen);
        ciudadesIntermedias.add(destino);

        String trayecto = grafo.encontralTrayectoTotal(ciudadesIntermedias);
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