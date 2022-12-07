package Logic;

public class Municipality {
    private final String nameMunicipy;

    /**
     * @param nameMunicipy Costructor que recibe el nombre del Municipio
     */
    public Municipality(String nameMunicipy) {
        this.nameMunicipy = nameMunicipy;
    }

    /**
     * @return Retorna el nombre del municipio
     */
    public String getNameMunicipy() {
        return nameMunicipy;
    }
}
