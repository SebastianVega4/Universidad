package test;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenarArchivoTest {
    @Test
    public void testOrdenarArchivo() throws IOException {
        String nombreArchivo = "miArchivo.txt";
        List<String> lineas = Arrays.asList("Hola", "Mundo", "¡Hola, mundo!");
        List<String> lineasOrdenadas = new ArrayList<>(lineas);
        lineasOrdenadas.sort(null);

        // Escribir las líneas en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }

        // Ordenar el archivo
        OrdenarArchivo.ordenarArchivo(nombreArchivo);

        // Leer las líneas ordenadas del archivo
        List<String> lineasLeidas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLeidas.add(linea);
            }
        }

        assertEquals(lineasOrdenadas, lineasLeidas);
    }
}