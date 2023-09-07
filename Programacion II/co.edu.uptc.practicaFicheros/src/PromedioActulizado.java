import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PromedioActulizado {
    public static void main(String[] args) {
        String archivo = "C:\\Users\\A372144\\Downloads\\Git\\Java\\Programacion II\\co.edu.uptc.practicaFicheros\\src\\Notas.csv"; // Nombre del archivo
        String linea;

        List<String> lineasActualizadas = new ArrayList<>();
        lineasActualizadas.add("Nombre,Nota1,Nota2,Nota3,Def");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Leer la primera línea para obtener los nombres de las notas
            linea = br.readLine();
            String[] nombresNotas = linea.split(",");

            // Calcular el índice de las notas numéricas
            int[] indicesNotasNumericas = new int[nombresNotas.length - 1];
            for (int i = 1; i < nombresNotas.length; i++) {
                indicesNotasNumericas[i - 1] = i;
            }

            // Leer y procesar las filas de datos
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreEstudiante = datos[0];
                double sumaNotas = 0.0;
                int contadorNotas = 0;

                // Calcular la suma de las notas numéricas
                for (int indice : indicesNotasNumericas) {
                    sumaNotas += Double.parseDouble(datos[indice]);
                    contadorNotas++;
                }

                // Calcular el promedio
                double promedio = sumaNotas / contadorNotas;

                // Añadir la línea actualizada a la lista
                lineasActualizadas.add(nombreEstudiante + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + promedio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir las líneas actualizadas en el archivo CSV
        try (FileWriter writer = new FileWriter(archivo)) {
            for (String line : lineasActualizadas) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}