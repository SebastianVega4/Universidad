import pandas as pd
import numpy as np
import time


array = np.array([
    [5,9,6],
    [-4,-5,6],
    [5,7,-15]
    ])
number_columns = array.shape[1]
number_equation = number_columns
columns = (number_columns*2)+1
array_concat = np.zeros((number_equation, number_columns+1))
array_comparation = np.zeros((number_equation, number_columns))
array = np.concatenate((array, array_concat), axis=1)
_TR_COLUMN = "transformed" #columna que indica si el pivote ya fue usado
matriz_df = pd.DataFrame(array,columns=[f"x{i+1}" for i in range(columns)],index=[f"ec{i+1}" for i in range(number_equation)])
matriz_comparation = pd.DataFrame(array_comparation,columns=[f"x{i+1}" for i in range(number_columns)],index=[f"ec{i+1}" for i in range(number_equation)])
matriz_df.columns = matriz_df.columns[:-1].tolist() + [_TR_COLUMN]

for i in range(matriz_comparation.shape[0]):
    matriz_comparation.iloc[i,i] = 1
    i_2 = i+number_equation
    matriz_df.iloc[i,i_2] = 1

print("matriz_comparation")
print(matriz_comparation)
print("matriz_df")
print(matriz_df)

def transform_pivot_to_1(matriz, pivot):
    print(f'F{pivot} => F{pivot} / {matriz.iloc[pivot,pivot]} ---------------')
    if (matriz.iloc[pivot,pivot] == 0): 
        matriz, isValid = prepare_matrix(matriz, pivot)
        return (matriz,isValid)
    matriz.iloc[pivot] = matriz.iloc[pivot] / matriz.iloc[pivot,pivot]
    matriz.iloc[pivot,-1] = 1
    return (matriz,True)

def transform_to_0(matriz, pivot, row_index):
    if pivot == row_index: return (matriz,True)
    print(f'F{row_index} => F{row_index} +  (F{pivot} * {-1} * {matriz.iloc[row_index,pivot]}) ---------------')
    matriz.iloc[row_index] = matriz.iloc[row_index] + (((matriz.iloc[pivot]) * -1) * (matriz.iloc[row_index,pivot]))
    matriz.iloc[row_index,-1] = 0
    return (matriz,True)

def gauss_jordan(matriz, pivot):
    # print(f'pivot => {pivot}--{range(matriz.shape[0]-1)}')
    pivote_transform = False
    isValid = True
    for row_count in range(matriz.shape[0]):
        # print(f'row_count => {row_count}')
        if not pivote_transform:
            if (matriz.iloc[row_count,pivot] != 1): 
                (matriz,isValid) = transform_pivot_to_1(matriz,pivot)
                if not isValid:
                    return (matriz,False)
            pivote_transform = True
        if (matriz.iloc[row_count,pivot] != 0): 
            (matriz,isValid) = transform_to_0(matriz,pivot,row_count)
        print(matriz.iloc[:,:-1])
    return (matriz,True)

def prepare_matrix(matriz, pivot):
    print('PREPARE')
    row = matriz.iloc[pivot]
    for i in range(matriz.shape[0]):
        # print("(",matriz.iloc[i,pivot]," != 0) and ",matriz.iloc[i,-1]," == 0")
        if (matriz.iloc[i,pivot] != 0) and matriz.iloc[i,-1] == 0:
            row = matriz.iloc[i].copy()
            matriz.iloc[i] = matriz.iloc[0]
            matriz.iloc[0] = row
            print(matriz.iloc[:,:-1])
            return matriz, True
    print(matriz_df.iloc[:,:-1])
    return matriz, False
            
def validate_matrix(matriz):
    for i in matriz.columns:
        if i != _TR_COLUMN:
            ceros = matriz[matriz[i] == 0]
            if ceros.shape[0] == matriz.shape[0]:
                print('LA MATRIZ NO TIENE SOLUCIÓN 2')
                return matriz, False
    return matriz, True

print('VALIDATE')
isValid = False
matriz_df,isValid = validate_matrix(matriz_df)
print(matriz_df.iloc[:,:-1])
if isValid:
    count_column = 0
    iterations_count = 0
    while not matriz_comparation.equals(matriz_df.iloc[:, :-(1+matriz_comparation.shape[0])]):
        (matriz_df,isValid) = gauss_jordan(matriz_df, count_column)
        if not isValid:
            print('La matriz no tiene solución')
            break
        count_column += 1
        iterations_count += 1
        if count_column == matriz_df.columns.size-(1+matriz_comparation.shape[0]): count_column = 0
        # print("iterations_count => ",iterations_count)
        if iterations_count > (number_columns**2)+10: 
            print("Límite de iteraciones, no se pudo solucionar la matriz")
            isValid = False
            break
        time.sleep(0.5)
    if isValid:
        print("SOLUCIONADO INVERSA:")
        print(matriz_df.iloc[:,matriz_comparation.shape[0]:-1])
    else:
        print("Sucedió un error")