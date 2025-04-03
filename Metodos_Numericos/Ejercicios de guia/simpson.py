def metodo_simpson(func, a, b, n):
    if n % 2 != 0:
        raise ValueError("El número de subintervalos debe ser par")
    
    h = (b - a) / n
    sumatoria = func(a) + func(b)
    
    for i in range(1, n, 2):
        sumatoria += 4 * func(a + i * h)
    
    for i in range(2, n - 1, 2):
        sumatoria += 2 * func(a + i * h)
    
    integral = (h / 3) * sumatoria
    return integral


def func(x):
    return x**3 + 2*x**2 - 5*x + 1


a = 1
b = 3
n = 6


resultado_simpson = metodo_simpson(func, a, b, n)
print(f"Aproximación Simpson: {resultado_simpson}")
