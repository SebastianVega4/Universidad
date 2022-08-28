Algoritmo alcancia
	//Mtotal total de monedas insertadas,Nmonedas nemero de modenas a ingresar,moneda valor de la moneda ingresada
	Escribir "dijite la cantidad de monedas a ingresar"
	leer Nmonedas
	moneda <- 0
	Para mon<-1  Hasta Nmonedas Con Paso 1 Hacer
		Escribir "valor de la moneda N " mon
		leer moneda
		Si moneda = 50 o moneda = 100 o moneda = 200 o moneda = 500 o moneda = 1000 Entonces
			sumaM<-sumaM+moneda
			Si moneda = 50 Entonces
				M50 <- M50 + 1
			     SiNo
				    Si moneda = 100 Entonces
						M100 <- M100 + 1 
			          SiNo
							Si moneda = 200 Entonces
								M200 <- M200 + 1
								SiNo
									Si moneda = 500 Entonces
										M500 <- M500 + 1
										SiNo
											M1000 <- M1000 + 1
										Fin Si
							Fin Si
					Fin Si
			Fin Si
		SiNo
			escribir "error"
			mon <- mon - 1
		Fin Si
	Fin Para
	Mtotal <- sumaM
	M50total <- M50 * 50
	M100total <- M100 * 100
	M200total <- M200 * 200
	M500total <- M500 * 500
	M1000total <- M1000 * 1000
	Escribir "Usted ingreso un total de  " Mtotal " Pesos"
	Escribir "Valor en cada moneda: "
	Escribir "50 ingreso " M50 " = " M50total
	Escribir "100ingreso " M100 " = " M100total
	Escribir "200 ingreso " M200 " = " M200total
	Escribir "500 ingreso " M500 " = " M500total
	Escribir "1000 ingreso " M1000 " = " M1000total
FinAlgoritmo
