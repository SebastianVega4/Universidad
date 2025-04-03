from flask import Flask, request, jsonify

import math
import matplotlib.pyplot as plt
import numpy as np
import io
import base64
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

def newton_raphson(f, df, x0, tol=1e-6, max_iter=100):
    x = x0
    iteraciones = []

    for i in range(max_iter):
        fx = f(x)
        dfx = df(x)
        iteraciones.append({
            'x': round(x,4),
            'f': round(fx,4),
            'iteracion': i + 1,
            'd': round(dfx,4),
            'error': round(abs(fx),4)
        })
        if abs(fx) < tol:
            return x, iteraciones
        if dfx == 0:
            raise ValueError("Derivada cero. No se puede continuar.")
        x = x - fx / dfx

    raise ValueError("No convergió.")

@app.route('/newton_raphson', methods=['POST'])
def solve_newton_raphson():
    data = request.json
    f_str = data['funcion']
    df_str = data['derivada']
    x0 = float(data['punto_inicial'])

    f = lambda x: eval(f_str, {"math": math, "x": x, "__builtins__": {}})
    df = lambda x: eval(df_str, {"math": math, "x": x, "__builtins__": {}})

    try:
        raiz, iteraciones = newton_raphson(f, df, x0)

        # Generar la gráfica
        a = -10
        b = 10
        n = 100
        xn = np.linspace(a, b, n)
        f_v = np.vectorize(f)
        yn = f_v(xn)

        plt.plot(xn, yn, label='f(x)')
        plt.axhline(0, color='red', linestyle='--')
        plt.axvline(0, color='red', linestyle='--')
        plt.plot(raiz, f(raiz), 'ko', label='Raíz encontrada')
        plt.title("Método de Newton-Raphson")
        plt.xlabel("Eje X")
        plt.ylabel("Eje Y")
        plt.legend()
        plt.grid(True)

        img = io.BytesIO()
        plt.savefig(img, format='png')
        img.seek(0)
        plt.close()

        # Convertir la imagen a base64
        img_base64 = base64.b64encode(img.getvalue()).decode('utf-8')

        return jsonify({'Raiz': raiz, 'Iteraciones': iteraciones, 'Imagen': img_base64})

    except ValueError as e:
        return jsonify({'error': str(e)}), 400
    except Exception as e:
        return jsonify({'error': f'Error durante la ejecución: {str(e)}'}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)