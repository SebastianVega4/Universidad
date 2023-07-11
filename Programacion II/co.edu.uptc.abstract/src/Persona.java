public abstract class Persona{
    private String name;
    private String genero;

    public Persona(String name, String genero) {
        this.name = name;
        this.genero = genero;
    }
    public abstract boolean revisarCod(int cod);
    public abstract String  revisarGen(String gen);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}