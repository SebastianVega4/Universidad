import numpy as np

#code made by Gemini
def f(x):
  return 2*x**3 - 11.7*x**2 + 17.7*x - 5

def g(x):
  return (11.7*x**2 - 17.7*x + 5) / 2

def metodo_punto_fijo(f, g, x0, tolerancia, max_iteraciones):
  iteraciones = []
  error = tolerancia + 1
  for i in range(max_iteraciones):
    xn = g(x0)
    iteraciones.append((i, x0, f(x0)))
    error = np.abs(xn - x0)
    if error < tolerancia:
      return xn, iteraciones
    x0 = xn
  return None, iteraciones

x0 = complex(3)
tolerancia = 1e-6
max_iteraciones = 100

raiz, iteraciones = metodo_punto_fijo(f, g, x0, tolerancia, max_iteraciones)

if raiz is None:
  print("No se encontró una raíz en el número máximo de iteraciones")
else:
  print(f"Raíz estimada: {raiz}")
  print(f"Iteraciones: {iteraciones}")