package view;

import model.Recursividad;

public class Main {
    public static void main(String[] args) {
        Recursividad re = new Recursividad();
        /*System.out.println(re.imprimirHastaUnN(5));
        System.out.println(re.facR(9));
         */
        System.out.printf("""
                Tabla de multiplicar:
                %s
                Tabla de Suma:
                %s
                """,re.tableMul(5), re.tableSuma(8));
    }
}



