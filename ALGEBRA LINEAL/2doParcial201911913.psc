Algoritmo Segundo_Parcial
	
	//Johan Sebastian Vega Ruiz 201911913
	
	Repetir
		//menu
		Repetir
			Escribir "***************************************"
			Escribir "Digite el numero segun la opcion desada"
			Escribir "         1 = Agresar Materia "
			Escribir "   2 = Ver Promedio    3 = SALIR  "
			Escribir "***************************************"
			Leer Menu913
			Escribir ""
			Escribir ""
		Hasta Que Menu913 > 0 Y Menu913 < 4
		
		//Agregar Materia
		Si Menu913 = 1 Entonces
			Escribir " Ingrese los creditos de la asignatura"
			Leer Creditos913
			Escribir "Ingrese el numero de notas que tiene la asignatura"
			Leer Nunotas913
			Notafinal913 <- 0
			Para contador913<-1 Hasta Nunotas913 
				Repetir
					Escribir  "Ingrese la nota # "  contador913 " CON punto decimal (0.0)"
					leer Nota913
				Hasta Que Nota913 < 5.1
				Escribir  "Ingrese el porcentaje de la nota # " contador913
				Leer  Porcentaje913
				Notafinal913 <- Notafinal913 + (Nota913 * (Porcentaje913 / 100))
			Fin Para
			
			//aprobo 0 Reprobo
			Si Notafinal913 < 3.0 Entonces
				Reprobo913 <- Reprobo913 + 1
			SiNo
				Aprobo913 <- Aprobo913 + 1
			FinSi
			
			Notafinal913 <- Notafinal913 * Creditos913
			CreditosTotales913<- CreditosTotales913 + Creditos913
			notaAcum913<- notaAcum913 + Notafinal913
			
		Fin Si
		
		//Ver Promedio
		Si Menu913 = 2 Entonces
			Escribir "*************************************************"
			PromedioAcum913<- notaAcum913 / CreditosTotales913
			Escribir "El promedio acumulado del estudiante es:" PromedioAcum913
			Escribir "El Estudiantes Aprobo " Aprobo913 " asignaturas "
			Escribir "El Estudiantes Reprobo " Reprobo913 " asignaturas "
			Escribir "*************************************************"
			si PromedioAcum913 < 3.0 Entonces
				Escribir "El estudiante se encuenta en Situación en PELIGRO "
			FinSi
			si PromedioAcum913 > 2.9 Entonces
				Escribir "El estudiante se encuenta en Situación en NORMAL "
			FinSi
			si PromedioAcum913 > 4.1 Entonces
				Escribir "El estudiante se encuenta en Situación en EXCELENTE "
			FinSi
			
			Escribir "*************************************************"
			Escribir " "
		Fin Si
		
	Hasta Que Menu1 = 3
	
FinAlgoritmo
