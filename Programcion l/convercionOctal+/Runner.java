package convercion;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {
		convercion numberr = new convercion();

		String name = JOptionPane.showInputDialog(null, "Digite Nombre", "calculadora", JOptionPane.PLAIN_MESSAGE);

		String menu = "<<<<<<<MENU PRINCIPAL>>>>>>>\n" + "Conversor de Bases Numericas\n\n"
				+ "1. De Decimal a Otras Bases\n" + "2.  De Otras Bases a Decimal\n" + "S. Salir";

		char option = '0';

		do {
			// JOptionPane.showInputDialog(menu).charAt(0);
			option = ((String) JOptionPane.showInputDialog(null, menu, "Hola " + name + " bienvenido",
					JOptionPane.PLAIN_MESSAGE, null, new Object[] { "1", "2", "S" }, "selecciona")).charAt(0);
			option = (char) option;
			switch (option) {
			case '1': // decimal a otros
				while (true) {
					try {
						int num = Integer.parseInt(JOptionPane.showInputDialog("Digite Numero"));
						numberr.setDecimal(num);
						break;
					} catch (NumberFormatException e) {
						JOptionPane.showInternalMessageDialog(null, "Valor Invalido reintente", "Errror",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				JOptionPane.showMessageDialog(null, numberr.getDecimal());
				break;

			case '2':// otros a decimal
				String optionconver = (JOptionPane.showInputDialog(null, "Seleccione el tipo del numero a convertir",
						"Convercion", JOptionPane.PLAIN_MESSAGE, null,
						new Object[] { "Binario", "Octal", "Hexadecimal" }, "selecciona")).toString();
				String num = "0";
				if (optionconver == "Binario") {
					do {
						num = JOptionPane.showInputDialog("Digite Numero");
					} while (num.matches("^[0-1]$"));
				}

				if (optionconver == "Octal") {
					do {
						num = JOptionPane.showInputDialog("Digite Numero");
					} while (num.matches("^[0-7]$"));
				}

				if (optionconver == "Hexadecimal") {
					do {
						num = JOptionPane.showInputDialog("Digite Numero");
					} while (num.matches("^[0-9A-F]$"));
				}
				numberr.setOtros(optionconver, num);

				break;
			case 'S':
				JOptionPane.showMessageDialog(null, "Haz finalizado el programa");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcion no validad", "Errror", JOptionPane.ERROR_MESSAGE);
			}
		} while (option != 'S');

	}
}