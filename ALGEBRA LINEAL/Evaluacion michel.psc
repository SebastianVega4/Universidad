SubProceso variable( opera,oper,cero)
	
	variablesss<-0
	
Fin SubProceso


Proceso Evaluacion
	
	Escribir "Dijite cantidad de numeros"
	Leer N
	
	variable( opera,oper,cero)
	
	Para a<-1 Hasta N Hacer
		
        Escribir "ingrese los numeros"
        Leer n
		Si n=0 Entonces
			cero <- 0+1		
		Sino
			Si n > 0 Entonces
				opera <- opera+1
			Sino
				oper <- oper+1
			Fin Si
		Fin Si
        
		
    Fin Para
	
	Escribir "Hay " opera "Numeros positivos: "
	Escribir "Hay " oper "Numeros negativos: " 
	Escribir "Hay " cero "Numeros neutros: " 
	
FinProceso

