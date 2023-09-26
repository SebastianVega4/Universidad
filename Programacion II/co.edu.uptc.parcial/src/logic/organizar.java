package logic;

public class organizar {

}
import java.util.ArrayList;
        import java.util.List;
public class FiltroNumerosPares {
    public List<Integer> filtrarPares(List<Integer> numeros) {
        List<Integer> pares = new ArrayList<>();
        for (int num : numeros) {
            if (num % 2 == 0) {
                pares.add(num);
            }
        }
        return pares;
    }
}
import java.util.List;
public class CalculadoraPromedio {
    public double calcularPromedio(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("La lista de números no puede estar vacía.");
        }
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return (double) suma / numeros.size();
    }
}
import java.util.HashMap;
        import java.util.Map;
public class ContadorElementos {
    public Map<Integer, Integer> contarElementosRepetidos(List<Integer> numeros) {
        Map<Integer, Integer> contador = new HashMap<>();
        for (int num : numeros) {
            contador.put(num, contador.getOrDefault(num, 0) + 1);
        }
        return contador;
    }
}
public class StringUtil {
    public String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("La cadena de entrada no puede ser nula.");
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }
}
import java.io.*;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;
public class OrdenarArchivo {
    public static void ordenarArchivo(String nombreArchivo) throws IOException {
        // Leer las líneas del archivo
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        // Ordenar las líneas
        Collections.sort(lineas);
        // Escribir las líneas ordenadas de nuevo al archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }
}