package Tienda;
import java.util.Scanner;

public class Tienda {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int opcion=0;
		double SumValorproductos=0;
		
		//productos
		usuario user =new usuario();
		productos Google =new productos("Asistente Google",160000,20,true) ;
		productos Alexa =new productos("Asistente Alexa",230000,20,true) ;
		productos Amazon =new productos("Asistente Amazon",200000,20,true) ;
		productos Smartphone =new productos("Smartphone",800000,20,true);
		productos Sensor =new productos("Sensor Inteligente",30000,20,true) ;
		productos Interruptor =new productos("Interruptor Inteligente",45000,20,true) ;
		productos Toma =new productos("Toma Inteligente",50000,20,true) ;
		productos RobotAspirador =new productos("Robot Aspiradota",400000,20,true) ;
		productos Bombillo =new productos("Bombillo Inteligente",50000,20,true) ;
		productos Inflarrojo =new productos("Inflarrojo Inteligente",35000,20,true) ;
		
		
		//Desarrollo
		System.out.println("************************************************");
		System.out.println("   BIENVENIDO A LA TIENDA SEBASTEC S.A ");
		System.out.println("************************************************");
		System.out.println("   Escriba su Nombre para el registro de usurio");
		user.Nombre(sc.next());
		System.out.println("          Digite su Cedula");
		user.Cedula(sc.next());
		System.out.println("  Digite su Telefono de contacto");
		user.Telefono(sc.next());
		System.out.println("************************************************\n   ");
		do{
			System.out.println("********************************************************************");
			System.out.println("          Digite el Numero segun el producto a comprar\n 1=Asistente de Google  2=Asistente de Alexa 3=Asistente de Amazon  ");
			System.out.println("         4=Smartphone  5=Sensor  6= Interuptor  7=Toma \n       8=Robot Aspirador  9=Bolbillo  10=Inflarrojo \n            11=Generar Factura    12=Cancelar y Salir");
			System.out.println("********************************************************************");
			opcion=sc.nextInt();
			//"Operaciones" dependiendo el producto
			//Google
			if (opcion==1){	
				Google.Contador();
				Google.SubTotal();
			}//Alexa
			if (opcion==2){	
				Alexa.Contador();
				Alexa.SubTotal();
			}//Amazon
			if (opcion==3){	
				Amazon.Contador();
				Amazon.SubTotal();
			}//Smartphone
			if (opcion==4){	
				Smartphone.Contador();
				Smartphone.SubTotal();
			}//Sensor
			if (opcion==5){	
				Sensor.Contador();
				Sensor.SubTotal();
			}//Interruptor
			if (opcion==6){	
				Interruptor.Contador();
				Interruptor.SubTotal();
			}//Toma
			if (opcion==7){	
				Toma.Contador();
				Toma.SubTotal();
			}//Robot Aspiradora
			if (opcion==8){	
				RobotAspirador.Contador();
				RobotAspirador.SubTotal();
			}//Bombillo
			if (opcion==9){	
				Bombillo.Contador();
				Bombillo.SubTotal();
			}//Inflarrojo
			if (opcion==10){
				Inflarrojo.Contador();
				Inflarrojo.SubTotal();
			}
			if (opcion!=11 && opcion!=12){
				if(Google.verContador()>0)
				System.out.println(Google.supFactura()+"\n");
				if(Alexa.verContador()>0)
					System.out.println(Alexa.supFactura()+"\n");
				if(Amazon.verContador()>0)
					System.out.println(Amazon.supFactura()+"\n");
				if(Smartphone.verContador()>0)
					System.out.println(Smartphone.supFactura()+"\n");
				if(Sensor.verContador()>0)
					System.out.println(Sensor.supFactura()+"\n");
				if(Interruptor.verContador()>0)
					System.out.println(Interruptor.supFactura()+"\n");
				if(Toma.verContador()>0)
					System.out.println(Toma.supFactura());
				if(RobotAspirador.verContador()>0)
					System.out.println(RobotAspirador.supFactura()+"\n");
				if(Bombillo.verContador()>0)
					System.out.println(Bombillo.supFactura()+"\n");
				if(Inflarrojo.verContador()>0)
					System.out.println(Inflarrojo.supFactura()+"\n");
			}	
			//Factura
			if (opcion==11){
				SumValorproductos =Google.verSubTotal()+Alexa.verSubTotal()+Amazon.verSubTotal()+Smartphone.verSubTotal()+Sensor.verSubTotal()
				+Interruptor.verSubTotal()+Toma.verSubTotal()+RobotAspirador.verSubTotal()+Bombillo.verSubTotal()+Inflarrojo.verSubTotal();
				factura Sebastec =new factura(SumValorproductos);
				Sebastec.operarDescuentos();
				System.out.println("***************************************");
				System.out.println("      SELECIONE UN METODO DE PAGO");
				System.out.println("***************************************");
				System.out.println("  1=Visa o Mastercard   2=Efectivo");
				Sebastec.Opcion(sc.nextInt());
				System.out.println(user.Vertodo());
				
				//imprimir cada articulo y su valor
				if(Google.verContador()>0)
				System.out.println(Google.supFactura()+"\n");
				if(Alexa.verContador()>0)
					System.out.println(Alexa.supFactura()+"\n");
				if(Amazon.verContador()>0)
					System.out.println(Amazon.supFactura()+"\n");
				if(Smartphone.verContador()>0)
					System.out.println(Smartphone.supFactura()+"\n");
				if(Sensor.verContador()>0)
					System.out.println(Sensor.supFactura()+"\n");
				if(Interruptor.verContador()>0)
					System.out.println(Interruptor.supFactura()+"\n");
				if(Toma.verContador()>0)
					System.out.println(Toma.supFactura());
				if(RobotAspirador.verContador()>0)
					System.out.println(RobotAspirador.supFactura()+"\n");
				if(Bombillo.verContador()>0)
					System.out.println(Bombillo.supFactura()+"\n");
				if(Inflarrojo.verContador()>0)
					System.out.println(Inflarrojo.supFactura()+"\n");
				//factura precios
				System.out.println(Sebastec.verOpcion());
				System.out.println(Sebastec.Factura());
				
				//puntos
				System.out.println(Sebastec.puntosOptenidos());
				
				//salir
				opcion=12;
				}
		
			
		}while (opcion != 12);
		
		
		System.out.println("*******************************************************");
		System.out.println("         ESPERAMOS QUE TU INSTANCIA EN\n       LA TIENDA SEBASTEC S.A FUERA AGRADABBLE \n             fELIZ RESTO DE DIA ");
		System.out.println("*******************************************************");
	}
}