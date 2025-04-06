from flask import Flask, request, jsonify
import numpy as np
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

def is_numeric(value):
    try:
        float(value)
        return True
    except ValueError:
        return False

def broyden(f, x0, J0, tol, max_iter):
    """
    Método de Broyden para resolver sistemas de ecuaciones no lineales.
    :param f: función que representa el sistema de ecuaciones no lineales.
    :param x0: vector inicial.
    :param J0: aproximación inicial de la matriz Jacobiana.
    :param tol: tolerancia para el criterio de convergencia.
    :param max_iter: número máximo de iteraciones.
    :return: solución aproximada, errores e iteraciones.
    """
    x = np.array(x0, dtype=float)
    J = np.array(J0, dtype=float)
    iteraciones = []

    for k in range(max_iter):
        # Calcular el valor de la función y actualizar x
        fx = np.array(f(x))
        delta_x = -np.linalg.solve(J, fx)
        x_new = x + delta_x

        # Guardar la iteración actual
        iteraciones.append({'iteracion': k + 1, 'x': x_new.tolist(), 'fx': fx.tolist()})

        # Calcular el error
        error = np.linalg.norm(delta_x, ord=2)
        if error < tol:
            break

        # Actualizar la aproximación del Jacobiano
        delta_f = np.array(f(x_new)) - fx
        delta_x = x_new - x
        J += np.outer((delta_f - J @ delta_x), delta_x) / np.dot(delta_x, delta_x)

        # Actualizar x
        x = x_new

    return x, error, iteraciones

@app.route('/broyden', methods=['POST'])
def resolver_broyden():
    data = request.json

    if 'f' not in data or 'x0' not in data or 'J0' not in data:
        return jsonify({'error': 'Faltan campos necesarios: f, x0 y J0 son requeridos.'}), 400

    f = eval("lambda x: " + data['f'])  # Convertir la función ingresada a una función evaluable
    x0 = data['x0']
    J0 = data['J0']
    tol = data.get('tol', 1e-6)
    max_iter = data.get('max_iter', 100)

    if not all(is_numeric(val) for val in np.array(x0).flatten()):
        return jsonify({'error': 'x0 debe contener solo valores numéricos.'}), 400
    if not all(is_numeric(val) for val in np.array(J0).flatten()):
        return jsonify({'error': 'J0 debe contener solo valores numéricos.'}), 400

    try:
        resultado, error, iteraciones = broyden(f, x0, J0, tol, max_iter)
    except Exception as e:
        return jsonify({'error': f'Ocurrió un error al resolver el sistema: {str(e)}'}), 500

    return jsonify({'resultado': resultado.tolist(), 'error': error, 'iteraciones': iteraciones})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5005)
