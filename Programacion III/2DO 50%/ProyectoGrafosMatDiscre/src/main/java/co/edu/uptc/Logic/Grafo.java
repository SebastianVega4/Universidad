package co.edu.uptc.Logic;

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
    }

    public String encontralTrayectoTotal(List<String> ciudadesAvisitar) {
        List<String> ciudadesPorVisitar = ciudadesAvisitar;
        List<String> trayecto = new ArrayList<>();

        for (int i = 0; i < ciudadesPorVisitar.size() - 1; i++) {
            Ciudad origen = ciudades.get(ciudadesPorVisitar.get(i));
            Ciudad destino = ciudades.get(ciudadesPorVisitar.get(i + 1));
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

        // Establece la distancia desde el origen a 0
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

        if (ciudadDestino == null || ciudadDestino.getDistanciaDesdeOrigen() == Double.POSITIVE_INFINITY) {
            return Collections.singletonList("No se encontró una ruta entre las ciudades ingresadas.");
        }

        return obtenerRuta(ciudadOrigen,ciudadDestino);
    }

    private List<String> obtenerRuta(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        List<String> ruta = new ArrayList<>();

            String origen = ciudadOrigen.getNombre();
            String destino = ciudadDestino.getNombre();

            Ciudad ciudadActualD = ciudades.get(destino);

            if (ciudadActualD == null) {
                return Collections.singletonList("No se encontró una ruta entre las ciudades ingresadas.");
            }

            ruta.add(destino);

            while (!ciudadActualD.getNombre().equals(origen)) {
                ciudadActualD = ciudadActualD.getPredecesor();

                if (ciudadActualD == null) {
                    return Collections.singletonList("No se encontró una ruta entre las ciudades ingresadas.");
                }

                ruta.add(ciudadActualD.getNombre());
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
            distanciaTotal += ciudadActual.getDistanciaHacia(ciudadSiguiente);
        }

        return distanciaTotal;
    }

    public double calcularTiempoEstimado(String trayecto, double velocidadPromedio) {
        double distanciaTotal = calcularDistanciaTotal(trayecto);
        return distanciaTotal / velocidadPromedio;
    }
}