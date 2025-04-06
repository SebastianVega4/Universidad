import numpy as np
import matplotlib.pyplot as plt

# Funciones
def valorcercano():
  i = 5
  menor = 9999
  while i < -5:
    valor = f(i)
    print(valor,i)
    if abs(valor) < abs(menor):
      menor = i
    i += 1

  return menor



def f(x):
  return (x**3) -2 * (x**2) + x + 2

print(valorcercano())