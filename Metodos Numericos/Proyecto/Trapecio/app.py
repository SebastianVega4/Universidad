from flask import Flask, request, jsonify
import math
import matplotlib.pyplot as plt
import numpy as np
import io
import base64

from flask_cors import CORS

app = Flask(__name__)
CORS(app)


def metodo_trapecio(f, a, b, n):
    h = (b - a) / n
    x = np.linspace(a, b, n+1)
    y = f(x)
    area = (h/2) * np.sum(y[:-1] + y[1:])
    return area, x, y

@app.route('/Trapecio', methods=['POST'])
def solve_trapecio():
    data = request.json
    f_str = data['funcion']
    a = float(data['a'])
    b = float(data['b'])
    n = int(data['n'])

    # Definir la función f utilizando eval
    try:
        f = lambda x: eval(f_str, {"math": math, "x": x, "__builtins__": {}})
        f_v = np.vectorize(f)
    except Exception as e:
        return jsonify({'error': f'Error en la función: {str(e)}'}), 400

    try:
        area,x,y= metodo_trapecio(f_v, a, b, n)

        # Generar la gráfica
        plt.plot(x, y, 'b', label='f(x)')
        for i in range(n):
            plt.fill([x[i], x[i], x[i+1], x[i+1]], [0, y[i], y[i+1], 0], 'r', edgecolor='black', alpha=0.5)
        plt.grid(True)
        plt.axhline(0, color="#000000")
        plt.axvline(0, color="#000000")
        plt.title("Método del Trapecio")
        plt.ylabel("Eje Y")
        plt.xlabel("Eje X")
        plt.legend()

        img = io.BytesIO()
        plt.savefig(img, format='png')
        img.seek(0)
        plt.close()

        # Convertir la imagen a base64
        img_base64 = base64.b64encode(img.getvalue()).decode('utf-8')

        return jsonify({'Area': area, 'Imagen': img_base64})
    except Exception as e:
        return jsonify({'error': f'Error durante la ejecución: {str(e)}'}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5006)