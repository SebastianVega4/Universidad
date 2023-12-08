package Logic;

public class Diccionario {
    private String palabra;
    private String significado;
    private String traduccion;
    public Diccionario(String palabra, String significado, String traduccion) {
        this.palabra = palabra;
        this.significado = significado;
        this.traduccion = traduccion;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }
}