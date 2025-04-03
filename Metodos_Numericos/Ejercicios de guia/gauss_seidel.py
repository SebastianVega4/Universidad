import numpy as np

def metodo_gauss_seidel(A, b, x0, tolerancia=1e-6, max_iteraciones=100):
    n = len(A)
    x = x0.copy()
    
    for _ in range(max_iteraciones):
        x_next = x.copy()
        for i in range(n):
            sumatoria = 0
            for j in range(n):
                if j != i:
                    sumatoria += A[i, j] * x_next[j]
            x_next[i] = (b[i] - sumatoria) / A[i, i]
        
        if np.linalg.norm(x_next - x, np.inf) < tolerancia:
            return x_next
        
        x = x_next.copy()
    
    print("no convergie.")
    return None


A = np.array([[5, -1, 2],
              [3, 8, -2],
              [1, 1, 4]])

b = np.array([12, -25, 6])


x0 = np.zeros_like(b)


resultado_gauss_seidel = metodo_gauss_seidel(A, b, x0)

if resultado_gauss_seidel is not None:
    print(f"Solución: {resultado_gauss_seidel}")
