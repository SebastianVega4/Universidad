package co.edu.uptc.logic;

public class Profesor {
    private String nombre;
    private String escuela;

    public Profesor(String nombre, String escuela) {
        this.nombre = nombre;
        this.escuela = escuela;
    }
    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + escuela + '\'' +
                '}';
    }
}