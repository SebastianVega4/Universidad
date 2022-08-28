Algoritmo suma_digitos
	
    Escribir "Ingrese Número a sumar sus digitos"
    Leer Numer
	
	divisor <- 0
    Contador <- 1
	
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
		
		Mientras Numer > 10			
			descom <- Numer MOD Contador
			des <- (Numer - descom)/ Contador		
			sumaa <-sumaa + des
			Numer <- descom
			Contador <- Contador / 10
		FinMientras		
		
    Fin Si	
	
	totaldesuma<-sumaa + descom
	
	Escribir "*********************************"
    Escribir "La suma total de los digitos es:"
	Escribir "               " totaldesuma
	Escribir "*********************************"
	
FinAlgoritmo