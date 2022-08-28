Proceso volumen_del_cilindro
	Escribir  "Ingrese el radio del cilindro" Sin Saltar ;
	Leer radio ;
	Escribir "Ingrese la altura del cilindro" Sin Saltar ;
	leer altura ;
	//formula 3.1416 R^2 * h
	volumen<-3.1416*(radio*radio)*altura ;
	Escribir "El volumen del cilindro es :" ;
	Escribir "****************************" ;
	Escribir "         " volumen "        " ;
	Escribir "****************************" ;
FinProceso
