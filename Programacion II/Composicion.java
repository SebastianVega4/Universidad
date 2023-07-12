import logica.Examen;
import logica.Fecha;
import logica.Hora;

public class Composicion {
    public static void main(String[] args) {

        Fecha fecha = new Fecha(1, 4, 2018);
        Hora hora = new Hora(15, 45);
        Examen examem = new Examen("Java", "A-567", fecha, hora);
        System.out.println(examem.toString());
        examem.setFecha(4, 6, 2020);
        System.out.println(new Hora(11, 0));
        examem.setHora(23,0);
        System.out.println(examem.toString());

    }


}
