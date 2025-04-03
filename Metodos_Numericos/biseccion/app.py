from flask import Flask, request, jsonify
from flask_cors import CORS
import matplotlib.pyplot as plt
import numpy as np
import io
import base64
import math  

app = Flask(__name__)
CORS(app)


def biseccion(f, a, b, error=1e-6):
    maxima_Iteracion = 100
    iteraciones = []

    for i in range(maxima_Iteracion):
        c = (a + b) / 2
        iteraciones.append({
            'iteracion': i + 1,
            'a': round(a,4),
            'b': round(b,4),
            'c': round(c,4),
            'fc': round(f(c),4),
            'error': round(abs(f(c)),4),
        })
        if abs(f(c)) < error or (b - a) / 2 < error:
            return c, iteraciones
        if f(c) * f(a) < 0:
            b = c
        else:
            a = c
    raise ValueError("Error")

def generar_grafica(f, a, b, raiz):
    fig, ax = plt.subplots()
    x = np.linspace(a - 1, b + 1, 400)
    y = np.array([f(val) for val in x])
    
    ax.plot(x, y, label='f(x)')
    ax.axhline(0, color='red', lw=0.5)
    ax.axvline(0, color='red', lw=0.5)
    ax.plot(raiz, 0, 'ro')
    ax.axvline(raiz, color='green', linestyle='--', lw=0.5)
    
    ax.set_title("Método de Bisección")
    ax.set_xlabel("Eje X")
    ax.set_ylabel("Eje Y")
    ax.legend()
    ax.grid(True)
    
    buffer = io.BytesIO()
    fig.savefig(buffer, format='png')
    buffer.seek(0)
    imagen = base64.b64encode(buffer.read()).decode('utf-8')
    plt.close(fig)
    
    return imagen

@app.route('/biseccion', methods=['POST'])
def solve_biseccion():
    data = request.json
    f_str = data['funcion']
    a = data['x0']
    b = data['x1']
    
    def f(x):
        return eval(f_str, {"math": math, "x": x})

    try:
        root, iteraciones = biseccion(f, a, b)
        imagen = generar_grafica(f, a, b, root)
        return jsonify({'Raiz': root, 'Iteraciones': iteraciones, 'Imagen': imagen})
    except ValueError as e:
        return jsonify({'error': str(e)}), 400

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5001)