Algoritmo Primos
	Escribir "Hasta que numero quiere saber si es primo"
	Leer cantidad
	Para numer <- 1 hasta cantidad hacer
		N<- 1
		suma <- 0
		mientras N <= numer hacer
			si numer mod N == 0 entonces
				suma <- suma + 1
			FinSi
			N<-N+1
		FinMientras
		si suma == 2 entonces
			Escribir "El numero " numer " es primo "
		FinSi
	FinPara
FinAlgoritmo
