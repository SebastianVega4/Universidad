package Model;

import Logic.BinaryTree;
import Logic.Dictionary;

import java.util.Comparator;

public class Controller {
    private static BinaryTree<Dictionary>[] array = new BinaryTree[26];

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

    public String consult(String str) {
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word, null, null)) != null) {
            return printInfoWord(word, dictionary);
            }
        return "La palabra _"+word+"_ no ha sido agregada al diccionario";
    }

    public boolean showIfExistWord(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        return dictionary.findNodo(new Dictionary(word, null, null)) != null;
    }

    public String showMeaning(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        return  dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getMeaning();
    }

    public String showTranslation(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        return  dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getTranslation();
    }

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

    public String modifyWord(String str, String meaning, String translation){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word,null,null))!=null){
            dictionary.modifyNode(dictionary.findInfo(new Dictionary(word,null,null)), new Dictionary(word,meaning,translation));
            return "la palabra fue cambiada con exito : " + "\n" + consult(word);
        }
        return "no existe la palabra que desea modificar : "+word;
    }

    public String deleteWord(String str){
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word,null,null))!=null){
            dictionary.deleteNode(dictionary.findNodo(new Dictionary(word,null,null)));
            return "la plabra se elimino con exito: " +word;
        }
        return "no existe la palabra que desea eliminar: "+word;
    }

    private String printInfoWord(String word, BinaryTree<Dictionary> dictionary){
            return "palabra : " +dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getWord() +"\n"+
                    "significado : "+dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getMeaning() +"\n"+
                    "traduccion : "+dictionary.findNodo(new Dictionary(word,null,null)).getInfo().getTranslation() +"\n";
    }

    private BinaryTree<Dictionary> searchWord(int index) {
        if (array[index] == null) {
            array[index] = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        }
        return array[index];
    }

    private Boolean repeatWord(BinaryTree<Dictionary> dictionary, String word){
        for (int i = 0; i < dictionary.listInsort().size(); i++) {
            if(dictionary.listInsort().get(i).getWord().equals(word)){
                return true;
            }
        }
        return false;
    }

    public String firstLetterWithMayus(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }

    private int firstLetterInAscii(String word){
        return word.charAt(0)-65;
    }
}