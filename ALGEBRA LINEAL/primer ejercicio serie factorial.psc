Proceso serie_factorial
	Escribir "hallar la serie -3!+5!-7!..."
	Escribir 'n = ' Sin Saltar
	Leer n
	d<- 1
	s<- -1
	Para i<-1 Hasta n Hacer
		d<-d*(2*i)*(2*i+1)
		d<- -(d)
		suma<- suma + d
		escribir suma
	FinPara
	Escribir "el resultado el" suma
FinProceso