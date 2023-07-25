package model;
    public class Recursividad {
        public void imprimir(int x) {
            if (x > 0) {
                System.out.println(x);
                imprimir(x - 1);
            }
        }
    }
