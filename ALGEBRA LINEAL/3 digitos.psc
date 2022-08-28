Proceso PARCIAL
	Escribir "Escribir el numero de 3 cifras positivo"
	Escribir "NUMERO=" Sin Saltar
	Leer NUM 
	O1<-NUM MOD 100
	dig1<-(NUM-(NUM mod 100 ))/ 100
	dig2<-(O1 -(O1 mod 10))/10
	dig3<-O1 MOD 10
	Escribir "********************************"
	Escribir  "     " "PRIMER DIGITO ES:" " " dig1
	Escribir  "     " "SEGUNDO DIGITO ES:" dig2
	Escribir  "     " "TERCER DIGITO ES:" " " dig3
	Escribir  "LOS DOS PRIMEROS DIGITOS SON:" " " dig1 dig2
	Escribir  "LOS DOS SEGUNDOS DIGITOS SON:" " " dig2 dig3
	Escribir "********************************"
FinProceso
