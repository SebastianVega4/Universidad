#code made by ChatGPT 3.5

# Definición de la función f(x)
def f(x):
    return 2*x**3 - 11.7*x**2 + 17.7*x - 5

# Definición de la función g(x) para el método de iteración de punto fijo
def g(x):
    return (11.7*x**2 - 17.7*x + 5) / (2*x**2)

# Implementación del método de iteración de punto fijo
def punto_fijo(g, x0, n_iter):
    """
    g: Función de iteración
    x0: Valor inicial
    n_iter: Número de iteraciones
    """
    print("x","g(x)")
    xn = x0
    for i in range(n_iter):
        xi = xn
        xn = g(xn)
        print(xi,xn)
        
    return xn

# Valores iniciales
x0 = 3
n_iter = 3

# Aplicar el método de iteración de punto fijo
raiz_punto_fijo = punto_fijo(g, x0, n_iter)

# Imprimir el resultado
print("Raíz aproximada con el método de iteración de punto fijo:", raiz_punto_fijo)
