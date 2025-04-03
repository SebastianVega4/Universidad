from flask import Flask, request, jsonify
import math
import matplotlib.pyplot as plt
import numpy as np
import io
import base64
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

def punto_fijo(g, x0, tol=1e-6, max_iter=100):
    iteraciones=[]
    cont=0
    x = x0
    for _ in range(max_iter):
        x_next = g(x)
        iteraciones.append({
            'iteracion':cont,
            'xi':x_next, 
            'error':abs(x_next-x),

        })
        if abs(x_next - x) < tol:
            return x_next,iteraciones
        x = x_next
        cont=cont+1
    raise ValueError("No convergió.")

@app.route('/punto_fijo', methods=['POST'])
def solve_punto_fijo():
    data = request.json
    g_str = data['funcion']
    f_str=data['funcion_original']
    x0 = data['punto_inicial']

    # Definir la función g utilizando eval
    try:
        g = lambda x: eval(g_str, {"math": math, "x": x, "__builtins__": {}})
        f =lambda x: eval(f_str, {"math": math, "x": x, "__builtins__": {}})
        g_v = np.vectorize(g)
        f_v = np.vectorize(f)
    except Exception as e:
        return jsonify({'error': f'Error en la función: {str(e)}'}), 400

    try:
        root,iteraciones = punto_fijo(g,x0)
         # Generar la gráfica
        a = -5
        b = 5
        n = 100
        xn = np.linspace(a, b, n)
        yn = f_v(xn)

        plt.plot(xn, yn)
        plt.grid(True)
        plt.axhline(0, color="#ff0000")
        plt.axvline(0, color="#ff0000")
        plt.plot(root, 0, 'ko')
        plt.title("Método Punto fijo")
        plt.ylabel("Eje Y")
        plt.xlabel("Eje X")
        if (root!= np.nan):
            plt.axvline(root)#Línea vertical donde cruzan la función idéntica y el g(x)

        img = io.BytesIO()
        plt.savefig(img, format='png')
        img.seek(0)
        plt.close()

        # Convertir la imagen a base64
        img_base64 = base64.b64encode(img.getvalue()).decode('utf-8')

        return jsonify({'Raiz': root,'Iteraciones':iteraciones,'Imagen':img_base64})
    except ValueError as e:
        return jsonify({'error': str(e)}), 400
    except Exception as e:
        return jsonify({'error': f'Error durante la ejecución: {str(e)}'}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5003)