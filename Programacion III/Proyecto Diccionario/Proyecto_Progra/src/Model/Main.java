package Model;

public class Main {
    public static void main(String[] args) {
        controller cs = new controller();
        System.out.println(cs.addWord("ala ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("clA ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("bLA ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("alaaaa ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("alad ", "es una prueba mu chimba esto es el resultado de mi trabajo ", "fadfdsfsd"));
        System.out.println(cs.addWord("alafw ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("bla ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("ala ", "¡", "fadfdsfsd"));
        System.out.println(cs.addWord("bla ", "es una ", "fadfdsfsd"));
        System.out.println(cs.addWord("la ", "¡", "fadfdsfsd"));
        System.out.println("=====================================");
        System.out.println(cs.consult("-ala "));
        String nm = "ala";
        System.out.println(nm.equals("Ala"));
        System.out.println(cs.consult(nm));

        System.out.println(cs.consult("ala "));
        System.out.println(cs.consult("bair "));
        System.out.println(cs.consult("jose"));
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