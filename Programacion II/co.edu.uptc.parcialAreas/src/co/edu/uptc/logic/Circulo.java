package co.edu.uptc.logic;

public class Circulo extends Figura implements Rotable, Dibujable {
    private final int radio;

    public Circulo(int x, int y, int radio) {
        super(x, y);
        this.radio = radio;
    }
    @Override
    public void dibujar() {
        System.out.println("Dibujando un Circulo en la posición (" + super.getX() + ", " + super.getY() + ")");
    }
    @Override
    public void rotar() {
        System.out.println("Rotando el Circulo");
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
