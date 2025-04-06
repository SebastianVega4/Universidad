from flask import Flask, request, jsonify

import math
import matplotlib.pyplot as plt
import io
import base64

from flask_cors import CORS

app = Flask(__name__)
CORS(app)


def simpson(f, a, b, n=100):
    if n % 2 == 1:
        raise ValueError("El número de subintervalos debe ser par.")
    
    h = (b - a) / n
    x = [a + i * h for i in range(n + 1)]
    y = [f(xi) for xi in x]
    
    S = y[0] + y[-1] + 4 * sum(y[1:n:2]) + 2 * sum(y[2:n-1:2])
    return S * h / 3

@app.route('/simpson', methods=['POST'])
def solve_simpson():
    try:
        data = request.json
        if not data:
            raise ValueError("No se enviaron datos en la solicitud.")
        
        f_str = data.get('funcion')
        a = data.get('limitea')
        b = data.get('limiteb')
        n = data.get('nimagenes', 100)
        
        if f_str is None or a is None or b is None:
            raise ValueError("Los parámetros 'funcion', 'limitea' y 'limiteb' son obligatorios.")
        
        f = lambda x: eval(f_str, {"math": math, "x": x})
        
        resultado = simpson(f, a, b, n)
        
        x = [a + i * (b - a) / n for i in range(n + 1)]
        y = [f(xi) for xi in x]
        midpoints = [(x[i] + x[i + 1]) / 2 for i in range(n)]
        midpoints_y = [f(mid) for mid in midpoints]

        plt.figure()
        plt.plot(x, y, 'b', zorder=5, label='Puntos')
        plt.scatter(x, y, color='blue')
        plt.scatter(midpoints, midpoints_y, color='red', zorder=5, label='Puntos medios')
        plt.fill_between(x, 0, y, where=[(xi >= a) and (xi <= b) for xi in x], color='skyblue', alpha=0.4)
        plt.title('Método de Simpson')
        plt.xlabel('x')
        plt.ylabel('f(x)')
        plt.legend()

        img = io.BytesIO()
        plt.savefig(img, format='png')
        img.seek(0)

        grafica = base64.b64encode(img.getvalue()).decode('utf-8')

        resultados = [{'x': float(x[i]), 'y': float(y[i])} for i in range(len(x))]
        resultados += [{'x': float(midpoints[i]), 'y': float(midpoints_y[i])} for i in range(len(midpoints))]
        
        return jsonify({'Raiz': resultado, 'Grafica': grafica, 'Resultados': resultados})
    
    except ValueError as e:
        return jsonify({'error': str(e)}), 400
    except Exception as e:
        return jsonify({'error': f"Error inesperado: {str(e)}"}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5008)