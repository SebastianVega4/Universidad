package co.edu.uptc.logic;

public class NumFibonacci {
    int nImp = 1, tamano = 0, nAnt = 1, nSig = 0;
    String cadenaFibonacci= "0 ";
    /**
     * @param tamano variable int de Costructor Numeros de fibonacci a imprimir
     */
    public NumFibonacci(int tamano) {
        this.tamano = tamano;
    }
    /**
     * @return calcula retorna numeros fibonacci
     */
    public int setNumer() {
        System.out.print(0+" ");
        for (int i = 0; i < tamano; i++) {
            nImp = nSig + nAnt;
            nAnt = nSig;
            nSig = nImp;
            cadenaFibonacci = cadenaFibonacci + nImp + " ";
            System.out.print(nImp + " ");
        }
        return 0;
    }
    /**
     * @return retorna el numero fibonacci pero de la variabe String
     */
    public String getCadena() {
        return cadenaFibonacci;
    }
}