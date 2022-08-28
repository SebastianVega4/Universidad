import javax.swing.JOptionPane;
import java.util.Random;

public class Runner {
	public static void main(String[] args) {

		Random random = new Random();
		int num, numA, limiteS, limiteI, numeroIN = 0;
		limiteI = 1;
		limiteS = Integer.parseInt(JOptionPane.showInputDialog("Dijite el limite superior"));
		num = random.nextInt(limiteS + limiteI) + limiteI;
		do {
			numA = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero a divinar"));
			numeroIN++;
			if (numA > limiteS) {
				JOptionPane.showMessageDialog(null, "El numero " + numA + " esta por fuera del rango");
			} else {
				if (numA > num && numA != num) {
					JOptionPane.showMessageDialog(null, "El numero es Menor a " + numA);
				}
				if (numA < num && numA != num) {
					JOptionPane.showMessageDialog(null, "El numero es Mayor a " + numA);
				}
				if (numA == num) {
					JOptionPane.showMessageDialog(null, "Adivinaste \n " + "Usted realizo " + numeroIN + " intendos");
				}
			}
		} while (numA != num);
	}
}