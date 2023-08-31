package Model;

public class Estudent implements Comparable<Estudent> {
    String nombre;
    double nota;

    public Estudent(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    @Override
    public int compareTo(Estudent otroAlumno) {
        return Double.compare(this.nota, otroAlumno.nota);
    }

    @Override
    public String toString() {
        return nombre + " (" + nota + ")";
    }
}
