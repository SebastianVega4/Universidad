package logic;
public class nFibonacci {
    int nImp = 1, tamano = 0, nAnt = 1, nSig = 0;

    /**
     * @param tamano variable int de Costructor Numeros de fibonacci a imprimir
     */
    public nFibonacci(int tamano) {
        this.tamano = tamano;
    }
    /**
     * @return calcula retorna numeros fibonacci
     */
    public int getnumer() {
        for (int i = 0; i < tamano; i++) {
            nImp = nSig + nAnt;
            nAnt = nSig;
            nSig = nImp;
            System.out.print(nImp + " ");
        }
        return 0;
    }
}