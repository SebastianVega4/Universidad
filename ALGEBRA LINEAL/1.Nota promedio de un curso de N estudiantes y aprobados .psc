Proceso Promedio
	
	//Johan Sebastian Vega Ruiz 201911913
	
	Escribir "Dijite el Numero de estudiantes"
	Leer NUM
	
	Para NEstu<-1 Hasta NUM Con Paso 1 Hacer
		Escribir "Nota del estudiante # " NEstu
		leer NOT
		Si NOT < 30 Entonces
			Repro <- Repro + 1
		SiNo
			Apro <- Apro + 1
		Fin Si
		
		suma<-suma+NOT
		
	Fin Para
	
	Escribir "*****************************************"
	Escribir "Aprobaron # " Apro " Estudiendes"
	Escribir "Reprobaron # " Repro " Estudientes"
	Escribir "la nota promedio del curso es" suma/NUM	
	Escribir "*****************************************"
	
FinProceso
