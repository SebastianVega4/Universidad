import math

def funcion(x):
    return (math.sin(x)) + ( x**2 / 4) -2

def secante(x_1,x_2,iteraciones,tolerancia):
    for k in range (iteraciones):
        x_aux = x_2 - (funcion(x_2) * (x_2 - x_1)) / (funcion(x_2) - funcion(x_1))
        if abs((x_aux - x_2)/x_aux) < tolerancia:
            return f"La raiz aproximada es: {x_aux}"
        print(f"iteracion= {k+1} x= {x_aux} x_0= {x_1} x_1= {x_2}")
        x_1 = x_2
        x_2 = x_aux
    return f"despues de {iteraciones} iteraciones la funcion se va a divergue"

print(secante(2,4,10,0.00001))