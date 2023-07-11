package co.edu.uptc.modelo;

public class Fecha {
    private int dia;
    private int mes;
    private int year;

    public Fecha(int dia, int mes, int year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }

    public void modificarFecha(int dia, int mes, int year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + year;
    }
}
