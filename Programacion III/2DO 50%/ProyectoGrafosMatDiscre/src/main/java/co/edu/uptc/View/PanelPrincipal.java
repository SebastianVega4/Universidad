package co.edu.uptc.View;

import co.edu.uptc.Logic.Grafo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PanelPrincipal extends JPanel {
    private final Grafo grafo;
    private final List<JComboBox<String>> listaCiudadesIntermedias;
    private final List<JLabel> listaLabelsCiudadesIntermedias;
    private final List<String> nombresCiudades;
    private final JTextArea areaRutas;
    private final JPanel panelTop;
    private int ciudArega=1;
    private BufferedImage backgroundImage;
    private final JPanel panelImages = new JPanel();

    public PanelPrincipal(Grafo grafo) {
        this.grafo = grafo;
        this.listaCiudadesIntermedias = new ArrayList<>();
        this.listaLabelsCiudadesIntermedias = new ArrayList<>();

        panelTop = new JPanel(new GridBagLayout());
        JPanel panelCenter = new JPanel(new BorderLayout());
        JPanel panelBottom = new JPanel(new GridBagLayout());

        //Panel principal
        setLayout(new BorderLayout());
        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        //PanelTop
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        JLabel ciudadOrigen =new JLabel("Ciudad de Origen:");
        ciudadOrigen.setForeground(Color.WHITE);
        ciudadOrigen.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        panelTop.add(ciudadOrigen, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        nombresCiudades = grafo.obtenerNombresCiudades();
        Collections.sort(nombresCiudades);
        JComboBox<String> listaOrigen = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        listaOrigen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelTop.add(listaOrigen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        JLabel ciudadDestino = new JLabel("Ciudad de Destino:");
        ciudadDestino.setForeground(Color.WHITE);
        ciudadDestino.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        panelTop.add(ciudadDestino, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JComboBox<String> listaDestino = new JComboBox<>(nombresCiudades.toArray(new String[0]));
        listaDestino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelTop.add(listaDestino, gbc);

        //panelCenter)
        JButton botonAgregarCiudad = new JButton("Agregar Ciudad");
        botonAgregarCiudad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonAgregarCiudad.addActionListener(this::agregarCiudadIntermedia);

        JButton botonEliminarCiudad = new JButton("Eliminar Ciudad Intermedia");
        botonEliminarCiudad.addActionListener(this::eliminarCiudadIntermedia);
        botonEliminarCiudad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton botonBuscar = new JButton("Buscar Trayecto");
        botonBuscar.addActionListener(this::buscarTrayecto);
        botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(botonAgregarCiudad);
        panelBotones.add(botonEliminarCiudad);
        panelBotones.add(botonBuscar);
        JLabel byLink = new JLabel("         By: github.com/SebastianVega4");
        byLink.setFont(new Font("Courier", Font.ITALIC, 11));
        byLink.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        byLink.setForeground(Color.WHITE);
        panelBotones.add(byLink);
        panelBotones.setOpaque(false);

        //image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/map.jpg"));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        JLabel mapa = new JLabel(new ImageIcon(newImage));
        panelCenter.add(mapa, BorderLayout.CENTER);
        panelCenter.add(panelBotones, BorderLayout.SOUTH);

        // Establecer el color de fondo transparente
        setBackground(new Color(0, 0, 0, 0)); // Color transparente
        panelTop.setOpaque(false);
        panelCenter.setOpaque(false);
        panelBottom.setOpaque(false);
        setOpaque(false);

        //panelBottom)
        JPanel panelText = new JPanel(new BorderLayout());
        areaRutas = new JTextArea(6, 75);
        areaRutas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaRutas);
        panelText.add(scrollPane, BorderLayout.CENTER);

        panelImages.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        panelImages.setOpaque(false);

        panelBottom.setLayout(new BorderLayout());
        panelBottom.add(panelText, BorderLayout.CENTER);
        panelBottom.add(panelImages, BorderLayout.SOUTH);

        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);
        listaOrigen.setFont(new Font("Arial", Font.PLAIN, 14));
        listaDestino.setFont(new Font("Arial", Font.PLAIN, 14));
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        areaRutas.setFont(new Font("Arial", Font.PLAIN, 12));

        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/fondo.jpg")); // Reemplaza "fondo.jpg" con la ruta correcta de tu imagen
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void agregarCiudadIntermedia(ActionEvent e) {
        if (listaCiudadesIntermedias.size() < 5) { // Limitar a 5 ciudades intermedias por simplicidad
            JComboBox<String> nuevaLista = new JComboBox<>(nombresCiudades.toArray(new String[0]));
            nuevaLista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            listaCiudadesIntermedias.add(nuevaLista);

            JLabel nuevaEtiqueta = new JLabel(ciudArega++ + ". Ciudad intermedia:");
            nuevaEtiqueta.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            nuevaEtiqueta.setForeground(Color.WHITE);
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
        panelImages.removeAll();
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
        } else {            double distanciaTotal = grafo.calcularDistanciaTotal(trayecto);
            int tiempoEstimadoHoras = (int) grafo.calcularTiempoEstimado(trayecto, 50); // Velocidad promedio de 50 km/h
            int tiempoEstimadoMinutos = (int) ((grafo.calcularTiempoEstimado(trayecto, 50) * 60) % 60); // Obtener los minutos restantes


            String mensaje = "RUTA MAS CORTA A SEGUIR:\n" +
                    "----------------------\n" +
                    trayecto+ "\n" +
                    "Distancia total: " + String.format("%.2f", distanciaTotal) + " km\n" +
                    "Tiempo estimado: " + tiempoEstimadoHoras + " horas " + tiempoEstimadoMinutos + " minutos\n";
            areaRutas.setText(mensaje);
        }
        for (String ciudadIntermedia : ciudadesIntermedias) {
            showImage(ciudadIntermedia);
        }
    }

    private void showImage(String cityName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/imagenes/" + cityName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null) {
            int scaledWidth = 200;
            int scaledHeight = 200;
            Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            panelImages.add(imageLabel);
            panelImages.revalidate();
            panelImages.repaint();
        }
    }
}