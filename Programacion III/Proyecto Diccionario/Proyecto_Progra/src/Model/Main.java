package Model;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        controller cs = new controller();
        System.out.println(cs.Agreggar("ala ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("clA ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("bLA ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("alaaaa ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("alad ","es una prueba mu chimba esto es el resultado de mi trabajo ","fadfdsfsd"));
        System.out.println(cs.Agreggar("alafw ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("bla ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("ala ","¡","fadfdsfsd"));
        System.out.println(cs.Agreggar("bla ","es una ","fadfdsfsd"));
        System.out.println(cs.Agreggar("la ","¡","fadfdsfsd"));
        System.out.println("=====================================");
        System.out.println(cs.consultar("-ala "));
        String nm = "ala";
        System.out.println(nm.equals("Ala"));
        System.out.println(cs.consultar(nm));

        System.out.println(cs.consultar("ala "));
        System.out.println(cs.consultar("bair "));
        System.out.println(cs.consultar("jose"));
        System.out.println("=====================================");
        System.out.println(cs.listadoLetra("a"));
        System.out.println(cs.listadoLetra("b"));
        System.out.println("=====================================");
        System.out.println(cs.listadototal());
        System.out.println("=====================================");
        System.out.println(cs.Modificar("ala ","maravilla","hola esta es una prueba"));
        System.out.println("=====================================");
        System.out.println(cs.Eliminar("alad "));
        System.out.println(cs.Eliminar("yaui "));
        System.out.println("=====================================");
        System.out.println(cs.listadoLetra("a"));

        }
    }



