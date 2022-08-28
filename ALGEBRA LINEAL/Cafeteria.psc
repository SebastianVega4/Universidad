Algoritmo Cafeteria
	
	//4 Depositos 
	//1 cafe 250gr, 1 milo 250gr, 1 leche 2 litros, 1 agua de 2 litros
	// c/u deposito exite porcion minima
	//bebidas a servir
	//cafe: 30gr de cafe y 100% de agua $3000
	//latte: 15gr de cafe 80% leche y 20% agua $5000
	//expreso: 50gr de cafe y 100% de agua
	//milo: 40gr de milo 90% leche y 10% agua
	
	valcafe<-3000
	vallatte<-5000
	valexpreso<-7000
	valmilo<-4000
	
	vasopequeño<-120
	vasomediano<-210
	vasogrande<-350
	
	opciones<-1
	Mientras opciones=1 Hacer
		Escribir "Cuantas Bebidas va a comprar"
		Leer Nbebidas
		
		//si vuelve a toomar mas cafes se rellena los depositos
		//y se acumula los gramos y litros grastados ya que se vacian y se  llenan desde 0
		depcafe<-250
		depmilo<-250
		depleche<-2000
		depagua<-2000
		
		gramototalcafe<-gramototalcafe+depcafe
		gramototalmilo<-gramototalmilo+depmilo
		litrototalleche<-litrototalleche+depleche
		litrototalagua<-litrototalagua+depagua
		
		
		
		Para conteo <-1 Hasta Nbebidas Con Paso 1 Hacer
			
			Repetir
				Escribir "Bebida N° " conteo " que va a tomar"
				Escribir "1= Cafe       2= Latte "
				Escribir "3= Expresso   4= Milo"
				Leer bebidaatomar
			Hasta Que bebidaatomar=1 o bebidaatomar=2 o bebidaatomar=3 o bebidaatomar=4
			
			repetir 
				Escribir "           Que recipiente desea "
				Escribir "1= Pequeño 120ml  2= Medino 210ml   3= Grande 350ml"
				Leer TamañoVaso
			Hasta Que  TamañoVaso=1 o TamañoVaso=2 o TamañoVaso=3
			
			//Si la bebida es Cafe
			Si depcafe<30 Entonces
				Escribir "Su CAFE no se puede despachar por falta de gr en el deposito de cafe"
				Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
				conteo <-Nbebidas
			SiNo
				Si bebidaatomar=1 Entonces
					Si TamañoVaso=1 Entonces
						Si depagua>vasopequeño Entonces
							depcafe <-depcafe-30
							depagua <-depagua-vasopequeño
							cafe<-cafe+1
							valtolcafe<-valtolcafe+valcafe
						SiNo
							Escribir "Su CAFE no se puede despachar por falta de ml en el deposito de agua"
							Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
							conteo <-Nbebidas
						Fin Si
					SiNo
						Si TamañoVaso=2 Entonces
							Si depagua>vasomediano Entonces
								depcafe <-depcafe-30
								depagua <-depagua-vasomediano
								cafe<-cafe+1
								valtolcafe<-valtolcafe+valcafe
							SiNo
								Escribir "Su CAFE no se puede despachar por falta de ml en el deposito de agua"
								Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
								conteo <-Nbebidas
							Fin Si
						SiNo
							Si TamañoVaso=3 Entonces
								Si depagua>vasogrande Entonces
									depcafe <-depcafe-30
									depagua <-depagua-vasogrande
									cafe<-cafe+1
									valtolcafe<-valtolcafe+valcafe
								SiNo
									Escribir "Su CAFE no se puede despachar por falta de ml en el deposito de agua"
									Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
									conteo <-Nbebidas
								Fin Si
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
			
			
			//Si la bebida es Latte
			Si depcafe<15 Entonces
				Escribir "Su LATTE no se puede despachar por falta de gr en el deposito de cafe"
				Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
				conteo <-Nbebidas
			SiNo
				Si bebidaatomar=2 Entonces
					Si TamañoVaso=1 Entonces
						Si vasopequeño*0.80<depleche o vasopequeño*0.20<depagua Entonces
							depcafe <-depcafe-15
							depleche <-depleche-(vasopequeño*0.80)
							depagua <-depagua-(vasopequeño*0.20)
							latte<-latte+1
							valtollatte<-valtollatte+vallatte
						SiNo
							Escribir "Su LATTE no se puede despachar por falta de ml en el deposito de leche o agua"
							Escribir "   Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
							conteo <-Nbebidas
						Fin Si
					SiNo
						Si TamañoVaso=2 Entonces
							Si vasomediano*0.80<depleche o vasomediano*0.20<depagua Entonces
								depcafe <-depcafe-15
								depleche <-depleche-(vasomediano*0.80)
								depagua <-depagua-(vasomediano*0.20)
								latte<-latte+1
								valtollatte<-valtollatte+vallatte
							SiNo
								Escribir "Su LATTE no se puede despachar por falta de ml en el deposito de leche o agua"
								Escribir "     Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
								conteo <-Nbebidas
							Fin Si
						SiNo
							Si TamañoVaso=3 Entonces
								Si vasogrande*0.80<depleche o vasogrande*0.20<depagua Entonces
									depcafe <-depcafe-15
									depleche <-depleche-(vasogrande*0.80)
									depagua <-depagua-(vasogrande*0.20)
									latte<-latte+1
									valtollatte<-valtollatte+vallatte
								SiNo
									Escribir "Su LATTE no se puede despachar por falta de ml en el deposito de leche o agua"
									Escribir "    Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
									conteo <-Nbebidas
								Fin Si
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
			
			
			//Si la bebida es el Expreso
			Si depcafe<50 Entonces
				Escribir "Su EXPRESO no se puede despachar por falta de gr en el deposito de cafe"
				Escribir "  Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
				conteo <-Nbebidas
			SiNo
				Si bebidaatomar=3 Entonces
					Si TamañoVaso=1 Entonces
						Si depagua>vasopequeño Entonces
							depcafe <-depcafe-50
							depagua <-depagua-vasopequeño
							expreso<-expreso+1
							valtolexpreso<-valtolexpreso+valexpreso
						SiNo
							Escribir "Su EXPRESO no se puede despachar por falta de ml en el deposito de agua"
							Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
							conteo <-Nbebidas
						Fin Si
					SiNo
						Si TamañoVaso=2 Entonces
							Si depagua>vasomediano Entonces
								depcafe <-depcafe-50
								depagua <-depagua-vasomediano
								expreso<-expreso+1
								valtolexpreso<-valtolexpreso+valexpreso
							SiNo
								Escribir "Su EXPRESO no se puede despachar por falta de ml en el deposito de agua"
								Escribir "  Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
								conteo <-Nbebidas
							Fin Si
						SiNo
							Si TamañoVaso=3 Entonces
								Si depagua>vasogrande Entonces
									depcafe <-depcafe-50
									depagua <-depagua-vasogrande
									expreso<-expreso+1
									valtolexpreso<-valtolexpreso+valexpreso
								SiNo
									Escribir "Su EXPRESO no se puede despachar por falta de ml en el deposito de agua"
									Escribir "  Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
									conteo <-Nbebidas
								Fin Si
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
			
			
			//Si la bebida es Milo
			Si depmilo<40 Entonces
				Escribir "Su MILO no se puede despachar por falta de gr en el deposito de milo"
				Escribir " Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
				conteo <-Nbebidas
			SiNo
				Si bebidaatomar=4 Entonces
					Si TamañoVaso=1 Entonces
						Si vasopequeño*0.90<depleche o vasopequeño*0.10<depagua Entonces
							depmilo <-depmilo-40
							depleche <-depleche-(vasopequeño*0.90)
							depagua <-depagua-(vasopequeño*0.10)
							milo<-milo+1
							valtolmilo<-valtolmilo+valmilo
						SiNo
							Escribir "Su MILO no se puede despachar por falta de ml en el deposito de leche o agua"
							Escribir "  Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
							conteo <-Nbebidas
						Fin Si
					SiNo
						Si TamañoVaso=2 Entonces
							Si vasomediano*0.90<depleche o vasomediano*0.10<depagua Entonces
								depmilo <-depmilo-40
								depleche <-depleche-(vasomediano*0.90)
								depagua <-depagua-(vasomediano*0.10)
								milo<-milo+1
								valtolmilo<-valtolmilo+valmilo
							SiNo
								Escribir "Su MILO no se puede despachar por falta de ml en el deposito de leche o agua"
								Escribir "   Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
								conteo <-Nbebidas
							Fin Si
						SiNo
							Si TamañoVaso=3 Entonces
								Si vasogrande*0.90<depleche o vasogrande*0.10<depagua Entonces
									depmilo <-depmilo-40
									depleche <-depleche-(vasogrande*0.90)
									depagua <-depagua-(vasogrande*0.10)
									milo<-milo+1
									valtolmilo<-valtolmilo+valmilo
								SiNo
									Escribir "Su MILO no se puede despachar por falta de ml en el deposito de leche o agua"
									Escribir "   Vamos a llenar los depositos he ingrese cuantas bebidas le faltan"
									conteo <-Nbebidas
								Fin Si
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
			
			
		Fin Para
		//Deposito se vacia despues de servir las bebidas
		depcafe<-0
		depmilo<-0
		depleche<-0
		depagua<-0
		
		Repetir
			Escribir "********************************************************"
			Escribir "       DIJITE EL NUMERO SEGUN SU PREFERENCIA"
			Escribir "1= desea tomar mas cafes   2= desea tomar el total"
			Escribir "********************************************************"
			Leer opciones
			Escribir "    "
		Hasta Que opciones=1 o opciones=2
	FinMientras
	
	Valortotal <-valtolcafe+valtolmilo+valtollatte+valtolexpreso
	Valortotcafescomp <-cafe+milo+latte+expreso
	litrototalleche<-litrototalleche/1000
	litrototalagua<-litrototalagua/1000
	
	Escribir "********************************************************"
	Escribir "********************************************************"
	Escribir "     El valor por totoal los Cafes pedidos es: $" valtolcafe
	Escribir "     El valor por totoal los Lattes pedidos es: $" valtollatte
	Escribir "     El valor por totoal los Expresos pedidos es: $" valtolexpreso
	Escribir "     El valor por totoal los Milos pedidos es: $" valtolmilo
	Escribir "     Usted compro " Valortotcafescomp " cafes "
	Escribir "     El valor Total a pagar es: $" Valortotal
	Escribir "********************************************************"
	Escribir "     Hasta el momento se han comprado " cafe " Cafes "
	Escribir "     Equibalentes a: $" valtolcafe
	Escribir "     Hasta el momento se han comprado " latte " Lattes "
	Escribir "     Equibalentes a: $" valtollatte
	Escribir "     Hasta el momento se han comprado " expreso " Expresos "
	Escribir "     Equibalentes a: $" valtolexpreso
	Escribir "     Hasta el momento se han comprado " milo " Milos "
	Escribir "     Equibalentes a: $" valtolmilo
	Escribir "     Se agrego " gramototalcafe " Gramos de Cafe "
	Escribir "     Se agrego " gramototalmilo " Gramos de Milo "
	Escribir "     Se agrego " litrototalleche " litros de Leche "
	Escribir "     Se agrego " litrototalagua " litros de Agua "
	Escribir "********************************************************"
	Escribir "********************************************************"
	
FinAlgoritmo
