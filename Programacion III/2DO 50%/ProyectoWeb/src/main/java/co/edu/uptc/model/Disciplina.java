package co.edu.uptc.model;

public class Disciplina {

    private int id;
    private String nombre;
    private boolean esIndividual;

    public Disciplina(int id, String nombre, boolean esIndividual) {
        this.id = id;
        this.nombre = nombre;
        this.esIndividual = esIndividual;
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

    public boolean getEsIndividual() {
        return esIndividual;
    }

    public void setEsIndividual(boolean esIndividual) {
        this.esIndividual = esIndividual;
    }
}