import graficar as graph

def f(x):
    return -0.5 * (x**2) + 2.5*x + 4.5

def biseccion(a,b):
    fa = f(a)
    fb = f(b)
    i = 0
    N_iter = 10
    Xn_anterior = 0
    E = 1
    Tolerancia = 1E-3
    print('Datos: Tolerancia: ',Tolerancia,' | N° Iteraciones: ',N_iter)
    while (E>=Tolerancia): #TOLERANCIA
        if(fa * fb == 0):
            raiz=None
            if(fa==0):
                raiz=a
                i=N_iter+1
            else:
                raiz=b
                i=N_iter+1
            print('La raiz es: ',str(raiz))
        else:
            if(fa*fb<0):
                Xn=(a+b)/2
                fxn=f(Xn)
                if(fa*fxn==0):
                    print('La raiz es: ',str(Xn))
                    i=N_iter+1
                else:
                    if(fa*fxn<0):
                        b=Xn
                        fb=fxn
                        i=i+1
                    else:
                        a=Xn
                        fa=fxn
                        i=i+1
                    E = abs((Xn - Xn_anterior)/Xn)*100
                    graph.listas_datos['Xn'].append(Xn)
                    graph.listas_datos['i'].append(i)
                    graph.listas_datos['Error'].append(E)
                    # print('(',Xn,' - ',Xn_anterior,')/',Xn,')')
                    print('En la iteración i =',i,' Xn es ',str(Xn),' | Error = ',abs(E)*100)
                    Xn_anterior = Xn
            else:
                print('La raiz no está entre [',str(a),',',str(b),']')
                
if __name__ == '__main__':
    biseccion(6,15)
    graph.graficar(graph.listas_datos,['Xn','i'],'Bisección Gráfico Xn vs i','b-')     
    graph.graficar(graph.listas_datos,['Error','i'],'Bisección Gráfico Error vs i','r-')     