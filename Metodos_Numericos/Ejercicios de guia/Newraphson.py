def newton_raphson(func, func_prime, tolerancia=1e-6, max_iteraciones=100):
   
    x_n = 0.0
    while True:
        f_x_n = func(x_n)
        f_prime_x_n = func_prime(x_n)
        
        if abs(f_prime_x_n) < 1e-10:
            print("no puede continuar.")
            return None
        
        x_n1 = x_n - f_x_n / f_prime_x_n
        
        if abs(x_n1 - x_n) < tolerancia:
            break
        
        x_n = x_n1
    
    suposicion_inicial = x_n
    

    for i in range(max_iteraciones):
        f_x_n = func(suposicion_inicial)
        f_prime_x_n = func_prime(suposicion_inicial)
        
        if abs(f_prime_x_n) < 1e-10:
            print("no puede continuar.")
            return None
        
        x_n1 = suposicion_inicial - f_x_n / f_prime_x_n
        
        if abs(x_n1 - suposicion_inicial) < tolerancia:
            return x_n1
        
        suposicion_inicial = x_n1
    
    print("no convergió.")
    return None


def func(x):
    return x**3 - 6*x**2 + 11*x - 6

def func_prime(x):
    return 3*x**2 - 12*x + 11


resultado = newton_raphson(func, func_prime)

if resultado is not None:
    print(f"Raíz: {resultado}")

