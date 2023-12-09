package Model;

import Logic.BinaryTree;
import Logic.Dictionary;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Controller {
    HashMap<Integer,BinaryTree<Dictionary>> hash = new HashMap<>();
    public String addWord(String str, String meaning, String translation) {
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (!repeatWord(dictionary, word)) {
            dictionary.addNode(new Dictionary(word, meaning, translation));
            return "la palabra fue agregada correctamente";
        }else {
            return "la palabra esta repetida";
        }
    }

    public String consult(String str) {
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary.findNodo(new Dictionary(word, null, null)) != null) {
            return printInfoWord(word, dictionary);
            }
        return "no existe la palabra : " + word;
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

    public String showForLatter(String str){
        String msj = "";
        String word = firstLetterWithMayus(str);
        BinaryTree<Dictionary> dictionary = searchWord(firstLetterInAscii(word));
        if (dictionary!=null){
            for (int i = 0; i <dictionary.listPresort().size() ; i++) {
                msj = msj + "\n palabra: " + dictionary.listPresort().get(i).getWord() + "\n" +
                        "significado: " + dictionary.listPresort().get(i).getMeaning() + "\n" +
                        "traduccion: " + dictionary.listPresort().get(i).getTranslation() + "\n";
            }
            return msj;
        }
        return "no existe Ninguna palabra con esa letra : "+word;
    }
    public String showAllWords(){
        TreeMap<Integer, BinaryTree<Dictionary>> map1 = new TreeMap<>(hash);
        String msj = "";
        for ( Integer key : map1.keySet() ) {
            BinaryTree<Dictionary> dictionary = hash.get(key);
            if (dictionary.listPresort() != null) {
                int val = key;
                if (!dictionary.isEmpty()){
                    msj += "\n letra: " + (char)val + " \n";
                }
                for (int j = 0; j < dictionary.listPresort().size(); j++) {
                    msj += "\n palabra: " + dictionary.listPresort().get(j).getWord() + "\n" +
                            "significado: " + dictionary.listPresort().get(j).getMeaning() + "\n" +
                            "traduccion: " + dictionary.listPresort().get(j).getTranslation() + "\n";
                }
            }
        }
        if (!msj.isEmpty()) {
            return msj;
        }else {
            return "no existe Ninguna palabra en el diccionario";
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

    private BinaryTree<Dictionary> searchWord(int key){
        BinaryTree<Dictionary> dictionary = hash.get(key);
        if (dictionary == null){
            hash.put(key,new BinaryTree<>(Comparator.comparing(Dictionary::getWord)));
            dictionary = hash.get(key);
        }
        return dictionary;
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
        return word.charAt(0);
    }
}