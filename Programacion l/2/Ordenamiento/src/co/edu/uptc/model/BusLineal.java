package co.edu.uptc.model;

public class BusLineal {
    public static String busquedaLineal(Object[] arr, String valorBuscado) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            Veiculo vehiculo = (Veiculo) arr[i];
            System.out.println(arr[i]);
            if (vehiculo.getMarca().equals(valorBuscado)) {
                long endTime = System.nanoTime();

                long duration = endTime - startTime;
                double seconds = (double) duration / 100_000_000;
                return vehiculo+"\n Se encontró un vehículo de marca " + valorBuscado + " en la posición " + i+
                        "\n El algoritmo tardó " + seconds + " segundos en ejecutarse.";
            }
        }
        return "";
    }
}
