Algoritmo Taxi
	//Johan Sebastian Vega Ruiz 201911913
	
	Menu <- 1 
	Repetir
		
		TipoServicio <- 0
		Subtotal<- 0 
		
		si Menu = 1 Entonces
			
			Subtotal<- 0
			
			
			Escribir "Digite el valor por min del modelo de taxi elegido "
			Leer ValMinuto
			
			Repetir
				Escribir "******************************************************"
				Escribir "Digite el numero correspondiente al Servicio a Contratar"
				Escribir "       1= Transporte publico  2= Domicilio"
				Escribir "******************************************************"
				Leer TipoServicio
				Escribir " "
			Hasta Que TipoServicio=1 o TipoServicio=2
		FinSi
		
		//seguro en domicilio
		Si TipoServicio=2 Entonces
			Repetir
				Escribir "Dijite el peso en KG del Articulo a enviar "
				Leer ValKg
				Escribir "*********************************************"
				Escribir " Quiere comprar el seguro a de su domisilio "
				Escribir "      tiene un valor de 50000 $ "
				Escribir "         1=SI        2=NO"
				Escribir "*********************************************"
				Leer seguro
			Hasta Que seguro=1 o seguro=2
		FinSi
		
		si Menu = 1 Entonces
			Escribir "Digite Cuanto tiempo(minutos) duro el trayecto"
			Leer minutos
		FinSi
		
		//Operaciones Trasporte publico
		Si TipoServicio=1 Entonces
			Subtotal <- ValMinuto * minutos
			Total <- Total + Subtotal
			seviciostotales <- seviciostotales + 1
			Serviciotraspote <- Serviciotraspote + 1
		FinSi
		
		//Operaciones Domicilio
		Si TipoServicio=2 Entonces
			Subtotal <- 1000 * ValKg
			Subtotal <- Subtotal + (ValMinuto * minutos)
			ServicioDomicilio <- ServicioDomicilio + 1
			seviciostotales <- seviciostotales + 1
			si seguro = 1 Entonces
				Subtotal <- Subtotal + 50000
			FinSi
			Total <- Total + Subtotal
		FinSi
		
		// Historial
		Si Menu = 2 Entonces
			Escribir "*******************************************"
			Escribir "Hasta el Momento de han realizado : " seviciostotales " Servicios "
			Escribir "Servicios De Trasporte Publico : " Serviciotraspote
			Escribir "Servicios A Domicilio : " ServicioDomicilio
			Escribir "Se ha recaudado un total de : " Total " $"
			Escribir "********************************************"
		FinSi
		
		//Total apagar por el usurio
		Si Menu = 1 Entonces
			Escribir " "
			Escribir " "
			Escribir "********************************************"
			//Traspote publico 
			Si TipoServicio=1 Entonces
				Escribir "      Servicio de Transporte publico"
				Escribir "           Tiempo de trayecto : " minutos " Min "
			FinSi
			//Domicilio
			Si TipoServicio=2 Entonces
				Escribir "     Servicio de Domicilio"
				Escribir "      Tiempo de trayecto : " minutos
				Si seguro=1 Entonces
					Escribir "     Segurpo de domicilio : 50000 $"
				FinSi
			FinSi
			
			Escribir "********************************************"
			Escribir "          Total a Pagar : " Subtotal " $"
			Escribir "********************************************"
			Escribir " "
		FinSi 
		
		
		//menu
		Repetir
			
			Escribir "***************************************"
			Escribir "Digite el numero segun la opcion desada"
			Escribir "       1 = Hacer otra Carrera "  
			Escribir "     2 = Historial     3= Salir "
			Escribir "***************************************"
			Leer Menu
			Escribir ""
			Escribir ""
		Hasta Que Menu > 0 Y Menu < 4
		
	Hasta Que Menu= 3
	
	
FinAlgoritmo
