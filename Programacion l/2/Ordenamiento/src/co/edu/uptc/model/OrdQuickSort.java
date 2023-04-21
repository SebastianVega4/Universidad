package co.edu.uptc.model;

public class OrdQuickSort {

    public static void quickSort(Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Object[] arr, int low, int high) {
        String pivot = ((Veiculo) arr[high]).getMarca();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (((Veiculo) arr[j]).getMarca().compareTo(pivot) < 0) {
                i++;

                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
