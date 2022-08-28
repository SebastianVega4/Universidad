Proceso Interes_simple
	Escribir "Digite el valor del capital" Sin Saltar ;
	Leer capital ;
	Escribir "Ingrese la tasa de interes" Sin Saltar ;
	Leer tasa ;
	Escribir "Digite el tiempo" Sin Saltar ;
	Leer tiempo ;
	//formula C*c*i*t/100
	Interes<-capital*tasa*tiempo/100 ;
	Escribir "El interes simple hallado da:" ;
	Escribir "*****************************" ;
	Escribir "           " Interes "       " ;
	Escribir "*****************************" ;
FinProceso
