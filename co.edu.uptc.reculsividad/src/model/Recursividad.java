package model;
    public class Recursividad {
        private int cont,contSum,conIMatriz,conJmatriz;
        private String resul,resulSum,resulMatriz ;
        private int[][] matris={{1,2,3},{4,5,6},{7,8,9}};

        public Recursividad() {
            this.resul="";
            this.resulSum="";
        }

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
        public String tableMul(int n){
            if(cont != 10){
                cont++;
                resul+=cont+"*"+n+"="+(cont*n)+"\n";
                tableMul(n);
            }
             return resul;
        }
        public String tableSuma(int n){
            if(contSum < n){
                contSum++;
                resulSum+=contSum+"+"+(n-contSum)+"="+((contSum-n)+n)+"\n";
                tableSuma(n);
            }
            return resulSum;
        }
        public String sumaMatriz(){
            if (conIMatriz==0){
                if(conJmatriz==0){
                    
                }
            }
        return resulMatriz;
        }
    }
