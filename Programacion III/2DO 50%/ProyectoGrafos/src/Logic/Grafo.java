package Logic;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {

    private final Map<String, Ciudad> ciudades = Maps.newHashMap();

    public void agregarCiudad(String origen, String destino, double distancia) {
        Ciudad ciudadOrigen = ciudades.computeIfAbsent(origen, Ciudad::new);
        Ciudad ciudadDestino = ciudades.computeIfAbsent(destino, Ciudad::new);
        ciudadOrigen.conectarCon(ciudadDestino, distancia);
        ciudadDestino.conectarCon(ciudadOrigen, distancia); // Permite ir de un lado a otro
    }

    public String encontrarTrayectoMasCorto(List<String> ciudadesIntermedias) {
        List<String> ciudadesTotales = new ArrayList<>(ciudadesIntermedias);

        // Verifica si las ciudades intermedias son válidas
        for (String ciudad : ciudadesTotales) {
            if (!ciudades.containsKey(ciudad)) {
                return "La ciudad '" + ciudad + "' no existe en el grafo.";
            }
        }

        for (Ciudad ciudad : ciudades.values()) {
            ciudad.setDistanciaDesdeOrigen(Double.POSITIVE_INFINITY);
            ciudad.setPredecesor(null);
        }

        // Establece la distancia desde el origen a 0
        Ciudad ciudadOrigen = ciudades.get(ciudadesTotales.get(0));
        ciudadOrigen.setDistanciaDesdeOrigen(0);

        // Crea la cola de prioridad para ordenar las ciudades por distancia
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

        Ciudad ciudadDestino = ciudades.get(ciudadesTotales.get(ciudadesTotales.size() - 1));
        if (ciudadDestino == null || ciudadDestino.getDistanciaDesdeOrigen() == Double.POSITIVE_INFINITY) {
            return "No se encontró una ruta entre las ciudades ingresadas.";
        }

        return obtenerRuta(ciudadesTotales);
    }

    private String obtenerRuta(List<String> ciudadesTotales) {
        List<String> ruta = new ArrayList<>();

        for (int i = 0; i < ciudadesTotales.size() - 1; i++) {
            String origen = ciudadesTotales.get(i);
            String destino = ciudadesTotales.get(i + 1);

            Ciudad ciudadActualD = ciudades.get(destino);
            ruta.add(destino);

            while (!ciudadActualD.getNombre().equals(origen)) {
                ciudadActualD = ciudadActualD.getPredecesor();
                ruta.add(ciudadActualD.getNombre());
            }
        }

        Collections.reverse(ruta);
        return String.join(" -> ", ruta);
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
            distanciaTotal += ciudadActual.getDistanciaHacia(ciudadSiguiente);
        }

        return distanciaTotal;
    }

    public double calcularTiempoEstimado(String trayecto, double velocidadPromedio) {
        double distanciaTotal = calcularDistanciaTotal(trayecto);
        return distanciaTotal / velocidadPromedio;
    }
}