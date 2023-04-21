package co.edu.uptc.model;
import java.util.Arrays;

public class OrdMergeSort {
    public static void mergeSort(Object[] arr) {
        if (arr.length > 1) {
            int medio = arr.length / 2;
            Object[] arrIzq = Arrays.copyOfRange(arr, 0, medio);
            Object[] arrDer = Arrays.copyOfRange(arr, medio, arr.length);

            mergeSort(arrIzq);
            mergeSort(arrDer);

            int i = 0, j = 0, k = 0;

            while (i < arrIzq.length && j < arrDer.length) {
                if (arrIzq[i] instanceof Veiculo && arrDer[j] instanceof Veiculo) {
                    Veiculo vehiculoIzq = (Veiculo) arrIzq[i];
                    Veiculo vehiculoDer = (Veiculo) arrDer[j];
                    int comparacion = vehiculoIzq.getMarca().compareTo(vehiculoDer.getMarca());

                    if (comparacion <= 0) {
                        arr[k++] = arrIzq[i++];
                    } else {
                        arr[k++] = arrDer[j++];
                    }
                } else {
                    System.out.println("Error: el array contiene un objeto que no es un vehículo");
                    return;
                }
            }

            while (i < arrIzq.length) {
                arr[k++] = arrIzq[i++];
            }

            while (j < arrDer.length) {
                arr[k++] = arrDer[j++];
            }
        }
    }
}