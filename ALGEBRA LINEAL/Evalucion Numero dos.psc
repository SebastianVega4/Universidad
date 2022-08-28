proceso evalucaion_n2
	escribir "Marly Dayanne Saavedra Rios - Johan Sebastian Vega Ruiz"
	leer n
	
	Numerador <- 0
	Denominador <- 3
	Para a<-1 Hasta n Hacer
		factorial1 <- 1
		Para U<-1 Hasta Numerador Hacer
			factorial1 <- factorial1*U
		FinPara
		factorial <- 1
		Para P<-1 Hasta Denominador Hacer
			factorial <- factorial*P
		FinPara
		Si a MOD 2=0 Entonces
			Escribir "En fraccion es:" "        " '+  ',factorial1,' / ',factorial
			resultado<-factorial1/factorial
			escribir "El resultado es :" resultado
			escribir "        "
		SiNo
			Escribir "En fraccion es:" "        "  '-  ',factorial1,' / ',factorial
			resultado<-factorial1/factorial
			escribir "El resultado es :" resultado
			escribir "        "
		FinSi
		Numerador <- Numerador+1
		Denominador <- Denominador+1
		
	FinPara
Finproceso

