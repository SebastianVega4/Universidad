Algoritmo suma_digitos
	
	//Johan Sebastian Vega Ruiz 201911913
	
    Escribir "Ingrese Número a sumar sus digitos"
    Leer Numer
	Numeroinicial <- Numer
	
	divisor <- 0
    Contador <- 1
	multiplicacion <- 1
	divicion <- 1
	
    Si Numer < 10 Entonces
        Escribir Numer
    SiNo
		
		Mientras divisor = 0 Hacer			
			Si Numer > (Contador * 10) Entonces
				Contador <- Contador * 10
			SiNo
				divisor <- 1
			Fin Si				
		Fin Mientras	
		
		Si Numer < 99 Entonces
			Mientras Numer > 10		
				descom <- Numer MOD Contador
				des <- (Numer - descom)/ Contador	
				sumaa <-sumaa + des
				resta <- des - resta
				multiplicacion <- multiplicacion * des
				divicion <-  des / divicion
				Contador <- Contador / 10
				Numer <- descom
			FinMientras		
		SiNo
			Mientras Numer > 10		
				descom <- Numer MOD Contador
				des <- (Numer - descom)/ Contador	
				sumaa <-sumaa + des
				Si opcionres = 0 Entonces
					resta <- des - resta
					opcionres <- 1
				SiNo
					resta <- resta- des
				Fin Si
				multiplicacion <- multiplicacion * des
				Si opcionmulti = 0 Entonces
					divicion <-  divicion / des
					opcionmulti <- 1
				SiNo
					divicion <-  divicion / des
				Fin Si
				Contador <- Contador / 10
				Numer <- descom
			FinMientras
		Fin Si
		
		
    Fin Si	
	
	totaldesuma <- sumaa + descom
	totalderesta <- resta - descom
	totaldemultiplicacion <- multiplicacion * descom
	totaldedivicion <- divicion / descom
	
	Escribir "****************************************"
    Escribir "La Suma total de los digitos del numero " Numeroinicial " es:"
	Escribir "               " totaldesuma
	Escribir "La Resta total de los digitos del numero " Numeroinicial " es:"
	Escribir "               " totalderesta
	Escribir "La Multiplicacion total de los digitos del numero " Numeroinicial " es:"
	Escribir "               " totaldemultiplicacion
	Escribir "La Divicion total de los digitos del numero " Numeroinicial " es:"
	Escribir "               " totaldedivicion
	Escribir "***************************************"
	
FinAlgoritmo