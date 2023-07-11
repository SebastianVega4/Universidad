package co.edu.uptc.logic;

public class Profesor {
    private String name;
    private String escuela;

    public Profesor(String name, String escuela) {
        this.name = name;
        this.escuela = escuela;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEscuela() {
        return escuela;
    }
    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
}
