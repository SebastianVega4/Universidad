package Logic;

import com.google.common.collect.Maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Clase que representa el grafo y contiene el algoritmo de Dijkstra
public class Grafo {
    private final Map<String, Ciudad> ciudades = new HashMap<>();

    public void agregarCiudad(String origen, String destino, double distancia) {
        Ciudad ciudadOrigen = ciudades.computeIfAbsent(origen, Ciudad::new);
        Ciudad ciudadDestino = ciudades.computeIfAbsent(destino, Ciudad::new);
        ciudadOrigen.conectarCon(ciudadDestino, distancia);
    }

    public String encontrarTrayectoCorto(String origen, String destino) {
        // Crear un mapa de distancias desde el origen a cada ciudad
        Map<Ciudad, Double> distancias = Maps.newHashMap();
        for (Ciudad ciudad : ciudades.values()) {
            distancias.put(ciudad, Double.POSITIVE_INFINITY);
        }
        distancias.put(ciudades.get(origen), 0.0);

        // Crear una cola de prioridad para ordenar las ciudades por distancia
        PriorityQueue<Ciudad> ciudadesPorVisitar = new PriorityQueue<>(
                Comparator.comparing(distancias::get)
        );

        ciudadesPorVisitar.add(ciudades.get(origen));

        // Mientras haya ciudades sin visitar
        while (!ciudadesPorVisitar.isEmpty()) {
            // Obtener la ciudad con la distancia mínima
            Ciudad ciudadActual = ciudadesPorVisitar.poll();

            // Si la ciudad actual es el destino, se ha encontrado el camino más corto
            if (ciudadActual.getNombre().equals(destino)) {
                return obtenerRuta(origen, destino, distancias);
            }

            // Marcar la ciudad como visitada
            ciudadActual.setVisitado(true);

            // Para cada ciudad conectada a la actual
            for (Map.Entry<Ciudad, Double> conexion : ciudadActual.getConexiones().entrySet()) {
                Ciudad ciudadVecina = conexion.getKey();
                double distanciaTotal = distancias.get(ciudadActual) + conexion.getValue();

                // Si la distancia total a la ciudad vecina es menor que la actual, actualizar la distancia
                if (!ciudadVecina.isVisitado() && distanciaTotal < distancias.get(ciudadVecina)) {
                    distancias.put(ciudadVecina, distanciaTotal);
                    ciudadVecina.setPredecesor(ciudadActual);
                    ciudadesPorVisitar.add(ciudadVecina);
                }
            }
        }

        // No se encontró un camino entre el origen y el destino
        return "No se encontró un camino";
    }

    private String obtenerRuta(String origen, String destino, Map<Ciudad, Double> distancias) {
        StringBuilder ruta = new StringBuilder();
        Ciudad ciudadActual = ciudades.get(destino);

        // Recorrer la ruta desde el destino hasta el origen
        while (!ciudadActual.getNombre().equals(origen)) {
            ruta.insert(0, ciudadActual.getNombre() + " -> ");
            ciudadActual = ciudadActual.getPredecesor();
        }

        ruta.append(origen);
        return ruta.toString();
    }

// Otras métodos y clases internas para la gestión del grafo...
}