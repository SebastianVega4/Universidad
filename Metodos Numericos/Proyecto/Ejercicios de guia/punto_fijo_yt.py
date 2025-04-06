#code foound on the web
import matplotlib.pyplot as plt
import math
plt.style.use('classic')
def f2(x):
    # return (2*(x**3) + 11.7*(x**2) + 5)/17.7
    # return 2*x**3 - 11.7*x**2 + 18.7*x - 5
    # return math.sqrt(-2*x**3- 17.7*x+5)/(-11.7)
    return (11.7*x**2 - 17.7*x + 5) / (2*x**2)

def punto_fijo(x_init,max_iter = 3, error = 0.0001):
    x_vec = []
    e_vec = []
    x_vec.append(x_init)
    e_vec.append(1)
    cuenta = 0
    while cuenta < max_iter:
        x_vec.append(f2(x_vec[cuenta]))
        e_act = abs(x_vec[cuenta+1]-x_vec[cuenta])
        e_vec.append(e_act)
        if(e_act <= error):
            break
        print(cuenta)
        cuenta +=1
    print(cuenta)
    return [x_vec,e_vec]
        
        
x,e=punto_fijo(3,3)
print(e)
print(x)

plt.plot(x, label='raiz')
plt.plot(e, label='error')
plt.grid(True)
plt.xlabel('Iteraciones')
plt.show()