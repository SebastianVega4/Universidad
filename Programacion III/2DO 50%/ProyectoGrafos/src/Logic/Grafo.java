package Logic;

import java.util.*;

public class Grafo {
    private final Map<String, Ciudad> ciudades = new HashMap<>();

    public void agregarCiudad(String origen, String destino, double distancia) {
        Ciudad ciudadOrigen = ciudades.computeIfAbsent(origen, Ciudad::new);
        Ciudad ciudadDestino = ciudades.computeIfAbsent(destino, Ciudad::new);
        ciudadOrigen.conectarCon(ciudadDestino, distancia);
        ciudadDestino.conectarCon(ciudadOrigen, distancia); // Permite ir de un lado a otro
    }

    public String encontrarTrayectoCorto(String origen, String destino) {
        Ciudad ciudadOrigen = ciudades.get(origen);
        if (ciudadOrigen == null) {
            return "La ciudad de origen no existe en el grafo.";
        }

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

        Ciudad ciudadDestino = ciudades.get(destino);
        if (ciudadDestino == null || ciudadDestino.getDistanciaDesdeOrigen() == Double.POSITIVE_INFINITY) {
            return "No se encontró una ruta entre las ciudades ingresadas.";
        }

        return obtenerRuta(origen, destino);
    }

    private String obtenerRuta(String origen, String destino) {
        Ciudad ciudadActual = ciudades.get(destino);
        List<String> ruta = new ArrayList<>();
        ruta.add(destino);

        while (!ciudadActual.getNombre().equals(origen)) {
            ciudadActual = ciudadActual.getPredecesor();
            ruta.add(ciudadActual.getNombre());
        }

        Collections.reverse(ruta);
        return String.join(" -> ", ruta);
    }

    public List<String> obtenerNombresCiudades() {
        return new ArrayList<>(ciudades.keySet());
    }
}