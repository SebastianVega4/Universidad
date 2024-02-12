package Logic;

import java.util.*;

public class Grafo {
    private final Map<String, Ciudad> ciudades = new HashMap<>();

    public void agregarCiudad(String origen, String destino, double distancia) {
        Ciudad ciudadOrigen = ciudades.computeIfAbsent(origen, Ciudad::new);//verifica si key ya existe Si no existe ->(Ciudad::new)
        Ciudad ciudadDestino = ciudades.computeIfAbsent(destino, Ciudad::new);//crea una nueva instancia de Ciudad si key existe
        ciudadOrigen.conectarCon(ciudadDestino, distancia);
        ciudadDestino.conectarCon(ciudadOrigen, distancia); // Permite ir de un lado a otro
    }

    public String encontrarTrayectoMasCorto(String origen, String destino) {
        Ciudad ciudadOrigen = ciudades.get(origen);
        if (ciudadOrigen == null) {
            return "La ciudad de origen no existe en el grafo.";
        }

        for (Ciudad ciudad : ciudades.values()) {
            ciudad.setDistanciaDesdeOrigen(Double.POSITIVE_INFINITY);
            ciudad.setPredecesor(null);
        }

        ciudadOrigen.setDistanciaDesdeOrigen(0);

        //ordena aotometicente y le da priosidad a la distancia mas corta
        PriorityQueue<Ciudad> ciudadesPorVisitar = new PriorityQueue<>(Comparator.comparing(Ciudad::getDistanciaDesdeOrigen));
        ciudadesPorVisitar.add(ciudadOrigen);

        while (!ciudadesPorVisitar.isEmpty()) {
            Ciudad ciudadActual = ciudadesPorVisitar.poll();//alimina de la cola el elimento de mayor prioridad luego de asignarlo

            //.entrySet() devuleve ambas partes
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
        Ciudad ciudadActualD = ciudades.get(destino);
        List<String> ruta = new ArrayList<>();
        ruta.add(destino);

        while (!ciudadActualD.getNombre().equals(origen)) {
            ciudadActualD = ciudadActualD.getPredecesor();
            ruta.add(ciudadActualD.getNombre());
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