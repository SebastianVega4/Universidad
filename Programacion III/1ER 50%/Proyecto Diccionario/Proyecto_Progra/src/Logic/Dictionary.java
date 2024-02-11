package Logic;

/**
 * Clase Dictionary que representa el objeto diccionario el cual puede obtener
 * nuevas y varias palabras y permite añadir, modificar, consultar su significado
 * asi como visualizar su traducción
 *
 * @author Sebastian Vega y Luisa Merchan
 */
public class Dictionary {
    /**
     * Representa un atributo de clase String
     * Representa una nueva palabra en el diccionario
     */
    private String word;
    /**
     * Representa un atributo de clase String
     * Representa una nueva significado de la palabra en el diccionario
     */
    private String meaning;
    /**
     * Representa un atributo de clase String
     * Representa la tradcuccion de la palabra en el diccionario
     */
    private String translation;

    /**
     * Constructor de la clase Dictionary, el cual tambien permitira añadir uan nueva palabra
     * al diccionario, en la que tambien se establece su significado y traduccion
     * @param word Representa la Palabra del diccionario
     * @param meaning Representa la significado de la palabra del diccionario
     * @param translation Representa la traduccion de la palabra del diccionario
     */
    public Dictionary(String word, String meaning, String translation) {
        this.word = word;
        this.meaning = meaning;
        this.translation = translation;
    }

    /**
     * Obtiene la palabra del Diccionario
     * @return word Representa la palabra del diccionario
     */

    public String getWord() {
        return word;
    }
    /**
     * Establece  la palbara en el diccionario
     * @param word Representa  la palabra en el diccionario
     */

    public void setWord(String word) {
        this.word = word;
    }
    /**
     * Obtiene el significado de la palabra del Diccionario
     * @return meaning Representa el significado de la palabra del diccionario
     */

    public String getMeaning() {
        return meaning;
    }

    /**
     * Establece el significado de la palbara en el diccionario
     * @param meaning Representa el significado de la palabra en el diccionario
     */

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    /**
     * Obtiene la palabra del Diccionario
     * @return translation Representa la palabra del diccionario
     */

    public String getTranslation() {
        return translation;
    }
    /**
     * Establece la traduccion de la palbara en el diccionario
     * @param translation Representa la traduccion de la palabra en el diccionario
     */

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}