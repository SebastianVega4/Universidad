public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("John", "Masculino", "201911913");
        Profesor profesor = new Profesor("Sebastian", "Masculino", "202011845");

        System.out.println(estudiante);
        System.out.println(estudiante.inscribir());
        System.out.println(estudiante.BinestarUni());
        System.out.println(estudiante.estacionamientoVeicular() + "\n");


        System.out.println(profesor);
        System.out.println(profesor.inscribir());
        System.out.println(profesor.BinestarUni());
        System.out.println(profesor.estacionamientoVeicular() + "\n");

    }
}