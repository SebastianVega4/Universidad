import graficar as graph

def f(x):
    return -0.5 * (x**2) + 2.5*x + 4.5

def biseccion(a,b):
    fa = f(a)
    fb = f(b)
    i = 0
    N_iter = 6
    while (i<=N_iter):
        if(fa*fb==0):
            if(fa==0):
                print('La raiz es: ',str(a))
                i=N_iter+1
            else:
                print('La raiz es: ',str(b))
                i=N_iter+1
        else:
            if(fa*fb<0):
                Xn=(a+b)/2
                fXn=f(Xn)
                if(fa*fXn==0):
                    print('La raiz es: ',str(Xn))
                    i=N_iter+1
                else:
                    if(fa*fXn<0):
                        b=Xn
                        fb=fXn
                        i=i+1
                    else:
                        a=Xn
                        fa=fXn
                        i=i+1
                    print('En la iteración i=',i,' Xn es ',str(Xn))
                    graph.listas_datos['Xn'].append(Xn)
                    graph.listas_datos['i'].append(i)
            else:
                print('La raiz no está entre [',str(a),',',str(b),']')



if __name__ == '__main__':
    biseccion(6,7)
    graph.graficar(graph.listas_datos,['Xn','i'],'Gráfico Xn vs i','b-')