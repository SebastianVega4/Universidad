package test;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiltroNumerosParesTest {
    @Test
    public void testFiltrarPares() {
        FiltroNumerosPares filtro = new FiltroNumerosPares();
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> pares = filtro.filtrarPares(numeros);
        List<Integer> expected = Arrays.asList(2, 4, 6);
        assertEquals(expected, pares);
    }
}
