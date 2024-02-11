package Model;

import Logic.BinaryTree;
import Logic.Dictionary;

import java.util.Comparator;

/**
 * Clase que representa el control sobre las demas clases y de esta manera
 * se estableceran las respectuvas funciones establecidas aqui
 */
public class Controller {
    /**
     * Representa un objeto de la clase binary Tree parametrizado con la clase diccionary
     * la cual se utiliza para almacenar la Informacion en el árbol binario
     */
    private static BinaryTree<Dictionary>[] array = new BinaryTree[26];

    /**
     * Método addWord que es el encargado de añadir a la lista de palabras con su
     * respectivo significado y traduccion, este metodo posee tres parametros
     * @param str Parametro que representa la palabra que se agrega al diccionario
     * @param meaning Parametro que representa el significado de la palabra añadida
     * @param translation Parametro que representa la traduccion de la palabra añadida
     * @return El método retornará un mensaje tipo String, en caso de que la palabra se
     * haya añadido correctamente o por si esta repetida
     */
    public String addWord(String str, String meaning, String translation) {
        String word = firstLetterWithMayus(str);
        int index = firstLetterInAscii(word); // Assuming uppercase letters only
        BinaryTree<Dictionary> dictionary = searchWord(index);
        if (!repeatWord(dictionary, word)) {
            dictionary.addNode(new Dictionary(word, meaning, translation));
            return "La palabra fue agregada correctamente";
        } else {
            return "La palabra está repetida";
        }
    }

    /**
     * Método consult que tiene como parametro un string, este método es el encargado de
     * buscar en el árbol binario la palabra que se desee, en caso de que la encuentre mostrará
     * su sginificado correspondiente ais como su traduccion
     * @param str Representa el parametro de tipo String para buscarla dentro del arbol binario
     * @return El método retornará la palabra que se palabra que se pidio en la busqueda
     * si la encuentra de lo contrario mostrará un mensaje que informe que la palabra no ha sido
     * agregada
     */

