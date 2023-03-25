package co.edu.uptc.model;

public class Daughter extends Father {
    private String name;
    private Float heigth;

    public Daughter(SkinColor skinColor, String hairColor, String lastName, String name, Float heigth) {
        super(skinColor, hairColor, lastName);
        this.name = name;
        this.heigth = heigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeigth() {
        return heigth;
    }

    public void setHeigth(Float heigth) {
        this.heigth = heigth;
    }
}
