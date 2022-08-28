Algoritmo Parque_de_atracciones
	//entradas
	Escribir "Digite la edad que tiene "
	Leer edad
	Escribir "Digita valor numerico de la estatura que tiene en centimetros"
	Leer estatura
	Repetir
		Escribir " Pase de entrada comprado "
		Escribir "1= Bronce  2= plata  3= oro"
		Leer pase
	Hasta Que pase=1 o pase=2 o pase=3

	valorcarros <-1000
	valorrueda <-4000
	valorcarrusel <-2000
	valorcastillo <-4000
	valorarca <-3000
	
	Opcionentrada<-1
	
	//comprobacion si tiene edad minima para ingresar alguna atraccion
	Si estatura<130 y edad<8 Entonces
		Escribir "********************************************************************************"
		Escribir "     No tienes ESTATURA ni EDAD para ingresar a ninguna de nuestras atraciones"
		Escribir "             No puedes hacer uso de nuestras atraciones"
		Escribir "Te invitamos a que solo camines y explores el parque por la compra del Bracalete"
		Escribir "********************************************************************************"
		Opcionentrada<-2
	SiNo
		Si estatura<130 Entonces
			Escribir "********************************************************************************"
			Escribir "     No tienes ESTATURA para ingresar a ninguna de nuestras atraciones"
			Escribir "             No puedes hacer uso de nuestras atraciones"
			Escribir "Te invitamos a que solo camines y explores el parque por la compra del Bracalete"
			Escribir "********************************************************************************"
			Opcionentrada<-2
		SiNo
			Si edad<8 Entonces
				Escribir "********************************************************************************"
				Escribir "        No tienes la EDAD para ingresar a ninguna de nuestras atraciones"
				Escribir "                  No puedes hacer uso de nuestras atraciones"
				Escribir "Te invitamos a que solo camines y explores el parque por la compra del Bracalete"
				Escribir "********************************************************************************"
				Opcionentrada<-2
			Fin Si
		Fin Si
	Fin Si
	
	//calculo de juegos al entrar al parque 
	Mientras Opcionentrada=1 Hacer
		njuego <- njuego +1
		Escribir "Juego N° " njuego " vas a entrar"
		
		Repetir
			Escribir "1= carros chocones  2= ruedas volantes   3= carrusel"
			Escribir "4= castillo del terror  5= Arca"
			Leer juego
		Hasta Que juego=1 o juego=2 o juego=3 o juego=4 o juego=5

			
		Si pase=1 Entonces
			Si juego = 2 o juego = 4 o juego = 5 Entonces
				Escribir "No tienes acceso a esa atraccion por ende se te a expulsado"
				Opcionentrada<-2
			SiNo
				Si juego = 1 Entonces
					Si edad > 8 y estatura>130 Entonces
						carros <- carros + 1
						sumacarros <- sumacarros + valorcarros
					SiNo
						Escribir "No cumples con lo requisitos menimos para entrar"
					FinSi
				SiNo
					Si juego = 3 Entonces
						Si edad > 10 y estatura>150 Entonces
							carrusel <- carrusel + 1
							sumacarrusel <- sumacarrusel + valorcarrusel
						SiNo
							Escribir "No cumples con lo requisitos menimos para entrar"
						FinSi
					Fin Si
				Fin Si
			Fin Si
		Fin Si
		Si pase=2 Entonces
			Si juego = 4 o juego = 5 Entonces
				Escribir "No tienes acceso a esa atraccion por ende se te a expulsado"
				Opcionentrada<-2
			SiNo
				Si juego=1 Entonces
					Si edad > 8 y estatura>130 Entonces
						carros <- carros + 1
						sumacarros <- sumacarros + valorcarros
					SiNo
						Escribir "No cumples con lo requisitos menimos para entrar"
					FinSi
				SiNo
					Si juego=2 Entonces
						Si edad > 15 y estatura>170 Entonces
							rueda <- rueda + 1
							sumarueda <- sumarueda + valorrueda
						SiNo
							Escribir "No cumples con lo requisitos menimos para entrar"
						FinSi
					SiNo
						Si juego=3 Entonces
							Si edad > 10 y estatura>150 Entonces
								carrusel <- carrusel + 1
								sumacarrusel <- sumacarrusel + valorcarrusel
							SiNo
								Escribir "No cumples con lo requisitos menimos para entrar"
							FinSi
						Fin Si	
					Fin Si		
				Fin Si
			Fin Si	
		Fin Si	
		
		Si pase=3 Entonces
			Si juego=1 Entonces
				Si edad > 8 y estatura>130 Entonces
					carros <- carros + 1
					sumacarros <- sumacarros + valorcarros
				SiNo
					Escribir "No cumples con lo requisitos menimos para entrar"
				FinSi
			SiNo
				Si juego=2 Entonces
					Si edad > 15 y estatura>170 Entonces
						rueda <- rueda + 1
						sumarueda <- sumarueda + valorrueda
					SiNo
						Escribir "No cumples con lo requisitos menimos para entrar"
					FinSi
				SiNo
					Si juego=3 Entonces
						Si edad > 10 y estatura>150 Entonces
							carrusel <- carrusele + 1
							sumacarrusel <- sumacarrusel + valorcarrusel
						SiNo
							Escribir "No cumples con lo requisitos menimos para entrar"
						FinSi
					SiNo
						Si juego=4 Entonces
							Si edad > 16 y estatura>150 Entonces
								castillo <- castillo + 1
								sumacastillo <- sumacastillo + valorcastillo
							SiNo
								Escribir "No cumples con lo requisitos menimos para entrar"
							FinSi
						SiNo
							Si juego=5 Entonces
								Si edad > 13 y estatura>160 Entonces
									arca <- arca + 1
									sumaarca <- sumaarca + valorarca
								SiNo
									Escribir "No cumples con lo requisitos menimos para entrar"
								FinSi
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
		Fin Si
		
		si Opcionentrada=1 Entonces
			Repetir
				Escribir "********************************************************"
				Escribir "           Quieres entrar a otra atraccion"
				Escribir "       DIJITE EL NUMERO SEGUN SU PREFERENCIA"
				Escribir "1= SI queiro entar       2= NO, Terminar y ver Total " 
				Escribir "********************************************************"
				Leer Opcionentrada
				Escribir "    "
			Hasta Que Opcionentrada=1 o Opcionentrada=2
		FinSi
		
	Fin Mientras
	
	subtotalapagar <- sumacarros+sumarueda+sumacarrusel+sumacastillo+sumaarca
	si edad<14 Entonces
		totalapagar <- subtotalapagar- (subtotalapagar*0.30)
		Descuento <- subtotalapagar-totalapagar
	SiNo
		si edad>14 y edad<18 Entonces
			totalapagar <- subtotalapagar- (subtotalapagar*0.15)
			Descuento <- subtotalapagar-totalapagar
		SiNo
			totalapagar <- subtotalapagar
		FinSi
	FinSi
	
	Escribir "******************************************************************"
	Escribir "******************************************************************"
	Escribir "Usted uso la traccion Carritos chocones: " carros " veces"
	Escribir "Carritos chocones: $" sumacarros
	Escribir "Usted uso la traccion Rueda volante: " rueda " veces"
	Escribir "Rueda volante: $" sumarueda
	Escribir "Usted uso la traccion Carrusel: " carrusel " veces"
	Escribir "Carrusel: $" sumacarrusel
	Escribir "Usted uso la traccion Castillo del terror: " castillo " veces"
	Escribir "Castillo del terror: $" sumacastillo
	Escribir "Usted uso la traccion Arca: " arca " veces"
	Escribir "Arca: $" sumaarca 
	escribir "Su descuento es de: $" Descuento
	Escribir "El total a pagar dado tu recorrido es: $" totalapagar
	Escribir "******************************************************************"
	Escribir "******************************************************************"
FinAlgoritmo
