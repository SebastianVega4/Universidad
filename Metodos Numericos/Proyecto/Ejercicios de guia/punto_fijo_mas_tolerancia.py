def f(x):
    return (1.8*x + 2.5)/x

def puntofijo(f, xIni, tol):
    i = 0
    E = 100
    print('Datos: Tolerancia: ',tol)
    print('   X   |   g(x)   |   i   |   Error   |')
    while (E > tol):
        Gx = f(xIni)
        if (xIni != 0):
            E = abs(((xIni - Gx) / xIni)*100)
        else:
          E=100
        print(' ',xIni,' | ',Gx,' |  ',i,'  | ',E)
        xIni = Gx
        i+=1
    print('Iteraciones: ',i)
    return
        
if __name__ == '__main__':
    puntofijo(f, 3,1E-3)
        