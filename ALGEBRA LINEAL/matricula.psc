Algoritmo matricula
	montoMenor <- 50001
	montoMayor <- -1
	montoActual <- 0
	Escribir 'Ingrese el numero de estudiantes '
	Leer n
	Para i<-1 Hasta n Hacer
		Escribir 'Ingrese el monto de la matrícula del estudiante ', i
		Leer montoActual
		Mientras montoActual<0 O montoActual>50000 Hacer
			Escribir 'Monto de matrícula inválido. Ingrese un valor entre 0 y 50000.'
			Leer montoActual
		FinMientras
		Si montoActual<montoMenor Entonces
			montoMenor <- montoActual
		FinSi
		Si montoActual>montoMayor Entonces
			montoMayor <- montoActual
		FinSi
	FinPara
	Escribir 'El monto menor de matrícula es ', montoMenor
	Escribir 'El monto mayor de matrícula es ', montoMayor
FinAlgoritmo
