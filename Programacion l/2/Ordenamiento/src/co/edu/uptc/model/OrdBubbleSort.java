package co.edu.uptc.model;

public class OrdBubbleSort {
    public static void bubbleSort(Object[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (((Veiculo) arr[j]).getMarca().compareTo(((Veiculo) arr[j + 1]).getMarca()) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
