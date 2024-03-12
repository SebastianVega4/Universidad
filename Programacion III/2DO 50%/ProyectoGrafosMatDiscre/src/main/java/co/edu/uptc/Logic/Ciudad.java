package co.edu.uptc.Logic;

import com.google.common.collect.Maps;
import java.util.Map;

public class Ciudad {

    private final String nombre;
    private final Map<Ciudad, Double> conexiones = Maps.newHashMap();
    private double distanciaDesdeOrigen = Double.POSITIVE_INFINITY;
    private Ciudad predecesor;

    public Ciudad(String nomCiu) {
        nombre = nomCiu;
    }

    public void conectarCon(Ciudad ciudad, double distancia) {
        conexiones.put(ciudad, distancia);
        ciudad.conexiones.put(this, distancia); // Asegúrate de que la conexión sea bidireccional
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

    public double getDistanciaHacia(Ciudad otraCiudad) {
        return conexiones.get(otraCiudad);
    }
}
