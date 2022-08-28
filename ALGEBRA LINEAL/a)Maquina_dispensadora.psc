Algoritmo Maquina_dispensadora
	//Johan Sebastian Vega Ruiz 201911913

	Repetir
		
		DineroDeposi<- 0
		Cambio <- 0
		
		sumacomprobadora <- PapasRisadas+Chocorramo+chocolatina+Gaseosa
		
		Si sumacomprobadora = 0 Entonces
			Escribir "******************************************************"
			Escribir "Quieres abastecer la maquina, no hay existencias"
			Escribir "                1= SI   2 = NO"
			Escribir "******************************************************"
			Leer abastecer
			
			Si abastecer = 1 Entonces
				CantidadPapas <- 10
				CantidadChocorramo <- 10
				CantidadChocolatina <- 10
				CantidadGaseosa <- 10
				Menu<-1
			SiNo
				Menu<-0
			Fin Si
		Fin Si
		
		si Menu = 1 Entonces
			Escribir "Digite el deposito de dinero a hacer"
			Leer DineroDeposi
			
			Repetir
				Escribir "******************************************************"
				Escribir "Digite el numero correspondiente al Producto a elegir"
				Escribir "       1= Papas risadas  " "2= Chocorramo "
				Escribir "       3= Chocolatina   "  "4= Gaseosa"
				Escribir "******************************************************"
				Leer Producto
				Escribir " "
			Hasta Que Producto=1 o Producto=2 o Producto=3 o Producto=4
		FinSi
		
		//Exsistencia
		Si Producto=1 Entonces
			si CantidadPapas < 1 Entonces
			Escribir "No hay existencia de Papas Risadas para compar" 
			Cambio <- DineroDeposi
			Producto <- 0
			FinSi
		FinSi
		
		Si Producto=2 Entonces
			si CantidadChocorramo < 1 Entonces
			Escribir "No hay existencia de Chocorramo para compar" 
			Cambio <- DineroDeposi
			Producto <- 0
			Fin Si
		Fin Si
		
		Si Producto=3 Entonces
			si CantidadChocolatina < 1 Entonces
				Escribir "No hay existencia de Chocolatina para compar" 
				Cambio <- DineroDeposi
				Producto <- 0
			FinSi
		Fin Si		
		
		Si Producto=4 Entonces
			si CantidadGaseosa< 1 Entonces
				Escribir "No hay existencia de Gaseosa para compar" 
				Cambio <- DineroDeposi
				Producto <- 0
			FinSi
		Fin Si
		
		//Operaciones papas risadas
		Si Producto=1 Entonces
			si DineroDeposi<1200 Entonces
				Escribir "El dinero depositado no alcanza para comprar las Papas risadas" 
				Cambio <- DineroDeposi
			SiNo
				PapasRisadas <- PapasRisadas + 1
				CantidadPapas <- CantidadPapas - 1
				Cambio <- DineroDeposi-1200
				
			FinSi
		FinSi
		
		//Operaciones Chocorramo
		Si Producto=2 Entonces
			si DineroDeposi<1500 Entonces
				Escribir "El dinero depositado no alcanza para comprar el Chocorramo" 
				Cambio <- DineroDeposi
				
			SiNo
				Chocorramo <- Chocorramo + 1
				CantidadChocorramo <- CantidadChocorramo - 1
				Cambio <- DineroDeposi-1500
				
			FinSi
		FinSi
		
		//Operaciones chocolatina
		Si Producto=3 Entonces
			si DineroDeposi<500 Entonces
				Escribir "El dinero depositado no alcanza para comprar la Chocolatina " 
				Cambio <- DineroDeposi
				
			SiNo
				chocolatina<- chocolatina + 1
				CantidadChocolatina <- CantidadChocolatina - 1
				Cambio <- DineroDeposi- 500
				
			FinSi
		FinSi
		
		//Operaciones Gaseosa
		Si Producto=4 Entonces
			si DineroDeposi<1850 Entonces
				Escribir "El dinero depositado no alcanza para comprar la Chocolatina " 
				Cambio <- DineroDeposi
				
			SiNo
				Gaseosa <- Gaseosa + 1
				CantidadGaseosa <- CantidadGaseosa - 1
				Cambio <- DineroDeposi-1850
				
			FinSi
		FinSi
		
		//Abastecer
		Si Menu = 2 Entonces
			PapasRisadas <- PapasRisadas + 10
			Chocorramo <-  Chocorramo + 10
			chocolatina <- chocolatina + 10
			Gaseosa <- 10
		FinSi
		
		Si Producto=1 Entonces
			Escribir "***************************************"
			Escribir "   Usted compro unas Papas Risadas "
			Escribir "       Con un valor de 1200 $ "
			Escribir "***************************************"
			
		FinSi
		
		Si Producto=2 Entonces
			Escribir "***************************************"
			Escribir "     Usted compro un Chocorramo "
			Escribir "       Con un valor de 1500 $ "
			Escribir "***************************************"
			
		FinSi
		Si Producto=3 Entonces
			Escribir "***************************************"
			Escribir "      Usted compro un Chocolate "
			Escribir "       Con un valor de 500 $ "
			Escribir "***************************************"
			
		FinSi
		Si Producto=4 Entonces
			Escribir "***************************************"
			Escribir "      Usted compro una Gaseosa "
			Escribir "       Con un valor de 1850 $ "
			Escribir "***************************************"
			
		FinSi
		Si Menu = 1 Entonces
			Escribir "***************************************"
			Escribir "    Su Cambio es :" Cambio " $"
			Escribir "***************************************"
		FinSi
		
		//menu
		Repetir
			
			Escribir "***************************************"
			Escribir "Digite el numero segun la opcion desada"
			Escribir "     1 = Compra   2 = Abastecer "
			Escribir "         3= Apagar(salir)  "
			Escribir "***************************************"
			Leer Menu
			Escribir ""
			Escribir ""
		Hasta Que Menu > 0 Y Menu < 4
		
	Hasta Que Menu= 3
	
FinAlgoritmo
