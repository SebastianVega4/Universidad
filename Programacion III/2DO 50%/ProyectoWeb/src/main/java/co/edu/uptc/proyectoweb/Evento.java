package co.edu.uptc.proyectoweb;

public class Evento {
    private String nombre;
    private String resultado;

    public Evento(String nombre, String resultado) {
        this.nombre = nombre;
        this.resultado = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}