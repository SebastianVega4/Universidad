package model;
    public class Recursividad {
        public int imprimirHastaUnN(int x) {
            if (x > 0) {
                imprimirHastaUnN(x - 1);
            }
            return x;
        }
        public int facR (int n){
            int resultado;
            if(n==1)return 1;
            resultado=facR(n-1)*n;
            return resultado;
        }
    }
