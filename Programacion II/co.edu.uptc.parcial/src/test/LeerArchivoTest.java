package test;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeerArchivoTest {
    @Test
    public void testLeerArchivo() throws IOException {
        String nombreArchivo = "miArchivo.txt";
        String contenidoEsperado = "¡Hola, mundo!";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String contenido = br.readLine();
            assertEquals(contenidoEsperado, contenido);
        }
    }
}

