package co.edu.uptc.model;

public class OrdShellSort {
    public static void shellSort(Object[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                Object temp = arr[i];
                int j = i;
                while (j >= gap && ((Veiculo) arr[j - gap]).getMarca().compareTo(((Veiculo) temp).getMarca()) > 0) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }
}