package Parcial;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {
		
		int edad = 0, diasDieta = 0;
		double peso = 0, objetivo = 0, pesodieta = 0;
		String estado = "";
		double carboidratos = 60.1, proteinas = 30.5, FruyVer = -24.4, dieta;
		
		edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su EDAD"));
		peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese su PESO"));
		
		if (edad >= 5 && edad <= 10) {
			if (peso < 16) {
				estado = "Desnutricion";
				objetivo = 22;
			} else if (peso > 28) {
				estado = "Sobre peso";
				objetivo = 24;
			} else {
				estado = "Saludable";
				objetivo = 28;
			}
		} else if (edad >= 11 && edad <= 13) {
			if (peso < 30) {
				estado = "Desnutricion";
				objetivo = 32;
			} else if (peso > 50) {
				estado = "Sobre peso";
				objetivo = 43;
			} else {
				estado = "Saludable";
				objetivo = 50;
			}
		} else if (edad >= 14 && edad <= 17) {
			if (peso < 51) {
				estado = "Desnutricion";
				objetivo = 56;
			} else if (peso > 63) {
				estado = "Sobre peso";
				objetivo = 58;
			} else {
				estado = "Saludable";
				objetivo = 63;
			}
		}
		// AcPc+ApPp+AfvPfv
		pesodieta = peso;
		switch (estado) {
		case "Desnutricion":
			while (pesodieta < objetivo) {
				dieta = ((carboidratos * 2) + (proteinas * 1) + (FruyVer * 2))/1000;
				pesodieta = pesodieta + dieta;
				diasDieta++;
			}
			break;
		case "Sobre peso":
			while (pesodieta < objetivo) {
				dieta = (carboidratos * 0.6) + (proteinas * 1) + (FruyVer * 4)/1000;
				pesodieta = pesodieta + dieta;
				diasDieta++;
			}
			break;
		case "Saludable":
			while (pesodieta < objetivo) {
				dieta = (carboidratos * 0.5) + (proteinas * 0.7) + (FruyVer * 2)/1000;
				pesodieta = pesodieta + dieta;
				diasDieta++;
			}
			break;
		default:
			break;
		}
		JOptionPane.showMessageDialog(null, "Su estado nutricional es: " + estado + "\n" + "Peso ideal alcanzar "
				+ objetivo + "\n" + "Días requeridos para obtener el peso objetivo o máximo: " + diasDieta);
	}
}