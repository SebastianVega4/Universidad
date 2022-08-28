package Parcial;
import java.util.*;

public class cuenta {
	Scanner sc =new Scanner(System.in);
	private String titular="";
	private int cantidad=0;
	private int Deposito=0;
	private int Retirar=0;
	private int SalCuenta=0;
	private int opcion =0;
	
	public cuenta(String titular,int cantidad, int Salcuenta){
		this.titular = titular;
		this.cantidad = cantidad;
		this.SalCuenta = Salcuenta;
	}

	
	public void Titular(String titular) {
		this.titular = titular;
	}
	public String VerTitular() {
		return titular;
	}
	
	public void Deposito(int deposito) {
		Deposito = deposito;
	}
	public double VerDeposito() {
		return Deposito;
	}

	public void Retirar(int retirar) {
		Retirar = retirar;
	}
	public double VerRetirar() {
		return Retirar;
	}

	public void opcion(int opcion) {
		this.opcion = opcion ;
	}
	public double Veropcion() {
		return opcion;
	}
	public void operaciones() {
		if(Veropcion()==1) {
			System.out.println("************************************************");
			System.out.println("           Digite el Valor a Depositar");
			System.out.println("************************************************");
			Deposito= sc.nextInt();
			if((SalCuenta+Deposito)>=0) {
				SalCuenta=SalCuenta+Deposito;
				System.out.println("Su Deposito Se efectuo con exito");
			}else {
				System.out.println("*******************************************************");
				System.out.println("Error a ingresado un valor negativo al estado de cuenta");
				System.out.println("*******************************************************");
				}
		}else if(Veropcion()==2) {
			System.out.println("************************************************");
			System.out.println("           Digite el Valor a Retirar");
			System.out.println("************************************************");
			Retirar= sc.nextInt();
			if(SalCuenta-Retirar<0) {
				System.out.println("*******************************************************");
				System.out.println("Error a Retirado mas de lo que hay en su estado de cuenta");
				System.out.println("*******************************************************");
				System.out.println("          Vuelva a intentarlo de nuevo");
			}else {
				SalCuenta=SalCuenta-Retirar;
				System.out.println("Su Retiro Se efectuo con exito");
				}
		}
	}
	
	public void Salcuenta() {
		this.cantidad = SalCuenta;
	}
	public String VerSalcuenta() {
		if(opcion==1) {
			return "Nombre Del titular: "+VerTitular()+"\n" +"Usted Deposito: $"+ Deposito+"\n"+ "Su Saldo en la cuenta es: $"+SalCuenta;
		}else if(opcion==2) {
			return "Nombre Del titular: "+VerTitular()+"\n" +"Usted Retiro: $"+ Retirar+"\n"+ "Su Saldo en la cuenta es: $"+SalCuenta;
		}
		return titular;
	}
	public void Cantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double VerCantidad() {
		return cantidad;
	}
	
}
