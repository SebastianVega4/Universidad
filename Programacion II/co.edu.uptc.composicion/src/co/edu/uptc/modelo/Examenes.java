package co.edu.uptc.modelo;

public class Examenes {
    private final String nombreCurso;
    private final String aula;
    private Fecha fecha;
    private Hora hora;

    public Examenes(String nombreCurso, String aula) {
        this.nombreCurso = nombreCurso;
        this.aula = aula;
        this.fecha = new Fecha(21, 6, 2023);
        this.hora = new Hora(10, 30);
    }

    /*public void modificarFecha(int dia, int mes, int year) {
        fecha.setDia(dia);
        fecha.setMes(mes);
        fecha.setYear(year);
    }*/

    public void modificarFecha(int dia, int mes, int year) {
        fecha = new Fecha(dia, mes, year);
    }

    public void modificarFecha(Fecha f) {
        fecha = f;
    }

    public void modificarHora(int hora, int minutos) {
        this.hora = new Hora(hora, minutos);
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public void mostrarExamen() {
        System.out.printf(""" 
                                            
                Nombre del curso: %s
                Aula: %s
                Fecha: %s
                Hora: %s
                """, nombreCurso, aula, fecha.toString(), hora.toString());
    }

}
