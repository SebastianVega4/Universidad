package co.edu.uptc.model;

public class Pasillo {
    private String bloque;
    private String numberPas;

    public Pasillo(String bloque, String numberPas) {
        this.bloque = bloque;
        this.numberPas = numberPas;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getNumberPas() {
        return numberPas;
    }

    public void setNumberPas(String numberPas) {
        this.numberPas = numberPas;
    }

    @Override
    public String toString() {
        return "Pasillo{" +
                "bloque='" + bloque + '\'' +
                ", numberPas='" + numberPas + '\'' +
                '}';
    }
}
