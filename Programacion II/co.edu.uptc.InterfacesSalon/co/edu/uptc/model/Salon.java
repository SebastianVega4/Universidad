package co.edu.uptc.model;

public class Salon implements Control{
    private int number;
    private String escuela;

    public Salon(int number, String escuela) {
        this.number = number;
        this.escuela = escuela;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    @Override
    public String encender() {
        return null;
    }

    @Override
    public String apagar() {
        return null;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "number=" + number +
                ", escuela='" + escuela + '\'' +
                '}';
    }
}
