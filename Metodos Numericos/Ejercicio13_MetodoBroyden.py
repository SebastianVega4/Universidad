import numpy as np

#-------------------------------------------------------------
#                INTEGRANTES DEL GRUPO                       -
# Lina Mercedes Espitia Cuadrado - Cod. 201921194            -
# Jeimmy Patricia Valderrama Vásquez - Cod. 201821062        -
#-------------------------------------------------------------

def sistema_ecuaciones(V):
    V1, V2, V3 = V[0], V[1], V[2]
    return np.array([
        V1**2 - V2 + V3 - 3,
        V1 - V2**3 + np.cos(V3) - 1,
        np.sin(V1) + V2 - V3**2
    ])

def metodo_broyden(funcion_sistema, vector_inicial, tolerancia=1e-6, maximo_iteraciones=100):

    V_actual = np.array(vector_inicial, dtype=float)
    numero_variables = len(vector_inicial)
    identidad = np.eye(numero_variables)  # Matriz identidad
    inversa_jacobiano = identidad  # Aproximación inicial de la inversa del Jacobiano
    
    iteracion = 0
    while iteracion < maximo_iteraciones:

        valor_funcion = funcion_sistema(V_actual)
        
        if np.linalg.norm(valor_funcion) < tolerancia:
            print(f"Convergencia alcanzada en la iteración {iteracion + 1}")
            return V_actual
        
        delta_V = -np.dot(inversa_jacobiano, valor_funcion)
        nuevo_V = V_actual + delta_V
        nuevo_valor_funcion = funcion_sistema(nuevo_V)
        
        diferencia_V = nuevo_V - V_actual
        diferencia_funcion = nuevo_valor_funcion - valor_funcion
        
        inversa_jacobiano += np.outer(diferencia_V - np.dot(inversa_jacobiano, diferencia_funcion), 
                                      np.dot(inversa_jacobiano, diferencia_funcion)) / np.dot(np.dot(inversa_jacobiano, diferencia_funcion), diferencia_funcion)

        V_actual = nuevo_V
        iteracion += 1
        
        print(f"Iteración {iteracion}: V = {V_actual}, Norma(función) = {np.linalg.norm(valor_funcion)}")
    
    print("No se alcanzó la convergencia dentro del número máximo de iteraciones")
    return V_actual

# Valores iniciales para las variables V1, V2, V3
valores_iniciales = [1.5, 1.5, 1.5]

# Ejecutar el método de Broyden
solucion_final = metodo_broyden(sistema_ecuaciones, valores_iniciales)

# Mostrar la solución final
print(f"Solución final: V1 = {solucion_final[0]}, V2 = {solucion_final[1]}, V3 = {solucion_final[2]}")
