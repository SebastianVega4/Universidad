package co.edu.uptc.Logic;

import com.google.common.collect.Maps;

import javax.swing.*;
import java.util.*;

public class Grafo {

    private final Map<String, Ciudad> ciudades = Maps.newHashMap();

    public void agregarCiudad(String origen, String destino, double distancia) {
        Ciudad ciudadOrigen = ciudades.computeIfAbsent(origen, Ciudad::new);
        Ciudad ciudadDestino = ciudades.computeIfAbsent(destino, Ciudad::new);
        ciudadOrigen.conectarCon(ciudadDestino, distancia);
    }

    public String encontralTrayectoTotal(List<String> ciudadesAvisitar) {
        List<String> ciudadesPorVisitar = ciudadesAvisitar;
        List<String> trayecto = new ArrayList<>();

        for (int i = 0; i < ciudadesPorVisitar.size() - 1; i++) {
            Ciudad origen = ciudades.get(ciudadesPorVisitar.get(i));
            Ciudad destino = ciudades.get(ciudadesPorVisitar.get(i + 1));
            // Validar si la ciudad ya está en el trayecto
            if (trayecto.contains(destino.getNombre())&& !Objects.equals(destino.getNombre(), ciudadesAvisitar.getLast())) {
                JOptionPane.showMessageDialog(null, "La ciudad '" + destino.getNombre() + "' ya está en el trayecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i>0) trayecto.remove(trayecto.getLast());
            trayecto.addAll(encontrarTrayectoMasCorto(origen, destino));
        }
        return String.join(" -> ", trayecto);
    }
    public List<String> encontrarTrayectoMasCorto(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        for (Ciudad ciudad : ciudades.values()) {
            ciudad.setDistanciaDesdeOrigen(Double.POSITIVE_INFINITY);
            ciudad.setPredecesor(null);
        }

        ciudadOrigen.setDistanciaDesdeOrigen(0);

        PriorityQueue<Ciudad> ciudadesPorVisitar = new PriorityQueue<>(Comparator.comparing(Ciudad::getDistanciaDesdeOrigen));
        ciudadesPorVisitar.add(ciudadOrigen);

        while (!ciudadesPorVisitar.isEmpty()) {
            Ciudad ciudadActual = ciudadesPorVisitar.poll();

            for (Map.Entry<Ciudad, Double> conexion : ciudadActual.getConexiones().entrySet()) {
                Ciudad ciudadVecina = conexion.getKey();
                double distanciaTotal = ciudadActual.getDistanciaDesdeOrigen() + conexion.getValue();

                if (distanciaTotal < ciudadVecina.getDistanciaDesdeOrigen()) {
                    ciudadVecina.setDistanciaDesdeOrigen(distanciaTotal);
                    ciudadVecina.setPredecesor(ciudadActual);
                    ciudadesPorVisitar.add(ciudadVecina);
                }
            }
        }

        if (ciudadDestino.getPredecesor() == null) {
            return Collections.singletonList("No se encontró una ruta entre las ciudades ingresadas.");
        }
        return obtenerRuta(ciudadDestino);
    }

    private List<String> obtenerRuta(Ciudad ciudadDestino) {
        List<String> ruta = new ArrayList<>();
        Ciudad ciudadActualD = ciudadDestino;

        while (ciudadActualD != null) {
            ruta.add(ciudadActualD.getNombre());
            ciudadActualD = ciudadActualD.getPredecesor();
        }
        Collections.reverse(ruta);
        return ruta;
    }

    public List<String> obtenerNombresCiudades() {
        return new ArrayList<>(ciudades.keySet());
    }

    public Ciudad obtenerCiudad(String nombreCiudad) {
        return ciudades.get(nombreCiudad);
    }

    public double calcularDistanciaTotal(String trayecto) {
        String[] ciudades = trayecto.split(" -> ");
        double distanciaTotal = 0;

        for (int i = 0; i < ciudades.length - 1; i++) {
            Ciudad ciudadActual = obtenerCiudad(ciudades[i]);
            Ciudad ciudadSiguiente = obtenerCiudad(ciudades[i + 1]);

            // Validar si la ciudad actual o siguiente es nula
            if (ciudadActual == null || ciudadSiguiente == null) {
                JOptionPane.showMessageDialog(null, "Error al calcular la distancia. Verifica las ciudades en el trayecto.", "Error", JOptionPane.ERROR_MESSAGE);
                return -1; // O cualquier valor que indique un error
            }
            distanciaTotal += ciudadActual.getDistanciaHacia(ciudadSiguiente);
        }
        return distanciaTotal;
    }

    public double calcularTiempoEstimado(String trayecto, double velocidadPromedio) {
        double distanciaTotal = calcularDistanciaTotal(trayecto);
        return distanciaTotal / velocidadPromedio;
    }
}