package co.edu.uptc.model;

public class OrdSeleccionSort {
    public static void selectionSort(Object[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (((Veiculo) arr[j]).getMarca().compareTo(((Veiculo) arr[min_idx]).getMarca()) < 0) {
                    min_idx = j;
                }
            }
            Object temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
