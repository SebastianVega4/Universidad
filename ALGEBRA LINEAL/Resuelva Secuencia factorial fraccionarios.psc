proceso hrdh_sdg
	escribir "gdfg"
	leer n
	
	numerator <- 0
	denominator <- 3
	Para a<-1 Hasta n Hacer
		factorial1 <- 1
		Para g<-1 Hasta numerator Hacer
			factorial1 <- factorial1*g
		FinPara
		factorial <- 1
		Para t<-1 Hasta denominator Hacer
			factorial <- factorial*t
		FinPara
		Si a MOD 2=0 Entonces
			Escribir '+  ',factorial1,' / ',factorial
			resultado<-factorial1/factorial
			escribir resultado
		SiNo
			Escribir '-  ',factorial1,' / ',factorial
			resultado<-factorial1/factorial
			escribir resultado
		FinSi
		numerator <- numerator+1
		denominator <- denominator+1
		
	FinPara
Finproceso

