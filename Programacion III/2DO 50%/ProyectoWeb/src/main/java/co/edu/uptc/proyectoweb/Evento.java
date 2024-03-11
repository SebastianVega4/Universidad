package co.edu.uptc.proyectoweb;

public class Evento {
    private int id;
    private String nombre;
    private String resultado;

    public Evento(int id, String nombre, String resultado) {
        this.id = id;
        this.nombre = nombre;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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