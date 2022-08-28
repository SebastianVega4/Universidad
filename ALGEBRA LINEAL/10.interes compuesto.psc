Proceso Interes_Compuesto
	Escribir "Dijite el capital inicial" ;
	Leer inicial ;
	Escribir "Dijite la taza de interes" ;
	Leer interes ;
	Escribir "Dijite el plazo o tiempo establecido" ;
	Leer tiempo ;
	//formula c*(1+r/100)^t
	finall<-inicial*(1+interes)^tiempo/100 ;
	Escribir "El interes compuesto hallado da:" ;
	Escribir "********************************" ;
	Escribir "           "  finall  "            " ;
	Escribir "********************************" ;
	
	
FinProceso
