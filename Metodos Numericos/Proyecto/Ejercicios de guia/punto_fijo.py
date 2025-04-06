import graficar as graph
import numpy as np
import pandas as pd

graph.listas_datos = {'x':[],'i':[],'i_error':[],'Gx':[],'Error':[]}

def f(x):
    return (11.7*x**2 - 17.7*x + 5) / (2*x**2)

def puntofijo(xIni, tol):
    i = 0
    # diff = error
    N_iter = 10
    E = 1
    print('Datos: Tolerancia: ',tol)
    print('   X   |   g(x)   |   i   |   Error   |')
    i_error = 0
    for i in range(N_iter):
        Gx = f(xIni)
        # graph.listas_datos['x'].append(xIni)
        # graph.listas_datos['i'].append(i)
        # graph.listas_datos['Gx'].append(Gx)
        if (i != 0):
            E = (xIni - Gx) / xIni
            # graph.listas_datos['i_error'].append(i_error)
            # graph.listas_datos['Error'].append(E)
            # i_error+=1
        print(' ',xIni,' | ',Gx,' |  ',i,'  | ',E)
        xIni = Gx
    print('Iteraciones: ',i)
        
if __name__ == '__main__':
    puntofijo(3,1E-3)
    # graph.graficar(graph.listas_datos,['x','Gx'],'Punto fijo | Gráfico x vs Gx','b-')     
    # graph.graficar(graph.listas_datos,['x','i'],'Punto fijo | Gráfico x vs i','b-')     
    # graph.graficar(graph.listas_datos,['Gx','i'],'Punto fijo | Gráfico Gx vs i','b-')     
    # print(graph.listas_datos['i_error'])
    # graph.graficar(graph.listas_datos,['Error','i_error'],'Punto fijo | Gráfico Error vs i_error','r-')     
        