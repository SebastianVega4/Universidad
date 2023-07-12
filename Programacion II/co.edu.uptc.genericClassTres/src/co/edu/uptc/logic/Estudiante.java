package co.edu.uptc.logic;

public class Estudiante {
    private String nombre;
    private int cod;

    public Estudiante(String nombre, int cod) {
        this.nombre = nombre;
        this.cod = cod;
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + cod +
                '}';
    }
}
