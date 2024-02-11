package Logic;

// Clase que representa una ciudad en el grafo

import java.util.HashMap;
import java.util.Map;

// Clase que representa una ciudad en el grafo
class Ciudad {
    private final String nombre;
    private final Map<Ciudad, Double> conexiones = new HashMap<>();
    private boolean visitado = false;
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

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Ciudad getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(Ciudad predecesor) {
        this.predecesor = predecesor;
    }

    // Otros métodos y getters/setters...
}