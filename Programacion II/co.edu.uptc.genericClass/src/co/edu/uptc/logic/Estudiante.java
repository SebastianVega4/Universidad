package co.edu.uptc.logic;

public class Estudiante {
    private String name;
    private int cod;

    public Estudiante(String name,int cod) {
        this.name = name;
        this.cod = cod;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
}