Algoritmo Parcial_2
	//entrada
	Escribir "Que distacia tiene su vuelo (viaje)"
	Leer distanciavuelo
	
	//Clase que adquirio
	Repetir
		Escribir "         Que clase Usted adquirio"
		Escribir "1= Ejecutiva   2= presidencial   3= Primera clase"
		Leer clase
	Hasta Que clase=1 o clase=2 o clase=3
	
	//variables definidas
	valejecutiva<-5000
	valpresidelcial<-15000
	valprimeraclase<-10000
	
	valbebidas<-1000
	valcomidas<-4000
	vallecturas<-2000
	valentretenimiento<-4000
	valacomodacion<-3000
	
	numbebidas<-0
	numcomidas<-0
	numlecturas<-0
	numentretenimineto<-0
	numacomodacion<-0
	
	//si desea o no un servicio durante todo el viaje
	Repetir
		Escribir "Desea Usar algun servicio durante su viaje"
		Escribir "   1= si      2=no"
		Leer peticion1
	Hasta Que peticion1=1 o peticion1=2
	Si peticion1=1 Entonces
		peticion2 <- 1
	Fin Si
	
	//mientras quiera algun servicio hacer
	Mientras peticion2=1 Hacer
		Repetir
			Escribir "  Que servicio desea adquirir "
			Escribir "1=Bebida   2=Comida   3=Lectura"
			Escribir "4=Entretenimiento  5=Acomodacion"
			Leer tipservicio
		Hasta Que tipservicio=1 o tipservicio=2 o tipservicio=3 o tipservicio=4 o tipservicio=5
		
		//clase ejecutiva
		Si clase=1 Entonces
			//Bebidas
			Si tipservicio=1  Entonces
				Si distanciavuelo>100 Entonces
					Numsolibebida <-Numsolibebida+1
					Si Numsolibebida>4 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserbe<-suptotalserbe+valbebidas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//comida
			Si tipservicio=2  Entonces
				Si distanciavuelo>310 Entonces
					Numsolicomida <- Numsolicomida+1
					Si Numsolicomida>0 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalsercomi<-suptotalsercomi+valcomidas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Lactura
			Si tipservicio=3  Entonces
				Si distanciavuelo>130 Entonces
					Numsolilectura <- Numsolilectura+1
					Si Numsolilectura>0 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserlect<-suptotalserlect+vallecturas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Entretenimineto
			Si tipservicio=4  Entonces
				Si distanciavuelo>400 Entonces
					Numsolientretenimiento <- Numsolientretenimiento+1
					Si Numsolientretenimiento>0 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserentre<-suptotalserentre+valentretenimiento
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Acomodacion
			Si tipservicio=5  Entonces
				Si distanciavuelo>250 Entonces
					Numsoliacomodacion <- Numsoliacomodacion+1
					Si Numsoliacomodacion>3 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalseracomo<-suptotalseracomo+valacomodacion
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
		Fin Si
		
		//clase presidencial
		Si clase=2 Entonces
			//Bebidas
			Si tipservicio=1  Entonces
				Si distanciavuelo>100 Entonces
					Numsolibebida <-Numsolibebida+1
					Si Numsolibebida>4 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserbe<-suptotalserbe+valbebidas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//comida
			Si tipservicio=2  Entonces
				Si distanciavuelo>310 Entonces
					Numsolicomida <- Numsolicomida+1
					Si Numsolicomida>2 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalsercomi<-suptotalsercomi+valcomidas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Lactura
			Si tipservicio=3  Entonces
				Si distanciavuelo>130 Entonces
					Numsolilectura <- Numsolilectura+1
					Si Numsolilectura>4 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserlect<-suptotalserlect+vallecturas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Entretenimineto
			Si tipservicio=4  Entonces
				Si distanciavuelo>400 Entonces
					Numsolientretenimiento <- Numsolientretenimiento+1
					Si Numsolientretenimiento>1 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserentre<-suptotalserentre+valentretenimiento
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Acomodacion
			Si tipservicio=5  Entonces
				Si distanciavuelo>250 Entonces
					Numsoliacomodacion <- Numsoliacomodacion+1
					Si Numsoliacomodacion>3 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalseracomo<-suptotalseracomo+valacomodacion
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
		Fin Si
		
		//Primera clase
		Si clase=3 Entonces
			//Bebidas
			Si tipservicio=1  Entonces
				Si distanciavuelo>100 Entonces
					Numsolibebida <-Numsolibebida+1
					Si Numsolibebida>4 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserbe<-suptotalserbe+valbebidas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//comida
			Si tipservicio=2  Entonces
				Si distanciavuelo>310 Entonces
					Numsolicomida <- Numsolicomida+1
					Si Numsolicomida>0 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalsercomi<-suptotalsercomi+valcomidas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Lactura
			Si tipservicio=3  Entonces
				Si distanciavuelo>130 Entonces
					Numsolilectura <- Numsolilectura+1
					Si Numsolilectura>4 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserlect<-suptotalserlect+vallecturas
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Entretenimineto
			Si tipservicio=4  Entonces
				Si distanciavuelo>400 Entonces
					Numsolientretenimiento <- Numsolientretenimiento+1
					Si Numsolientretenimiento>0 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalserentre<-suptotalserentre+valentretenimiento
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
			//Acomodacion
			Si tipservicio=5  Entonces
				Si distanciavuelo>250 Entonces
					Numsoliacomodacion <- Numsoliacomodacion+1
					Si Numsoliacomodacion>3 Entonces
						Escribir "Se le adicionara a su factura"
						suptotalseracomo<-suptotalseracomo+valacomodacion
					Fin Si
				SiNo
					Escribir "No cuentas con la distancia minima necesaria"
				Fin Si
			Fin Si
		Fin Si
		
		Repetir
			Escribir "*********************************"
			Escribir "  Desea adquirir otro servicio"
			Escribir "     1=Si       2=NO  "
			Escribir "*********************************"
			Leer peticion2
			Escribir "   "
		Hasta Que peticion2=1 o peticion2=2
	FinMientras
	
	subtotalfactura <- suptotalserbe+suptotalsercomi+suptotalserlect+suptotalserentre+suptotalseracomo
	
	Escribir "****************************************************************************"
	Escribir "****************************************************************************"
	
	//impuesto a clase ejecutiva
	Si clase=1 Entonces
		subtotalfactura <- subtotalfactura+valejecutiva
		totalfactura<-subtotalfactura+(subtotalfactura*0.10)
		Escribir "       Es valor del tiquete adquirido es: $" valejecutiva
		Escribir "        El impuesto aplicado es: $:" (subtotalfactura*0.10)
	Fin Si
	
	//impuesto a clase Presidencial
	Si clase=2 Entonces
		subtotalfactura <- subtotalfactura+valpresidelcial
		totalfactura<-subtotalfactura+(subtotalfactura*0.19)
		Escribir "       Es valor del tiquete adquirido es: $" valpresidelcial
		Escribir "         El impuesto aplicado es: $:" (subtotalfactura*0.19)
	Fin Si
	
	//impuesto a Primera clase
	Si clase=3 Entonces
		subtotalfactura <- subtotalfactura+valprimeraclase
		totalfactura<-subtotalfactura+(subtotalfactura*0.16)
		Escribir "       Es valor del tiquete adquirido es: $" valprimeraclase
		Escribir "         El impuesto aplicado es: $:" (subtotalfactura*0.16)
	Fin Si
	
	

	Escribir "Usted adquirio el servicio de Bebidas " Numsolibebida " veces"
	Escribir "          Es quivalente a: $" suptotalserbe
	Escribir "Usted adquirio el servicio de Comida " Numsolicomida " veces"
	Escribir "          Es quivalente a: $" suptotalsercomi
	Escribir "Usted adquirio el servicio de Lactura " Numsolilectura " veces"
	Escribir "          Es quivalente a: $" suptotalserlect
	Escribir "Usted adquirio el servicio de Entretenimiento Multimedia " Numsolientretenimiento " veces"
	Escribir "          Es quivalente a: $" suptotalserentre
	Escribir "Usted adquirio el servicio de Acomodacion " Numsoliacomodacion " veces"
	Escribir "          Es quivalente a: $" suptotalseracomo
	Escribir "El valor total de la factura es: $:" totalfactura
	Escribir "****************************************************************************"
	Escribir "****************************************************************************"
	
FinAlgoritmo
