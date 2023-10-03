package test;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraPromedioTest {
    @Test
    public void testCalcularPromedio() {
        CalculadoraPromedio calculadora = new CalculadoraPromedio();
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        double promedio = calculadora.calcularPromedio(numeros);
        assertEquals(3.0, promedio);
    }

    @Test
    public void testCalcularPromedioListaVacia() {
        CalculadoraPromedio calculadora = new CalculadoraPromedio();
        List<Integer> numeros = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularPromedio(numeros);
        });
    }
}
