import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {

		String cadena1, cadena2, Cadenaamostrar = "";

		cadena1 = JOptionPane.showInputDialog("Escriba su Primer texto a validar");
		cadena2 = JOptionPane.showInputDialog("Escriba su Segundo texto a validar");

		for (int i = 0; i < cadena1.length(); i++) {
			try {
				if (cadena1.charAt(i) == cadena2.charAt(i)) {
					Cadenaamostrar = Cadenaamostrar + String.valueOf(cadena1.charAt(i));
				} else {
					Cadenaamostrar = Cadenaamostrar + "  ";
				}
			} catch (Exception e) {
				i++;
			}

		}
		JOptionPane.showMessageDialog(null, "Cadena 1: \n" + cadena1 +"\n"+ "Cadena 2: \n" + cadena2
				+ "\n"+"Su cadena Con Intersecci�n es: \n" + Cadenaamostrar);
		System.out.println("Programa finalizado");
	}
}