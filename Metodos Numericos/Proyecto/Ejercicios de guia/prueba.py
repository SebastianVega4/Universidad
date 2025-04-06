import pandas as pd

# Crear el DataFrame
data = {
    'x1': [2.0, 1.0],
    'x2': [5.0, 3.0],
    'res': [2.0, 5.0]
}
df = pd.DataFrame(data)
print(df)
# Obtener el número de fila que deseas dividir
numero_fila = 0  # Por ejemplo, aquí seleccionamos la primera fila para dividir sus valores por 2

# Dividir todos los valores de la fila seleccionada por dos
df.iloc[numero_fila] = df.iloc[numero_fila] / 2

# Mostrar el DataFrame después de dividir los valores de la fila
print(df)