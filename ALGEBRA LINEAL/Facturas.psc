Algoritmo Facturas
	
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

	Si litros<100 Entonces
		coslitro<-litros * 150
	SiNo
		coslitro<-100 * 150
		Si litros<150 Entonces
			lit<-litros mod 100
			coslitro<-coslitro +(lit*175)
		SiNo
			coslitro<-coslitro +(50*175)
			Si litros<200 Entonces
				lit<-litros mod 100
				lit<-lit-50
				coslitro<-coslitro +(lit*200)
			SiNo
				coslitro<-coslitro +(50*200)
				Si litros<250 Entonces
					lit<-litros mod 200
					coslitro<-coslitro +(lit*225)
				SiNo
					coslitro<-coslitro +(50*225)
					Si litros<300 Entonces
						lit<-litros mod 200
						lit<-lit-50
						coslitro<-coslitro +(lit*300)
					SiNo
						coslitro<-coslitro +(50*300)
						Si litros<350 Entonces
							lit<-litros mod 300
							coslitro<-coslitro +(lit*375)
						SiNo
							coslitro<-coslitro +(50*375)
							Si litros<400 Entonces
								lit<-litros mod 300
								lit<-lit-50
								coslitro<-coslitro +(lit*400)
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si

	Si kiloW<150 Entonces
		coskilo<-kiloW * 200
	SiNo
		coskilo<-150 * 200
		Si kiloW<175 Entonces
			kilo<-kiloW mod 100
			coskilo<-coskilo +((kilo-50)*240)
		SiNo
			coskilo<-coskilo +(25*240)
			Si kiloW<200 Entonces
				kilo<-kiloW mod 100
				coskilo<-coskilo +((kilo-75)*280)
			SiNo
				coskilo<-coskilo +(25*280)
				Si kiloW<225 Entonces
					kilo<-kiloW mod 200
					coskilo<-coskilo +(kilo*320)
				SiNo
					coskilo<-coskilo +(25*320)
					Si kiloW<250 Entonces
						kilo<-kiloW mod 200
						coskilo<-coskilo+((kilo-25)*360)
					SiNo
						coskilo<-coskilo +(25*360)
						Si kiloW<275 Entonces
							kilo<-kiloW mod 200
							coskilo<-coskilo +((kilo-50)*400)
						SiNo
							coskilo<-coskilo +(25*400)
							Si kiloW<300 Entonces
								kilo<-kiloW mod 200
								coskilo<-coskilo +((kilo-75)*440)
							SiNo
								coskilo<-coskilo +(25*440)
								Si kiloW<325 Entonces
									kilo<-kiloW mod 300
									coskilo<-coskilo +(kilo*480)
								SiNo
									coskilo<-coskilo +(25*480)
									Si kiloW<350 Entonces
										kilo<-kiloW mod 300
										coskilo<-coskilo +((kilo-25)*520)
									Fin Si
								Fin Si
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si
	
	escribir coslitro
	Si zonaa =1 Entonces
		totalagua <- coslitro-(coslitro * 0.15)
		desagua<-coslitro-totalagua
	SiNo
		Si zonaa = 2 Entonces
			impuesagua<-10000
			totalagua <- coslitro+impuesagua
			desagua<- 0
		SiNo
			Si zonaa =3 Entonces
				impuesagua<-30000
				totalagua <- coslitro+impuesagua+(coslitro*0.25)
				desagua<- 0
			Fin Si
		Fin Si
	Fin Si
	
	Si zonab =1 Entonces
		totalluz<- coskilo-(coskilo*0.20)
		desluz<- coskilo-totalluz
	SiNo
		Si zonab = 2 Entonces
			Impuesluz<-15000
			totalluz<- coskilo+Impuesluz
			desluz<- 0
		SiNo
			Si zonab =3 Entonces
				Impuesluz<-50000
				totalluz<- coskilo+Impuesluz+(coskilo*0.35)
				desluz<- 0
			Fin Si
		Fin Si
	Fin Si
	
	Escribir "**********************************************************************"
	Si kiloW<350 Entonces
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
	SiNo
		Escribir "ERROR$=$: Exedio los litos posibles de calcular por el algoritmo"
		Escribir "Procure gastar menos"
	Fin Si
	
	Escribir "**********************************************************************"
	Si litros<400 Entonces
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
	SiNo
		Escribir "ERROR$=$: Exedio los kolowatts posibles de calcular por el algoritmo"
		Escribir "Procure gastar menos"
	Fin Si
	
	Escribir "**********************************************************************"
	
FinAlgoritmo