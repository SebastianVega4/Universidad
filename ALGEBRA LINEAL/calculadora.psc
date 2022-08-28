Algoritmo Calculadora_de_dos_numeros
	
	inicio<-1
	Mientras inicio = 1 Hacer
		Escribir "Digite primer numero"
		Leer primerd
		Escribir "Digite segundo numero"
		Leer segundod
		
		Repetir
			Escribir "       DIJITE EL NUMERO SEGUN SU PREFERENCIA"
			Escribir "1= sumar   2= restar   3= multiplicar  4= dividir"
			
			Leer operacion
		Hasta Que operacion=1 o operacion=2 o operacion=3 o operacion=4
		Si operacion=1 Entonces
			Resultado<-primerd+segundod
		SiNo
			Si operacion=2 Entonces
				Resultado<-primerd-segundod
			SiNo
				Si operacion=3 Entonces
					Resultado<-primerd*segundod
				SiNo
					Si operacion=4 Entonces
						Resultado<-primerd/segundod
					Fin Si
				Fin Si
			Fin Si
		Fin Si
		
		Repetir
			Escribir "********************************************************"
			Escribir "   El resultado de la operacion es " Resultado
			Escribir "********************************************************"
			Escribir "       DIJITE EL NUMERO SEGUN SU PREFERENCIA"
			Escribir "       ¿Desea realizar una nueva operacion? "
			Escribir "        1=si                    2= Apagar"
			Escribir "********************************************************"
			Leer inicio
			Escribir "    "
		Hasta Que inicio=1 o inicio=2
	Fin Mientras
	
	
FinAlgoritmo
