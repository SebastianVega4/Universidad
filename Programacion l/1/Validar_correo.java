import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {

		int ciclo=0;
		String email="";

		do {
			Pattern parametros = Pattern.compile("^([A-Za-z0-9_.-]+@[0-9a-zA-Z]+[.][a-z]{3})([.][a-z]{2})?$");
			email = JOptionPane.showInputDialog(null,
					"Ingrese el correo a validar: \nExample123@Dominio.***  o tambien  \nExample123@Dominio.***.** \n", email);
			Matcher validar = parametros.matcher(email);

			if (validar.find()) {
				JOptionPane.showMessageDialog(null, "El email ingresado ES valido");
				ciclo=1;
			} else {
				JOptionPane.showMessageDialog(null, "El email ingresado *NO* es valido");
			}

		} while (ciclo==0);
		System.out.println("Programa finalizado");
	}
}