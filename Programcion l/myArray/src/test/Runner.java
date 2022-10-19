package test;

import logic.MyArray;
import java.lang.reflect.Array;

public class Runner {
    public static void main(String[] args) {
        MyArray myArray =new MyArray(5);
        myArray.add("234");
        myArray.add("424");
        myArray.add("uptc");
        myArray.add("765");
        myArray.add("Sogamoso");
        myArray.add("siii");
        myArray.add("Hola");
        myArray.add("Tambien");

        String[] copia = myArray.getArray();

        System.out.println(Array.toSring(copia));
        copia[4]="cuitiva";
        copia[9]="72985";

        System.out.println(Array.toString());

        System.out.println(myArray.toString());
    }
}
