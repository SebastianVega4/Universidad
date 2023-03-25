package co.edu.uptc.model;

public class Father {
    private SkinColor skinColor;
    private String hairColor;
    private String lastName ;

    public Father(SkinColor skinColor, String hairColor, String lastName) {
        this.skinColor = skinColor;
        this.hairColor = hairColor;
        this.lastName = lastName;
    }

    public SkinColor getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(SkinColor skinColor) {
        this.skinColor = skinColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
