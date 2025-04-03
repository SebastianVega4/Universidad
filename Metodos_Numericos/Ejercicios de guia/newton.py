import graficar as graph
import numpy as np
import pandas as pd

graph.listas_datos = {'p':[],'i':[],'i_error':[],'Gx':[],'Error':[]}

def f(x):
    return 2 * (x**3) - 11.7 * (x**2) + 17.7*x - 5

def fprima(x):
    return 6 * (x**2) - 23.4 * x + 17.7


def newton(f, f_prima, x0, tolerancia, max_iteraciones):
    iteraciones = []
    error = tolerancia + 1
    print('Datos: Tolerancia: ',tolerancia)
    print('   x0   |   xn   |   i   |  error ')
    for i in range(max_iteraciones):
        xn = x0 - f(x0) / f_prima(x0)
        iteraciones.append((i, x0, f(x0)))
        error = abs(xn - x0)
        if error < tolerancia:
            return
        print(f'   {x0}   |   {xn}   |   {i}   |  {error} ')
        x0 = xn
    print('Iteraciones: ',i+1)
    return
        
if __name__ == '__main__':
    newton(f,fprima,3,1E-3,3)
    
        