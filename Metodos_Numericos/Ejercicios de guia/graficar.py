import matplotlib.pyplot as plt
listas_datos = {'Xn':[],'i':[],'Error':[]}
cuenta_graficas = 0

def graficar(listas,indices,titulo,linea):
    global cuenta_graficas
    plt.figure(cuenta_graficas)
    plt.plot(listas[indices[0]], listas[indices[1]], linea)
    plt.title(titulo)
    plt.xlabel(indices[0])
    plt.ylabel(indices[1])
    plt.show()
    cuenta_graficas = cuenta_graficas+ 1
    return