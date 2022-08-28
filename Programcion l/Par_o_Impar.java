import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {

		String numdig = null;
		int Nimpares = 0, Npares = 0, cantidadNum=0;
		int  SumPares=0, SumImpares=0;

		do {
			try {
				numdig = JOptionPane.showInputDialog(null, "Digite el numero ");
				int num = Integer.parseInt(numdig);
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ingrese un numero valido \nvuelva a intentarlo", "ERROR", 3);
			}
		} while (true);

		char[] num = numdig.toCharArray();
		cantidadNum = num.length;

		for (int i = 0; i < num.length; i++) {
			if (num[i] % 2 == 0) {
				Npares = Npares + 1;
				int numero =Character.getNumericValue(num[i]);
				SumPares =SumPares+numero;
			} else {
				Nimpares = Nimpares + 1;
				int numero1 =Character.getNumericValue(num[i]);
				SumImpares = SumImpares + numero1;
			}
		}
		JOptionPane.showMessageDialog(null, "Su mumero es: "+numdig+"\n"+"Tiene "+cantidadNum+" numeros"+"\n"+
				"Pares: "+Npares+"\n"+"Impares: "+Nimpares+"\n"+"Suma de Pares: "+SumPares+"\n"+"Suma de Impares: "+SumImpares, "Solucion", 3);
	}
}