    public String consult(String str) {
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word, null, null)) != null) {
            return printInfoWord(word, dictionary);
        }
        return "La palabra _"+word+"_ no ha sido agregada al diccionario";
    }

    /**
     * Método que mostrará la palabra si ha sido encontrada en la búsqueda, para esto tiene
     * como parametro de tipo String, para realizar la búsqueda utiliza el metodo de searchWord
     * @param str Representa la palabra que ha de ser mostrada en el caso de que haya sido
     *            encontrada en la búsqueda
     * @return El método devolverá un nodo que contenga la palabra que se ha pedido en la búsqueda
     */
    public boolean showIfExistWord(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        return dictionary.findNodo(new Dictionary(word, null, null)) != null;
    }

    /**
     * Método que mostrará el significado de una palabra que se desee, para esto tiene como parametro
     * tipo String el cual será el significado de la palabra de la cual se ha realizado la busqueda
     * @param str Representa el significado de la palbra
     * @return Retorna un nodo con la palabra encontrada
     */

    public String showMeaning(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        return  dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getMeaning();
    }

    /**
     * Método que mostrará la traduccion de la palabra al idioma inglés, método que recibe un parametro
     * de tipo String que contendrá la palabra a la que justo a esta se mostrará su traducción
     * @param str Representa el parametro que recibe el método para la palabra
     * @return Retorna un nodo el cual contiene la palabra y la traduccion de esta
     */

    public String showTranslation(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        return  dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getTranslation();
    }

    /**
     * Método que mostrará en el cuadro de texto de la GUI la palabras que hayan sido añadidas al diccionario,
     * segun por las letras
     * @param str Representa cada palbara que va a ser  buscada en el árbol binario para mostrar segun la letra
     *            que se elegido buscar
     *
     * @return El método retornará un mesaje con la palabra y su respectivo significado y traducción de lo contrario
     * retornará un mensaje informando la inexistencia de palbras dentro del diccionario con esa letra
     */
    public String showForLetter(String str){
        String msj = "";
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary != null && !dictionary.isEmpty()) {
            for (int i = 0; i < dictionary.listPresort().size(); i++) {
                msj = msj + "\n palabra: " + dictionary.listPresort().get(i).getWord() + "\n" +
                        "significado: " + dictionary.listPresort().get(i).getMeaning() + "\n" +
                        "traduccion: " + dictionary.listPresort().get(i).getTranslation() + "\n";
            }
            return msj;
        }
        return "No existe ninguna palabra con esa letra: " + word;
    }

    /**
     * Método que mostrará todas las palabras que existen en el diccionario con árbol binario
     * junto con cada palabra existente mostrará el significado y la traducción de la misma
     * @return El método retornará un mensaje con cada palabra, en caso de que no exista ninguna
     * palabra dentro del diccionario mostrará un mesaje informando la inexitencia de palbras en
     * el diccionario
     */
    public String showAllWords() {
        String message = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && !array[i].isEmpty()) {
                char letter = (char) (i + 65);
                message = message + "\nLetra: " + letter + "\n";
                for (int j = 0; j < array[i].listPresort().size(); j++) {
                    message = message + "\n Palabra: " + array[i].listPresort().get(j).getWord() + "\n"
                            + "Significado: " + array[i].listPresort().get(j).getMeaning() + "\n"
                            + "Traducción: " + array[i].listPresort().get(j).getTranslation() + "\n";
                }
            }
        }
        if (!message.isEmpty()) {
            return message;
        } else {
            return "No existe ninguna palabra en el diccionario";
        }
    }

    /**
     * Método que permite la modificación de alguna palabra dentro existente dentro del diccionario
     * para esto primero debe eoncintrar el nodo donde esta contenida la palabra, para asi hacer la modificación
     * El método recibe 3 parametros, losc cuales son la palabra, el significado y la traduccion de la misma
     * @param str Representa un parametro de tipo String por el cual va a ser cambiado la palabra
     * @param meaning  Representa un parametro de tipo String por el cual va a ser cambiado el significado de la palabra
     * @param translation  Representa un parametro de tipo String por el cual va a ser cambiada la traduccion de la palabra
     * @return el método tendrá algún retorno según sea el caso , si la palabra fue encintrada y cambiada con exito o si no
     * existe la palabra que se quiere modificar
     */

    public String modifyWord(String str, String meaning, String translation){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word,null,null))!=null){
            dictionary.modifyNode(dictionary.findInfo(new Dictionary(word,null,null)), new Dictionary(word,meaning,translation));
            return "la palabra fue cambiada con exito : " + "\n" + consult(word);
        }
        return "no existe la palabra que desea modificar : "+word;
    }

    /**
     * Método que eliminará una palabra que exista en el árbol, este método utiliza el método searcWord
     * para buscar la palabra en el árbol y eliminarla
     * @param str Este método recibe un parametro de tipo String que representa la palabra a ser eliminada
     *            en el árbol
     * @return el método retornará algún mensaje según sea el caso, si se eliminó la plabra o por si
     * no existe la palabra que se quiere eliminar
     */
    public String deleteWord(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word,null,null))!=null){
            dictionary.deleteNode(dictionary.findNodo(new Dictionary(word,null,null)));
            return "la palabra se elimino con exito: " +word;
        }
        return "no existe la palabra que desea eliminar: "+word;
    }

    /**
     * Método que mostrará la Informacion de un nodo, el cual contendra la palabra, el significado y l atraduccion de la
     * misma. Este método utiliza el método findNodo que se encuentra en la clase controller, el cual es el encargado
     * de buscar el nodo para mostrarlo, para esto tambien utiliza 2 métodos uno de la clase String y otro de de la clase BinaryTree
     * parametrizado con la clase dictionary
     * @param word Representa la palabra que se buscará en el árbol para mostrarla en la pantalla de interacción del usuario
     * @param dictionary Representa la clase de BinaryTree parametrizada con la clase dictionary para llamar al método
     *                   findNodo y buscar asi la ´palabra
     * @return El método retorna la palbra, el significado y la traduccion de la misma en caso de que exista en el árbol
     */
    private String printInfoWord(String word, BinaryTree<Dictionary> dictionary){
        return "palabra : " +dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getWord() +"\n"+
                "significado : "+dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getMeaning() +"\n"+
                "traduccion : "+dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getTranslation() +"\n";
    }

    /**
     * Método que se encarga de buscar una palbra dentro del árbol binario. Este método recibe un parametro de tipo int.
     * Este métodoo tambien es el encargado de buscar la palabra que se requiere para demas funciones del
     * diccionario
     * @param index Parametro de tipo int el cual representa el indice del array en que se encuentre la palabra en búsqueda
     * @return Retorna ell indice en que se encuentre la palabra dentro el array
     */

    private BinaryTree<Dictionary> searchWord(int index) {
        if (array[index] == null) {
            array[index] = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        }
        return array[index];
    }

    /**
     * Método de tipo boolean que verifica la existencia de palabras repetidas dentro del árbol binario. este método recibe
     * 2 parametros uno de tipo BinaryTree y otro de tipo String, los cuales son necesarios para la dicha función
     * @param dictionary este parametro representa un objeto de la clase BinaryTree necesario para la llamada de los métods
     *                   de la clase BinaryTree
     * @param word  este parametro representa la palabra que se compara con las demas para hacer la resoectiva verificación
     * @return Este método retorna true para el caso en que hayan palabras repetidas o false si no hay palabras repetidas en el
     * árbol binario
     */

    private Boolean repeatWord(BinaryTree<Dictionary> dictionary, String word){
        for (int i = 0; i < dictionary.listInsort().size(); i++) {
            if(dictionary.listInsort().get(i).getWord().equals(word)){
                return true;
            }
        }
        return false;
    }

    /**
     * Este método verifica si la primera letra de la palabra esta en mayuscula. Este metodo recibe un parametro de tipo String
     * @param str este parametro representa la palabra que se analizará, para la verificacion de si tiene la primera letra en mayuscula
     * @return el método retornará el palabra ya analizada
     */

    public String firstLetterWithMayus(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }

    /**
     * Este método recibe como parametro un String el cual se convertirá en codigo ascii
     * @param word parametro que representa la palabra a la cual se convertirá en codigo ascii
     * @return retorna la palabra pero caracteres del codigo ascii
     */

    private int firstLetterInAscii(String word){
        return word.charAt(0)-65;
    }
}