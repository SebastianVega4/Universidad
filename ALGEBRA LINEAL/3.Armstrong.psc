Algoritmo Armstrong
	
	//Johan Sebastian Vega Ruiz 201911913
	Escribir "Dijite el numero a comprobar si es Armstrong "
	Leer Num
	
	divisor <- 0
    Contador <- 1
	dijitos <- 1
	Numm <- Num
	ciclo <- 1
	
	Mientras divisor = 0 Hacer			
		Si Num > (Contador * 10) Entonces
			Contador <- Contador * 10
			dijitos <- dijitos + 1
		SiNo
			divisor <- 1
		Fin Si				
	Fin Mientras
	

	Si Dijitos > 9 Entonces
		Escribir "Error Numero no calculable"
	SiNo
		Repetir
			Si contador0 = 0 Entonces
				Digito1 <- trunc(num / contador)
				contador0 <- 1
			SiNo
				Si contador1 = 0 Entonces
					Digito2 <- trunc(num / contador)
					Restar <- Digito1 *10
					Digito2 <- Digito2 - Restar
					contador1 <- 1
				SiNo
					Si contador2 = 0 Entonces
						Digito3 <- trunc(num / contador)
						Restar <- Digito1 *100 + Digito2 *10
						Digito3 <- Digito3 - Restar
						contador2 <- 1
					SiNo
						Si contador3 = 0 Entonces
							Digito4 <- trunc(num / contador)
							Restar <- Digito1 *1000 + Digito2 *100 + Digito3 *10
							Digito4 <- Digito4 - Restar
							contador3 <- 1
						SiNo
							Si contador4 = 0 Entonces
								Digito5 <- trunc(num / contador)
								Restar <- Digito1 *10000 + Digito2 *1000 + Digito3 *100 + Digito4 *10 
								Digito5 <- Digito5 - Restar
								contador4 <- 1
							SiNo
								Si contador5 = 0 Entonces
									Digito6 <- trunc(num / contador)
									Restar <- Digito1 *100000 + Digito2 * 10000 + Digito3 *1000 + Digito4 *100 + Digito5 *10
									Digito6 <- Digito6 - Restar
									contador5 <- 1
								SiNo
									Si contador6 = 0 Entonces
										Digito7 <- trunc(num / contador)
										Restar <- Digito1 *1000000 + Digito2 *100000 + Digito3 *10000 + Digito4 *1000 + Digito5 *100 + Digito6 *10
										Digito7 <- Digito7 - Restar
										contador6 <- 1
									SiNo
										Si contador7 = 0 Entonces
											Digito8 <- trunc(num / contador)
											Restar <- Digito1 *10000000 + Digito2 *1000000 + Digito3 *100000 + Digito4 *10000 + Digito5 *1000 + Digito6 *100 + Digito7 *10
											Digito8 <- Digito8 - Restar
											contador7 <- 1
										Fin Si
									Fin Si
								Fin Si
							Fin Si	
						Fin Si
					Fin Si
				Fin Si
			Fin Si
			Contador <- Contador / 10
			ciclo <- ciclo + 1
		Hasta Que ciclo = dijitos + 1
	Fin Si
	
	sumDigito1 <- Digito1 ^ dijitos
	sumDigito2 <- Digito2 ^ dijitos
	sumDigito3 <- Digito3 ^ dijitos
	sumDigito4 <- Digito4 ^ dijitos
	sumDigito5 <- Digito5 ^ dijitos
	sumDigito6 <- Digito6 ^ dijitos
	sumDigito7 <- Digito7 ^ dijitos
	sumDigito8 <- Digito8 ^ dijitos
	sumTotal <- sumDigito1+sumDigito2+sumDigito3+sumDigito4+sumDigito5+sumDigito6+sumDigito7+sumDigito8
	
	
	Escribir "***********************************"
	Si sumTotal = Num Entonces
		Escribir " El numero " Num " SI es Armstrong "
	SiNo
		Escribir " El numero " Num " NO es Armstrong "
	Fin Si
	Escribir "***********************************"
	
	
FinAlgoritmo
