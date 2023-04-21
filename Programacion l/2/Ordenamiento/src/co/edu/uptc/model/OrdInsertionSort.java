package co.edu.uptc.model;

public class OrdInsertionSort {
    public static void insertionSort(Object[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Object key = arr[i];
            int j = i - 1;
            while (j >= 0 && ((Veiculo) arr[j]).getMarca().compareTo(((Veiculo) key).getMarca()) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
