package co.edu.uptc.loop.model;

public class DoWhileModel {
    private int i = 0;
    private String aux;

    public DoWhileModel() {
    }

    private String setcalculate() {
        do {
            if (i != 10) {
                aux += i + ",";
            } else {
                aux += i;
            }
            i++;
        } while (i != 11);
        return aux;
    }
}