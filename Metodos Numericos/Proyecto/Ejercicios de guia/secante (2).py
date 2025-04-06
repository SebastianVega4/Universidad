def f(x):
  # Función a la que se le busca la raíz
  return 2*x**3 - 11.7*x**2 + 17.7*x - 5

def metodo_secante(f, x0, x1, tolerancia):
    error = tolerancia + 1
    print('Datos: Tolerancia: ',tolerancia)
    print('   x0   |   x1   |   xn   |   i   |  error ')
    i=0
    while error > tolerancia:
        xn = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0))
        error = abs(xn - x1)
        if error < tolerancia:
            return
        print(f'   {x0}   |   {x1}   |   {xn}   |   {i}   |  {error} ')
        x0 = x1
        x1 = xn
        i+=1
    print('Iteraciones: ',i+1)
    return
metodo_secante(f, 3, 4, 0.01, 8)