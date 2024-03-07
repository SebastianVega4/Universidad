package co.edu.uptc.proyectoweb;

public class Disciplina {
    private String nombre;
    private boolean esIndividual;

    public Disciplina(String nombre, boolean esIndividual) {
        this.nombre = nombre;
        this.esIndividual = esIndividual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsIndividual() {
        return esIndividual;
    }

    public void setEsIndividual(boolean esIndividual) {
        this.esIndividual = esIndividual;
    }
}