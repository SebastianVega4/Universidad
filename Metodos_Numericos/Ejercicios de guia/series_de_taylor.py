import pandas as pd
import numpy as np

def f(x):
    return 2*(x**2) + 3*x - 8 

def f_prima_1(x):
    return 2*(x**2) + 3*x - 8 

def f_prima_2(x):
    return 2*(x**2) + 3*x - 8 

funcs = [f,f_prima_1,f_prima_2]
def taylor(functions):
    count = 0
    
    for i in functions.keys():
        count += 1