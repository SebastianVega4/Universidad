package logica;

public class Examen {
    private String nomCurso, cod;
    private Fecha fecha;
    private Hora hora;

    public Examen(String nomCurso, String cod, Fecha fecha, Hora hora) {
        this.nomCurso = nomCurso;
        this.cod = cod;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(int d, int m, int a) {
        fecha=new Fecha(d,m,a);
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(int h, int m) {
        hora = new Hora(h,m);
    }

    @Override
    public String toString() {
        return "Examen{" +
                "nomCurso='" + nomCurso + '\'' +
                ", cod='" + cod + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                '}';
    }
}
