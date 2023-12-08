package Logic;
/*
 * Package Logic
 *
 */


/*
 * Class TreeNode
 *
 * clase Diccionario
 *
 */
public class Diccionario {

    /*
     * private palabra
     *
     * dato de tipo string
     *
     */
    private String palabra;
    /*
     * private significado
     *
     * dato de tipo string
     *
     */
    private String significado;
    /*
     * private traduccion
     *
     * dato de tipo string
     *
     */
    private String traduccion;

    /**
     * Public Diccionario
     * Constructor de la clase Diccionario
     * @param (palabra,significado,traduccion)
     */

    public Diccionario(String palabra, String significado, String traduccion) {
        this.palabra = palabra;
        this.significado = significado;
        this.traduccion = traduccion;
    }
    /**
     * Public getPalabra
     * get de palabra
     * @return (String)
     * @param ()
     */
    public String getPalabra() {
        return palabra;
    }
    /**
     * Public setPalabra
     * set de palabra
     * @return ()
     * @param (palabra)
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    /**
     * Public getSignificado
     * get de significado
     * @return (String)
     * @param ()
     */
    public String getSignificado() {
        return significado;
    }
    /**
     * Public setSignificado
     * set de significado
     * @return ()
     * @param (significado)
     */
    public void setSignificado(String significado) {
        this.significado = significado;
    }
    /**
     * Public getTraduccion
     * get de traduccion
     * @return (String)
     * @param ()
     */
    public String getTraduccion() {
        return traduccion;
    }
    /**
     * Public setTraduccion
     * set de traduccion
     * @return ()
     * @param (traduccion)
     */
    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }


}
