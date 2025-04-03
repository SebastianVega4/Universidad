import math

def fun(x):
    return x**3 - 2*x + 5

def fun_g(x):
    return (2*x - 5)**(1/3)

def punto_fijo(x, iteraciones, tolerancia):
    x_i__1 = x 
    for k in range(iteraciones):
        x_i = fun_g(x_i__1)  
        if abs(x_i - x_i__1) < tolerancia:
            return f"Su raíz es aproximadamente: {x_i}"
        x_i__1 = x_i
        print(f"Iteración= {k+1}, x= {x_i}")
    return f"Después de {iteraciones} iteraciones no se encontró una raíz, por lo tanto, diverge"

print(punto_fijo(2, 20, 0.00001))