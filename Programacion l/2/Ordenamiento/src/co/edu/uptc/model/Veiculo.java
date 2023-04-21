package co.edu.uptc.model;

public class Veiculo {
    private String marca, place, color;
    private int year;

    public Veiculo(String marca, String place, String color, int year) {
        this.marca = marca;
        this.place = place;
        this.color = color;
        this.year = year;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "Marca='" + marca + '\'' +
                ", place='" + place + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}' + '\'';
    }
}