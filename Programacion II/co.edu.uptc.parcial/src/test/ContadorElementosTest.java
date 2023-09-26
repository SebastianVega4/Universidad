package test;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContadorElementosTest {
    @Test
    public void testContarElementosRepetidos() {
        ContadorElementos contador = new ContadorElementos();
        List<Integer> numeros = Arrays.asList(1, 2, 3, 2, 1, 3, 3);
        Map<Integer, Integer> resultado = contador.contarElementosRepetidos(numeros);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 2);
        expected.put(3, 3);
        assertEquals(expected, resultado);
    }
}