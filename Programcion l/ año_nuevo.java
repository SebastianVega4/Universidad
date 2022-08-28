import java.util.Calendar;

import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {

		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos, mes, dia;
		int horaa�o, minutosa�o, segundosa�o, mesa�o, diaa�o;
		int horaa�on, minutosa�on, segundosa�on, mesa�on, diaa�on;

		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DATE);
		mes = calendario.get(Calendar.MONTH);
		mes = mes + 1;
		mesa�on = 12 - mes;
		diaa�o = 31 - dia;
		diaa�on = (diaa�o+(mesa�on*31))-2;
		horaa�o = 24 - hora;
		horaa�on = horaa�o+(24*diaa�o);
		minutosa�o = 60 - minutos;
		minutosa�on = minutosa�o+(60*horaa�o);
		segundosa�o = 60 - segundos;
		segundosa�on = segundosa�o+(60*minutosa�o);

		JOptionPane.showMessageDialog(null, "La hora actual es: " + hora + ":" + minutos + ":" + segundos + "\n"
				+ "DIA: " + dia + "                MES: " + mes + "\n" + 
				"Meses para el a�o nuevo: "+ mesa�on+ "\n"+
				"Dias para el a�o nuevo: " + diaa�on +"\n"+
				"Horas para el a�o nuevo: " +horaa�o + "\n"+
				"Minutos para el a�o nuevo: "+ minutosa�o + "\n"+
				"Segundos para el a�o nuevo: "+ segundosa�o);
		
		System.out.println("Programa finalizado");
	}
}