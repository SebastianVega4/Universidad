Algoritmo Cuenta_de_ahorros
	
	//Johan Sebastian Vega Ruiz 201911913
	
	Escribir "Bienbenido al sistema su banco de confianza"
	
	Saldo <- 0
	
	Repetir
		
		//menu
		Repetir
			Escribir "***************************************"
			Escribir "Digite el numero segun la opcion desada"
			Escribir "1 = COMPRAR   2 = DEPOSITAR   3 = RETIRAR"
			Escribir "   4 = HISTORIAL     5 = SALIR  "
			Escribir "***************************************"
			Leer Menu1
			Escribir ""
			Escribir ""
		Hasta Que Menu1 > 0 Y Menu1 < 6
		
		//Comprar
		Si Menu1 = 1 Entonces
			Escribir " Dijite el valor del producto que va a comprar"
			Leer ValCompra
			ValCompra <- ValCompra + (ValCompra* 0.17)
			saldo <- saldo - ValCompra
			Ncompras <- Ncompras + 1
			Sumcompras <- Sumcompras + ValCompra
			Si saldo < 0 Entonces
				Escribir "Error a exedido el saldo(cupo) de su cuenta NO se realizo la compra"
				saldo <- saldo + ValCompra
				Ncompras <- Ncompras - 1
				Sumcompras <- Sumcompras - ValCompra
			Fin Si
		Fin Si
		
		//Depositar
		Si Menu1 = 2 Entonces
			Escribir " Dijite el valor del Deposito que desea realizar"
			Leer ValDeposito
			saldo <- saldo + ValDeposito
			Ndeposito <- Ndeposito + 1
			Sumdeposito <- Sumdeposito + ValDeposito
		Fin Si
		
		//Retirar
		Si Menu1 = 3 Entonces
			Repetir
				Escribir ""
				Escribir ""
				Escribir "***************************************"
				Escribir "   Digite Por  donde la va a retirar"
				Escribir "   1 = VENTANILLA   2 = CAJERO   "
				Escribir "***************************************"
				Leer Menu2
				Escribir ""
				Escribir ""
			Hasta Que Menu2 > 0 Y Menu2 < 3
			
			//Ventanilla
			Si Menu2 = 1 Entonces
				Escribir " Dijite la cantidad que desea retirar"
				Leer Valretirado
				Valretirado <- Valretirado + 5000
				saldo <- saldo - Valretirado
				Nretiros <- Nretiros + 1
				Sumretirado <- Sumretirado + Valretirado
				Si saldo < 0 Entonces
					Escribir "Error a exedido el saldo(cupo) de su cuenta NO se realizo el retiro"
					saldo <- saldo + Valretirado
					Nretiros <- Nretiros - 1
					Sumretirado <- Sumretirado - Valretirado
				Fin Si
			SiNo
				//Cajero
				Escribir " Dijite la cantidad que desea retirar"
				Leer Valretirado
				Valretirado<- Valretirado + (Valretirado* 0.10)
				saldo <- saldo - Valretirado
				Nretiros <- Nretiros + 1
				Sumretirado <- Sumretirado + Valretirado
				Si saldo < 0 Entonces
					Escribir "Error a exedido el saldo(cupo) de su cuenta NO se realizo el retiro"
					saldo <- saldo + Valretirado
					Nretiros <- Nretiros - 1
					Sumretirado <- Sumretirado - Valretirado
				Fin Si
			Fin Si
			
		Fin Si
		
		//Historial
		Si Menu1 = 4 Entonces
			Si Ncompras > 0 Entonces
				Escribir "Haz realizado " Ncompras " Compras equivalente a: " Sumcompras " $"
			Fin Si
			Si Ndeposito > 0 Entonces
				Escribir "Haz realizado " Ndeposito " Depositos equivalente a:  " Sumdeposito " $"
			Fin Si
			Si Nretiros > 0 Entonces
				Escribir "Haz realizado " Nretiros " Retiros de dinero equivalente a:  " Sumretirado " $"
			Fin Si
			Escribir "Su saldo actual es: " saldo " $"
		Fin Si
		
	Hasta Que Menu1 = 5
	
FinAlgoritmo
