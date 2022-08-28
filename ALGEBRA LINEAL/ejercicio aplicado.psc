Proceso cuántos_estudiantes_pasaron_y_cuantos_perdieron
	
	Escribir "digite numero de estudiantes"
	leer n
	
	suma<-0
	suma2<-0
	
	Para i<-1 Hasta n Con Paso 1 Hacer
		Escribir "escribir la nota" 
		leer nota
		Si nota<0 o nota>5 Entonces
			Escribir " Error intente de nuevo"
			i<-i-1
		SiNo
			Si nota>2.9 Entonces
				suma<-suma+1
			Sino
				suma2<-suma2+1
			Fin Si
		Fin Si
	Fin Para
	
	Escribir "*************************************************"
	Escribir "*************************************************"
	Escribir "El numero de estudientes que pasaron es: " suma
	Escribir "El numero de estudientes que perdieron es: " suma2
	Escribir "*************************************************"
	Escribir "*************************************************"
	
FinProceso
