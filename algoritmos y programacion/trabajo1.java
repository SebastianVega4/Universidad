public class trabajo1 { 
    public static void main(String args[]) { 

	System.out.println("Hello World"); 


    int DIA, MES ,AÑO;
	int suma, resta, multiplicacion, divicion, modulo;
	double multiplicacionn, divicionn;
	char letra1, letra2, letra3, letra4;
	

	DIA = 12;
	MES = 01;
	AÑO = 2000;

	System.out.println(DIA + MES + AÑO);
	
	suma= DIA + MES + AÑO;
	resta= DIA - MES - AÑO;
	multiplicacionn= (DIA * MES) * AÑO;
	divicionn= (DIA / MES) / AÑO;
	modulo= (DIA % MES) % AÑO;
	palabra=letra1+letra2+letra3+letra4;
			
	System.out.println("nacio el dia" + DIA);
	System.out.println("nacio el mes" + MES);
	System.out.println("nacio el año" + AÑO);
	System.out.println("El resultado de la suma es: " + suma);
	System.out.println("El resultado de la resta es: " + resta);
	System.out.println("El resultado de la multiplicacion es: " + multiplicacionn);
	System.out.println("El resultado de la divicion es: " + divicionn);
	System.out.println("El resultado de la modulo es: " + modulo);
}
}
