import sympy as sp

x = sp.Symbol('x')

def funcion(x):
    return (x**4 /x**3) - 2*x + (1/x**2)

def funcion_derivada(x):
    df = sp.diff(funcion(x), x)
    return sp.lambdify(x, df)

def newtonRapshon(x_i, iteraciones, tolerancia):
    fd = funcion_derivada(x)
    for k in range(iteraciones):
        x_i_1 = x_i - (funcion(x_i) / fd(x_i))
        if abs(x_i_1 - x_i) < tolerancia:
            return f"su raiz es aproximadamente: {x_i_1}"
        print(f"iteracion= {k + 1} x= {x_i_1} g'(x)= {fd(x_i)}")
        x_i = x_i_1
    return f"despues de {iteraciones} iteraciones no se encontro por lo tanto divergue"

print(newtonRapshon(2, 10, 0.00001))