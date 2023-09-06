import java.io.*;

public class Main {
    public static void main(String[] args) {

        //Crear archivo
        File archivo = new File("miarchivo.txt");

        //Comprovacion de existencia
        if (archivo.exists()) {
            System.out.println("El archivo existe");
        } else {
            System.out.println("El archivo no existe");
        }

        //Leer archivo
        try {
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Editar Archivo
        try {
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write("Hola, mundo!");
            buffer.newLine(); // Agregar una nueva línea
            buffer.write("Otra línea de texto");
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Eliminar archivo
        /*if (archivo.delete()) {
            System.out.println("El archivo se ha eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }*/




    }
}