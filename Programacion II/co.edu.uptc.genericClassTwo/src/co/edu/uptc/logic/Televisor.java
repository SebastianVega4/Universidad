package co.edu.uptc.logic;

public class Televisor {
    private String name;
    private double precio;

    public Televisor(String name, double precio) {
        this.name = name;
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Televisor{" +
                "name='" + name + '\'' +
                ", precio=" + precio +
                '}';
    }
}
