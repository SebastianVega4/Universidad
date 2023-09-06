package view;

import model.Recursividad;

public class Main {
    public static void main(String[] args) {
        Recursividad re = new Recursividad();
        System.out.printf("""
                Imprimir hasta el # dado:
                %s
                Numero Factorial 9:
                %s
                Tabla de multiplicar:
                %s
                Tabla de Suma:
                %s
                Suma Matriz:
                %s
                la suma de la matriz es: %s
                """, re.imprimirHastaUnN(5), re.facR(9), re.tableMul(5), re.tableSuma(8), re.getMatriz(), re.sumaMatriz());
    }
}



