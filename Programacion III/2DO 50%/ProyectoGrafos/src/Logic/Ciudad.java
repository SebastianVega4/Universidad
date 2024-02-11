package Logic;

import java.util.HashMap;
import java.util.Map;

class Ciudad {
    private final String nombre;
    private final Map<Ciudad, Double> conexiones = new HashMap<>();
    private double distanciaDesdeOrigen = Double.POSITIVE_INFINITY;
    private Ciudad predecesor;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public void conectarCon(Ciudad ciudad, double distancia) {
        conexiones.put(ciudad, distancia);
    }

    public String getNombre() {
        return nombre;
    }

    public Map<Ciudad, Double> getConexiones() {
        return conexiones;
    }

    public double getDistanciaDesdeOrigen() {
        return distanciaDesdeOrigen;
    }

    public void setDistanciaDesdeOrigen(double distancia) {
        this.distanciaDesdeOrigen = distancia;
    }

    public Ciudad getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(Ciudad predecesor) {
        this.predecesor = predecesor;
    }
}