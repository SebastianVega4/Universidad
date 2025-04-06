from flask import Flask, request, jsonify
import numpy as np
from punto_fijo import punto_fijo

app = Flask(__name__)


@app.route('/punto_fijo', methods=['POST'])
def calcular_punto_fijo():
    data = request.get_json()

    try:
        gx_str = data.get("gx")
        a = float(data.get("a"))
        tolera = float(data.get("tolera"))
        iteramax = int(data.get("iteramax", 20))

        # Convertir la función string en función ejecutable
        gx = lambda x: eval(gx_str, {"np": np, "x": x})

        resultado = punto_fijo(gx, a, tolera, iteramax, vertabla=False)
        return jsonify(resultado)
    except Exception as e:
        return jsonify({"error": str(e)})


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)