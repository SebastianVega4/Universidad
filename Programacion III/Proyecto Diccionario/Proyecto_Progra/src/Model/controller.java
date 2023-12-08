package Model;

import Logic.BinaryTree;
import Logic.Diccionario;
import Logic.TreeNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class controller {
    public controller() {
    }

    HashMap<Integer,BinaryTree<Diccionario>> hash = new HashMap<>();


    public String Agreggar(String str, String significado, String traduccion){

        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);
        if (!palabrarepe(diccionario,palabra)){
            diccionario.addNode(new Diccionario(palabra,significado,traduccion));
            return  "la palabra fue agregada correctamente";
        }else {
            return  "la palabra esta repetida";
        }
    }

    public String consultar(String str){
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);
            if (diccionario.encontrarNodo(new Diccionario(palabra,null,null))!=null){
                return  imprCons(palabra,diccionario);
            }
            return "no existe la palabra : "+palabra;
        }

    public boolean consultarExistencia(String str){
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);
        if (diccionario.encontrarNodo(new Diccionario(palabra,null,null))!=null){
            return true;
        }
        return false;
    }

    public String consultarPalab(String str){
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);

        return  diccionario.encontrarNodo(new Diccionario(palabra,null,null)).getInfo().getPalabra();
    }

    public String consultarSignifica(String str){
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);

        return  diccionario.encontrarNodo(new Diccionario(palabra,null,null)).getInfo().getSignificado();
    }

    public String consultarTraduc(String str){
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);

        return  diccionario.encontrarNodo(new Diccionario(palabra,null,null)).getInfo().getTraduccion();
    }

    public String listadoLetra(String str){
        String msj = "";
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);
        if (diccionario!=null){
            for (int i = 0; i <diccionario.listPresort().size() ; i++) {
                msj  = msj+"\n"+"palabra : " +diccionario.listPresort().get(i).getPalabra() +"\n"+
                        "significado : "+diccionario.listPresort().get(i).getSignificado() +"\n"+
                        "traduccion : "+diccionario.listPresort().get(i).getTraduccion() +"\n";
            }
            return msj;
        }
        return "no existe Ninguna palabra con esa letra : "+palabra;
    }
    public String listadototal(){
        TreeMap<Integer, BinaryTree<Diccionario>> map1 = new TreeMap<>(hash);
        String msj = "";
        for ( Integer key : map1.keySet() ) {
            BinaryTree<Diccionario> diccionario = hash.get(key);
            if (diccionario.listPresort() != null) {
                int val = key;
                char convertedChar = (char)val;
                if (!diccionario.isEmpty()){
                    msj +=  "\nletra : " + convertedChar +" \n";
                }
            for (int j = 0; j < diccionario.listPresort().size(); j++) {
                msj += "\n" + "palabra : " + diccionario.listPresort().get(j).getPalabra() + "\n" +
                        "significado : " + diccionario.listPresort().get(j).getSignificado() + "\n" +
                        "traduccion : " + diccionario.listPresort().get(j).getTraduccion() + "\n";
            }
        }
        }
        if (!msj.equals("")){
            return msj;
        }else {
            return "no existe Ninguna palabra en el diccionario";
        }

    }

    public String Modificar(String str, String significado, String traduccion){

        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);
        if (diccionario.encontrarNodo(new Diccionario(palabra,null,null))!=null){
            diccionario.modifyNode(diccionario.encontrarInfo(new Diccionario(palabra,null,null)), new Diccionario(palabra,significado,traduccion));
            return "la palabra fue cambiada con exito : "+"\n"+ consultar(palabra);
        }
        return "no existe la palabra que desea modificar : "+palabra;
    }

    public String Eliminar(String str){
        String palabra = mayus(str);
        int val = ascci(palabra);
        BinaryTree<Diccionario> diccionario = buscarDiccionario(val);
        if (diccionario.encontrarNodo(new Diccionario(palabra,null,null))!=null){
            diccionario.deleteNode(diccionario.encontrarNodo(new Diccionario(palabra,null,null)));
            return "la plabra se elimino con exito: " +palabra;
        }
        return "no existe la palabra que desea eliminar: "+palabra;
    }





    private String imprCons(String palabra,BinaryTree<Diccionario> diccionario){

            return "palabra : " +diccionario.encontrarNodo(new Diccionario(palabra,null,null)).getInfo().getPalabra() +"\n"+
                    "significado : "+diccionario.encontrarNodo(new Diccionario(palabra,null,null)).getInfo().getSignificado() +"\n"+
                    "traduccion : "+diccionario.encontrarNodo(new Diccionario(palabra,null,null)).getInfo().getTraduccion() +"\n";
    }

    private BinaryTree<Diccionario> buscarDiccionario(int key){
        BinaryTree<Diccionario> diccionario = hash.get(key);

        if (diccionario == null){
            hash.put(key,new BinaryTree<>(Comparator.comparing(Diccionario::getPalabra)));
            diccionario = hash.get(key);
        }
        return diccionario;
    }

    private Boolean palabrarepe(BinaryTree<Diccionario> diccionario,String palabra){
        for (int i = 0; i < diccionario.listInsort().size(); i++) {
            if(diccionario.listInsort().get(i).getPalabra().equals(palabra)){
                return true;
            }
        }
        return false;
    }

    public   String mayus(String str){
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            //La primera letra en mayuscula y las demas en minuscula.
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }

    private int ascci(String palabra){
        char cara = palabra.charAt(0);
        return (int)cara;
    }

}
