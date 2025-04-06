# Definición de la función f(x)
def f(x):
    return -x**2 + 1.8*x + 2.5

# Definición de la derivada de la función f(x)
def df(x):
    return -2*x + 1.8

# Método de iteración de punto fijo
def punto_fijo(g, x0, es):
    ea = 100  # Error aproximado inicial
    xn = x0   # Valor inicial
    while ea > es:
        x_old = xn
        xn = g(x_old)  # Nueva aproximación
        if xn != 0:
            ea = abs((xn - x_old) / xn) * 100  # Cálculo del error aproximado
    return xn

# Método de Newton-Raphson
def newton_raphson(f, df, x0, es):
    ea = 100  # Error aproximado inicial
    xn = x0   # Valor inicial
    while ea > es:
        x_old = xn
        xn = x_old - f(x_old) / df(x_old)  # Nueva aproximación
        if xn != 0:
            ea = abs((xn - x_old) / xn) * 100  # Cálculo del error aproximado
    return xn

# Valor inicial
x0 = 5
# Criterio de convergencia
es = 0.05

# Método de iteración de punto fijo
g = lambda x: (x**2 + 2.5) / 1.8
raiz_punto_fijo = punto_fijo(g, x0, es)

# Método de Newton-Raphson
raiz_newton_raphson = newton_raphson(f, df, x0, es)

# Comprobación del error
error_punto_fijo = abs(f(raiz_punto_fijo))
error_newton_raphson = abs(f(raiz_newton_raphson))

# Imprimir resultados
print("Raíz aproximada con el método de iteración de punto fijo:", raiz_punto_fijo)
print("Error de la raíz obtenida con el método de punto fijo:", error_punto_fijo)
print("Raíz aproximada con el método de Newton-Raphson:", raiz_newton_raphson)
print("Error de la raíz obtenida con el método de Newton-Raphson:", error_newton_raphson)
