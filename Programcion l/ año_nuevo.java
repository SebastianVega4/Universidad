package Año;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {

		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos, mes, dia;
		int horaaño, minutosaño, segundosaño, mesaño, diaaño;
		int horaañon, minutosañon, segundosañon, mesañon, diaañon;

		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DATE);
		mes = calendario.get(Calendar.MONTH);
		mes = mes + 1;
		mesañon = 12 - mes;
		diaaño = 31 - dia;
		diaañon = (diaaño+(mesañon*31))-2;
		horaaño = 24 - hora;
		horaañon = horaaño+(24*diaaño);
		minutosaño = 60 - minutos;
		minutosañon = minutosaño+(60*horaaño);
		segundosaño = 60 - segundos;
		segundosañon = segundosaño+(60*minutosaño);

		JOptionPane.showMessageDialog(null, "La hora actual es: " + hora + ":" + minutos + ":" + segundos + "\n"
				+ "DIA: " + dia + "                MES: " + mes + "\n" + 
				"Meses para el año nuevo: "+ mesañon+ "\n"+
				"Dias para el año nuevo: " + diaañon +"\n"+
				"Horas para el año nuevo: " +horaaño + "\n"+
				"Minutos para el año nuevo: "+ minutosaño + "\n"+
				"Segundos para el año nuevo: "+ segundosaño);
		
		System.out.println("Programa finalizado");
	}
}