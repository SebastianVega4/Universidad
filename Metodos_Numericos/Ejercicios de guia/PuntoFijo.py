import numpy as np
import matplotlib.pyplot as plt

# Funciones
def valorcercano():
  i = -5
  menor = 9999
  while i < 5:
    valor = g(i)
    print(i, valor)
    if abs(valor) < abs(menor):
      menor = i
    i += 1
  return menor

def g(x):
  return np.sqrt((x+5) / 2)

def f(x):
  return 2 * (x**2) - x - 5

def error(actual, anterior):
  return abs((actual - anterior) / actual) * 100

def puntofijo(x):
  iteracion=[0]
  aproximaciones = [x]
  errores = []
  anterior = x
  actual = g(x)
  while error(actual, anterior) > 0.01:
    anterior = actual
    actual = g(actual)
    iteracion.append(0)
    aproximaciones.append(actual)
    errores.append(error(actual, anterior))
  print("Raíz aproximada:", actual)

  x_vals = np.linspace(-2, 2, 50)
  y_vals = f(x_vals)
  y_valsg = g(x_vals)
  plt.plot(x_vals, y_vals, label='f(x)')
  plt.plot(x_vals, y_valsg, label='g(x)')
  plt.plot( aproximaciones,iteracion, 'ro', label='Aproximaciones')
  plt.xlabel('x')
  plt.ylabel('f(x)')
  plt.legend()
  plt.title('Método de Punto Fijo')

  plt.show()

puntofijo(valorcercano())