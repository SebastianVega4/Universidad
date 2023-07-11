import co.edu.uptc.model.Gerente;
import co.edu.uptc.model.Vendedor;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Sebastian","3133890068",2_000_000.0,"sistemas");
        Vendedor vendedor = new Vendedor("Sara","3133334478",1_000_000.0,400_000.0);


        System.out.println(gerente.toString()+"Horas Trabajadas = "+gerente.alcularHorasTrabajadas(8,12));
        System.out.println(vendedor.toString()+"Horas Trabajadas = "+gerente.alcularHorasTrabajadas(10,12));
    }
}