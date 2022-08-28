Proceso Factorialy_Combinacion
	// N!/(N-R)!R!
	Escribir "Ingrese la cantidad de elementos"
	Leer N
	Escribir "Ingrese el tamaño de los grupo (de 2 en 2, 3 en 3):"
	Leer R
	combinacion<-1
	Para i<-0 Hasta R-1 Hacer
		combinacion<-combinacion*((N-i)/(R-i))
	FinPara
	Escribir "La cantidad de combinaciones es: ",combinacion
FinProceso

