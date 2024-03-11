package co.edu.uptc.proyectoweb;

import java.util.ArrayList;
import java.util.List;

public class Afiliado {
    private int id;
    private String nombre;
    private String apellido;
    private Disciplina disciplina;
    private List<Evento> eventos;

    public Afiliado() {
        eventos = new ArrayList<>();
    }

    public Afiliado(int id, String nombre, String apellido, Disciplina disciplina, List<Evento> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.disciplina = disciplina;
        this.eventos = eventos;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    @Override
    public String toString() {
        return "Afiliado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", disciplina=" + disciplina +
                ", eventos=" + eventos +
                '}';
    }
}