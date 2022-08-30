import java.util.Scanner;

public class repaso{
 public static void main (String arg []){
  Scanner sc =new Scanner(System.in);
	
	int opcion=0, edad=0,grupo=6 ;


	do{
	System.out.println("***************************************");
	System.out.println("       ¿Que curso desea elegir?"        );
	System.out.println("  1= Calculo  2=Economia 3=Programacion");
	System.out.println("        4= Catedra  5=Ingles"           );
	System.out.println("***************************************");
	opcion = sc.nextInt();

	System.out.println("***************************************");
	System.out.println("            ¿Que edad tines?"           );
	System.out.println("***************************************");
	edad = sc.nextInt();

	 switch(opcion){
		case 1: System.out.println("***********************************");
			System.out.println("Seleccionaste la materia: CALCULO");
			System.out.println("  ");
			
			if(edad>=18){
			   System.out.println("Cumples con los requisitos para inscribir Calculo");
			   System.out.println("***********************************");
			}else{
				System.out.println("NO Cumples con los requisitos minimos");
				System.out.println("        para inscribir Calculo");
			   	System.out.println("***********************************");
			}
			break;
		case 2: System.out.println("***********************************");
			System.out.println("Seleccionaste la materia: ECONOMIA");
			System.out.println("***********************************");
		while(grupo>=3){
				System.out.println("***************************************");
				System.out.println("            ¿Que Grupo eliges?"         );
				System.out.println("                1, 2 o 3"         	   );
				System.out.println("***************************************");
				grupo = sc.nextInt();
			}
			break;
		case 3:	System.out.println("***********************************" );
			System.out.println("Seleccionaste la materia: PROGRAMACION");
			System.out.println("***********************************" );
			break;
		case 4: System.out.println("***********************************" );
			System.out.println("Seleccionaste la materia: CATEDRA   ");
			System.out.println("***********************************" );
			break;
		case 5: System.out.println("***********************************" );
			System.out.println("Seleccionaste la materia: INGLES");
			System.out.println("***********************************" );
		break;
		default: System.out.println("***********************************");
			 System.out.println("Seleccionaste una opcion no valida"	);
			 System.out.println("***********************************");
	   }

	}while (opcion>0 & opcion<6);

 }
}