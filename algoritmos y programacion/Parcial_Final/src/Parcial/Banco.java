package Parcial;
import java.util.*;
public class Banco {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		cuenta user =new cuenta(null,0,0);
		int opcion=0;
		
		System.out.println("************************************************");
		System.out.println("         Por favor ingrese su Nombre");
		System.out.println("************************************************");
		user.Titular(sc.next());;
		
		do{
		System.out.println("************************************************");
		System.out.println(" Digite el Numero segun el proceso a realizar \n   1=Ingresar(depositar)  2=Retirar\n            3=salir");
		System.out.println("************************************************");
		user.opcion(sc.nextInt());;
		user.operaciones();
		System.out.println("************************************************");
		System.out.println(user.VerSalcuenta());
		System.out.println("************************************************\n");
		if(user.Veropcion()==3){
			opcion=3;
		}
		}while (opcion != 3);
		
		System.out.println("************************************************");
		System.out.println("         Gracias por utilizar nuestro sistema");
		System.out.println("************************************************");
	}

}
