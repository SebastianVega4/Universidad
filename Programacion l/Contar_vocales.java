import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {
		
		int conteoA=0, conteoE=0, conteoI=0, conteoO=0, conteoU=0;
		String cadena , vocal;
		char caracter;
		
		cadena = JOptionPane.showInputDialog("Digite Fase a validar");
		
		for (int i = 0; i < cadena.length(); i++) {
			caracter =cadena.charAt(i);
			vocal = String.valueOf(caracter); 
			if (vocal.matches("a") || vocal.matches("A")) {
				conteoA = conteoA +1;
			}
			if (vocal.matches("e") || vocal.matches("E")) {
				conteoE = conteoE +1;
			}
			if (vocal.matches("i") || vocal.matches("I")) {
				conteoI = conteoI +1;
			}
			if (vocal.matches("o") || vocal.matches("O")) {
				conteoO = conteoO +1;
			}
			if (vocal.matches("u") || vocal.matches("U")) {
				conteoU = conteoU +1;
			}
		}
		JOptionPane.showMessageDialog(null,cadena+" \n"+"Tu cadena de texto tiene: \n"+ "Vocal A: "+conteoA+"\n"+"Vocal E: " +
		conteoE+"\n"+ "Vocal I: "+conteoI+"\n"+ "Vocal O: "+conteoO+"\n"+ "Vocal U: "+conteoU);
		
		System.out.println("Programa finalizado");
	}
}