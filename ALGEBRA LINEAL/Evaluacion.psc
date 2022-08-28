Proceso Evaluacion
	
	Escribir "Escribir cantidad de numeros a calcular si es positivo o negativo"
	Leer T
	
	semayresta( pro1,pro2,neutro)
	
	Para a<-1 Hasta T con paso 1 Hacer
		
        Escribir "ingrese el numero"
        Leer n
		Si n=0 Entonces
			neutro <- 0+1		
		Sino
			Si n > 0 Entonces
				pro1 <- pro1+1
			Sino
				pro2 <- pro2+1
			Fin Si
		Fin Si
        
		
    Fin Para
	

	
	
	Escribir  "*******************************"
    Escribir "      " "Numeros positivos: ", pro1
	Escribir "      " " Numeros negativos: ", pro2
	Escribir "       " " Numeros neutros: ", neutro
	Escribir  "*******************************"
	
FinProceso

SubProceso semayresta( pro1,pro2,neutro)
	
	todo<-0
	
Fin SubProceso