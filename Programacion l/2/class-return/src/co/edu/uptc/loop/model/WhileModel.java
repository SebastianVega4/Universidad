package co.edu.uptc.loop.model;

public class WhileModel {
    private int i = 0;
    private String aux;

    public WhileModel() {
    }

    private String getCalculate() {
        while (!aux.equals("10")) {
            if (i != 10) {
                aux += i + ",";
            } else {
                aux += i;
                break;
            }
            i++;
        }
        return aux;
    }
}
