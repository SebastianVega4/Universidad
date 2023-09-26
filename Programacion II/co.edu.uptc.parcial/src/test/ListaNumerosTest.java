package test;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaNumerosTest {
    @Test
    public void testEncontrarMaximo() {
        ListaNumeros lista = new ListaNumeros();
        List<Integer> numeros = Arrays.asList(1, 5, 3, 9, 2);
        int maximo = lista.encontrarMaximo(numeros);
        assertEquals(9, maximo);
    }
}
