import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {

		String Name, Materia;
		int Ponderado = 0, incremento = 0, PonderadoS = 0;
		double note = 0.0, Definitiva = 0.0;
		boolean exited = true;

		Name = JOptionPane.showInputDialog("Dijite su nombre");
		Materia = JOptionPane.showInputDialog("Dijite la materia a calcular");

		do {

			incremento++;
			int ciclo = 1;
			while (ciclo == 1) {
				note = Double.parseDouble(JOptionPane.showInputDialog("Dijite la nota # " + incremento));
				if (note >= 0.0 && note <= 5.0) {
					ciclo = 0;
				} else {
					JOptionPane.showMessageDialog(null,
							"*****Error la nota ingresada no esta dentro  del valor 0.0-5.0*****");
				}
			}

			Ponderado = Integer.parseInt(JOptionPane.showInputDialog("Dijite porcentaje la nota # " + incremento));
			PonderadoS = PonderadoS + Ponderado;
			Definitiva = Definitiva + note * (Ponderado / 100.0);

			if (PonderadoS > 100) {
				JOptionPane.showMessageDialog(null, "*********Error el ponderado Soprepasa el 100%********* \n "
						+ "vuelva a dijitar la nota y porcentaje respectivo corectemente");
				incremento--;
				PonderadoS = PonderadoS - Ponderado;
			} else if (PonderadoS < 100) {
				char option = ((String) JOptionPane.showInputDialog(null,
						"�Desea Inscrbir mas notas? \n" + "Y= Si   N= No", "", JOptionPane.PLAIN_MESSAGE, null,
						new Object[] { "Y", "N" }, "selecciona")).charAt(0);
				switch (option) {
				case 'Y':
					System.out.println("ok");
					break;
				case 'N':
					exited = false;
					break;
				default:
					break;
				}
			}
			if (exited == false) {
				break;
			}
		} while (PonderadoS < 100);

		JOptionPane.showMessageDialog(null, Name + "\nSu nota final es: " + Definitiva + "", "Definitiva de " + Materia,
				JOptionPane.OK_OPTION);
	}
}