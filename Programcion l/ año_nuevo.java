import java.util.Calendar;
import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {

		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos, mes, dia;
		int horaano, minutosano, segundosano, mesano, diaano;
		int horaanon, minutosanon, segundosanon, mesanon, diaanon;

		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DATE);
		mes = calendario.get(Calendar.MONTH);
		mes = mes + 1;
		mesanon = 12 - mes;
		diaano = 31 - dia;
		diaanon = (diaano+(mesanon*31))-2;
		horaano = 24 - hora;
		horaanon = horaano+(24*diaano);
		minutosano = 60 - minutos;
		minutosanon = minutosano+(60*horaano);
		segundosano = 60 - segundos;
		segundosanon = segundosano+(60*minutosano);

		JOptionPane.showMessageDialog(null, "La hora actual es: " + hora + ":" + minutos + ":" + segundos + "\n"
				+ "DIA: " + dia + "                MES: " + mes + "\n" +
				"Meses para el año nuevo: "+ mesanon+ "\n"+
				"Dias para el año nuevo: " + diaanon +"\n"+
				"Horas para el año nuevo: " +horaano + "\n"+
				"Minutos para el año nuevo: "+ minutosano + "\n"+
				"Segundos para el año nuevo: "+ segundosano);

		System.out.println("Programa finalizado");
	}
}