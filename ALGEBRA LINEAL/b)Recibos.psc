Algoritmo Facturas_luz_y_agua
	//Johan Sebastian Vega Ruiz 201911913
	
	inicio<-1
	Mientras inicio=1 Hacer
		Escribir "Digite los litros de agua consumido este mes"
		Leer litros
		
		Escribir "Digite los Kilowatts de energia consumido este mes"
		Leer kiloW
		
		Repetir
			Escribir "Digite el numero correspondiente a la zona facturada del AGUA"
			Escribir "1= Rural  " "2= Urbana  " "3= Industrial"
			Leer zonaa
		Hasta Que zonaa=1 o zonaa=2 o zonaa=3
		
		Repetir
			Escribir "Digite el numero correspondiente a la zona facturada de la LUZ"
			Escribir "1= Rural  " "2= Urbana  " "3= Industrial"
			Leer zonab
		Hasta Que zonab=1 o zonab=2 o zonab=3
		
		//operaciones Agua
		costolitro<-150
		
		Si litros<100 Entonces
			sumatotal <- litros*costolitro
			litrocada<-litros-litros
		SiNo
			sumatotal <- 100*costolitro
			litrocada<-litros-100
		Fin Si
		
		
		Mientras litrocada>0 Hacer
			Si litrocada>50 Entonces
				costolitro<-costolitro+25
				suma <- 50*costolitro
				sumatotal <- sumatotal+suma
				litrocada<-litrocada-50
			SiNo
				costolitro<-costolitro+25
				suma <- litrocada*costolitro
				sumatotal <- sumatotal+suma
				litrocada<-litrocada-litrocada
			Fin Si
		Fin Mientras
		
		//operaciones LUZ
		coskilo<-200
		
		Si kiloW<150 Entonces
			sumatotaluz <- kiloW*coskilo
			kiloocada<-kiloW-kiloW
		SiNo
			sumatotaluz <- 150*coskilo
			kiloocada<-kiloW-150
		Fin Si
		
		
		Mientras kiloocada>0 Hacer
			Si kiloocada>25 Entonces
				coskilo<-coskilo+40
				sumaa <- 25 * coskilo
				sumatotaluz <- sumatotaluz+sumaa
				kiloocada<-kiloocada-25
			SiNo
				coskilo<-coskilo+40
				sumaa <- kiloocada*coskilo
				sumatotaluz <- sumatotaluz+sumaa
				kiloocada<-kiloocada-kiloocada
			Fin Si
		Fin Mientras
		escribir sumatotaluz
		//operaciones de descuento segun zona
		//Agua
		Si zonaa =1 Entonces
			totalagua <- sumatotal-(sumatotal * 0.15)
			desagua<-sumatotal-totalagua
		SiNo
			Si zonaa = 2 Entonces
				impuesagua<-10000
				totalagua <- sumatotal+impuesagua
				desagua<- 0
			SiNo
				Si zonaa =3 Entonces
					impuesagua<-30000
					totalagua <- sumatotal+impuesagua+(sumatotal*0.25)
					desagua<- 0
				Fin Si
			Fin Si
		Fin Si
		
		//luz
		Si zonab =1 Entonces
			totalluz<- sumatotaluz-(sumatotaluz*0.20)
			desluz<- sumatotaluz-totalluz
		SiNo
			Si zonab = 2 Entonces
				Impuesluz<-15000
				totalluz<- sumatotaluz+Impuesluz
				desluz<- 0
			SiNo
				Si zonab =3 Entonces
					Impuesluz<-50000
					totalluz<- sumatotaluz+Impuesluz+(sumatotaluz*0.35)
					desluz<- 0
				Fin Si
			Fin Si
		Fin Si
		
		Repetir
			Escribir "********************************************************"
			Escribir "       DIJITE EL NUMERO SEGUN SU PREFERENCIA"
			Escribir "1=Hacer calculo de otro mes  2= Obtener lectura total"
			Escribir "********************************************************"
			Leer inicio
			Escribir "  "
		Hasta Que inicio=1 o inicio=2
		
		//Maximo y minimo consumido
		//menor
		litroscumenos<-1
		kiliWcumenos<-1 
		
		Si litroscumenos >= litros Entonces
			menorgastoagua<-litros
			litroscumenos <-litros
		finsi
		
		Si kiliWcumenos  >= kiloW Entonces
			menorgastoluz<-kiloW
			kiliWcumenos  <- kiloW
		finsi
		
		//mayor
		Si litroscum < litros Entonces
			mayorgastoagua<-litros
			litroscum <-litros
		finsi
		
		Si kiliWcum < kiloW Entonces
			mayorgastoluz <- kiloW
			kiliWcum  <- kiloW
		finsi
		
		kiliWcum <- kiloW
	Fin Mientras
	
	//Salidas
	
	Escribir "**********************************************************************"
	Escribir "**********************************************************************"
	Escribir "Tipo de servicio: Agua "
	
	Si zonaa =1 Entonces
			Escribir "Tipo de zona : rural "
	SiNo
		Si zonaa = 2 Entonces
			Escribir "Tipo de zona: Urbana"
		SiNo
			Si zonaa = 3 Entonces
				Escribir "Tipo de zona: industrial "
			Fin Si
		Fin Si
	Fin Si
	
	Escribir "Consumo total: " litros " Litros"
	Escribir "Impuesto de alcantarillado: $" impuesagua
	Escribir "Descuento: $" desagua
	Escribir "Costo total: $" totalagua
	Escribir "El menor gasto de mes fue: " menorgastoagua
	Escribir "El mayor gasto de mes fue: " mayorgastoagua
	
	Escribir "**********************************************************************"
	Escribir "Tipo de servicio: Luz "
	
	Si zonab =1 Entonces
		Escribir "Tipo de zona : rural "
	SiNo
		Si zonab =2 Entonces
			Escribir "Tipo de zona: Urbana"
		SiNo
			Si zonab =3 Entonces
				Escribir "Tipo de zona: industrial "
			Fin Si
		Fin Si
	Fin Si
	
	Escribir "Consumo total: " kiloW " Kilowatts"
	Escribir "Impuesto de alumbrado: $" Impuesluz
	Escribir "Descuento: $" desluz
	Escribir "Costo total: $" totalluz
	Escribir "El menor gasto de mes fue: " menorgastoluz
	Escribir "El mayor gasto de mes fue: " mayorgastoluz
	Escribir "**********************************************************************"
	Escribir "**********************************************************************"
FinAlgoritmo
