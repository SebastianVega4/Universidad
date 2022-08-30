public class trabajo2 { 
    public static void main(String args[]) { 


	double numero1, numero2, numero3, numero4,  numero5,constante1 ,constante2 ;
	double resultado1, resultado2, resultado3, resultado4, resultado5, resultado6 ;

	constante1=2.0;
 	constante2=5.0;
	numero1= 8.0;
	numero2= 3.0;
	numero3= -5.0;
	numero4= 11.0;
	numero5= 8.0;

	resultado1=(numero1/constante1+(4-numero2*3))%(numero1+numero2-constante2);
	resultado2=(numero1*numero3/numero4*numero3)*((numero1/numero5)+numero4);

	resultado3=(numero1*numero2)%numero3;
	resultado4=(3*numero1-2*numero2)%(2*numero1-numero3);
	resultado5=2*(resultado1/5+(4-numero2*3))%(numero1+numero3-2);
	resultado6=(numero1-3*numero2)%(numero3+2*resultado1)/(resultado1-numero3);




	System.out.println("El resultado de la primera operacion es: " + resultado1);
	System.out.println("El resultado de la segunda operacion  es: " + resultado2);
	System.out.println(" ");
	System.out.println("*******************************************");
	System.out.println(" ");
	System.out.println("El resultado de la tercera operacion  es: " + resultado3);
	System.out.println("El resultado de la cuarta operacion  es: " + resultado4);
	System.out.println("El resultado de la quinta operacion  es: " + resultado5);
	System.out.println("El resultado de la sexta operacion  es: " + resultado6);

 }
}