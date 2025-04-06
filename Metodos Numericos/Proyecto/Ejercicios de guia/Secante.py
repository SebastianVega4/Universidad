def metodo_secante_auto(func, tolerancia=1e-6, max_iteraciones=100):

    x0 = -1.0
    x1 = 1.0
    f_x0 = func(x0)
    f_x1 = func(x1)
    
    while f_x0 * f_x1 > 0:
        x0 -= 1.0
        x1 += 1.0
        f_x0 = func(x0)
        f_x1 = func(x1)
        
    for i in range(max_iteraciones):
        if abs(f_x1 - f_x0) < 1e-10:
            print(" no puede continuar.")
            return None
        
        x_next = x1 - (f_x1 * (x1 - x0)) / (f_x1 - f_x0)
        
        if abs(x_next - x1) < tolerancia:
            return x_next
        
        x0 = x1
        x1 = x_next
        f_x0 = f_x1
        f_x1 = func(x1)
    
    print(" no convergie.")
    return None


def func(x):
    return x**3 - 6*x**2 + 11*x - 6


resultado_secante_auto = metodo_secante_auto(func)

if resultado_secante_auto is not None:
    print(f"Raíz: {resultado_secante_auto}")
