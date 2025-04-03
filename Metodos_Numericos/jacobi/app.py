from flask import Flask, request, jsonify
import numpy as np
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

def jacobi_method(A, b, tol=1e-6, max_iter=100):
    n = len(b)
    x = np.zeros(n)
    x1 = np.copy(x)
    k = 1
    iterations = []

    while k <= max_iter:
        current_iteration = {'iteration': k, 'x': x1.tolist()}
        for i in range(n):
            summation = 0
            for j in range(n):
                if i != j:
                    summation += A[i][j] * x1[j]
            x[i] = (b[i] - summation) / A[i][i]

        error = np.linalg.norm(x - x1)
        current_iteration['error'] = error
        iterations.append(current_iteration)

        if error < tol:
            return iterations, x.tolist(), error

        x1 = np.copy(x)
        k += 1

    raise ValueError("No convergió.")

@app.route('/jacobi', methods=['POST'])
def solve_jacobi():
    data = request.json
    A = np.array(data['Matriz'])
    b = np.array(data['Vector_Resultado'])

    try:
        iterations, solution, final_error = jacobi_method(A, b)
        return jsonify({'iteracion': iterations, 'solucion': solution, 'error_final': final_error})
    except ValueError as e:
        return jsonify({'error': str(e)}), 400

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5007)