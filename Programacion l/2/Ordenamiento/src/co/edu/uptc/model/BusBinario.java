package co.edu.uptc.model;

public class BusBinario {
    public static String busquedaBinaria(Object[] arr, String valorBuscado) {
        long startTime = System.nanoTime();
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arr[medio] instanceof Veiculo) {
                Veiculo vehiculo = (Veiculo) arr[medio];
                int comparacion = vehiculo.getMarca().compareTo(valorBuscado);

                if (comparacion == 0) {

                    long endTime = System.nanoTime();

                    long duration = endTime - startTime;

                    double seconds = (double) duration / 100_000;
                    return vehiculo+"\n Se encontró un vehículo de marca " + valorBuscado + " en la posición " + medio+
                            "\n El algoritmo tardó " + seconds + " segundos en ejecutarse.";
                } else if (comparacion < 0) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            } else {
                System.out.println("Error: el array contiene un objeto que no es un vehículo");
                return "No se encontraron vehículos de marca " + valorBuscado;
            }
        }
        return "No se encontraron vehículos de marca " + valorBuscado;
    }
}