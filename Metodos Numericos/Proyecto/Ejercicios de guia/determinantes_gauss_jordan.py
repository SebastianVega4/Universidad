import pandas as pd
import numpy as np
import time


number_columns = 3
# while number_columns < 2:
#     number_columns = int(input('Escriba el número de incógnitas de las ecuaciones: '))
#     if number_columns < 2:
#         print("No válido, intente de nuevo")
array = np.array([
    [2,1,-1,1,0],
    [4,1,2,1,0],
    [2,2,3,1,0],
    ])
print(array)
number_columns = array.shape[1]-2
number_equation = number_columns
number_columns +=1
array_comparation = np.zeros((number_equation, number_columns-1))
_RES_COLUMN = "res"
_TR_COLUMN = "transformed" #columna que indica si el pivote ya fue usado
matriz_df = pd.DataFrame(array,columns=[f"x{i+1}" for i in range(number_columns+1)],index=[f"ec{i+1}" for i in range(number_equation)])
matriz_comparation = pd.DataFrame(array_comparation,columns=[f"x{i+1}" for i in range(number_columns-1)],index=[f"ec{i+1}" for i in range(number_equation)])
matriz_df.columns = matriz_df.columns[:-2].tolist() + [_RES_COLUMN] + [_TR_COLUMN]
if number_columns > 2:
    matriz_no_valid = [
        matriz_comparation.iloc[1:,:number_columns-2].copy(),#esquina inferior izquierda
        matriz_comparation.iloc[1:,1:number_columns-2].copy(),#esquina inferior derecha
        matriz_comparation.iloc[1:,1:number_columns-2].copy(),#esquina inferior derecha
        matriz_comparation.iloc[1:,1:number_columns-2].copy()#esquina inferior derecha
        ]

print("matriz_df")
print(matriz_df.iloc[:,:-1])
zeros_pivot = 0
for row_index in range(number_equation):
    # for column_index in range(number_columns):
        # value = float(input(f'Ingrese el valor de [{row_index},{column_index}]: '))
        # matriz_df.iloc[row_index, column_index] = value
    matriz_comparation.iloc[row_index,row_index] = 1
    if (matriz_df.iloc[row_index,row_index] == 0): zeros_pivot += 1

def transform_pivot_to_1(matriz, pivot, operations, rows_changes):
    print(f'F{pivot} => F{pivot} / {matriz.iloc[pivot,pivot]} ---------------')
    if (matriz.iloc[pivot,pivot] == 0): 
        matriz, isValid, rows_changes = prepare_matrix(matriz, pivot, rows_changes)
        return (matriz,isValid,operations, rows_changes)
    operations.append(1/matriz.iloc[pivot,pivot])
    matriz.iloc[pivot] = matriz.iloc[pivot].astype(float) / matriz.iloc[pivot,pivot].astype(float)
    matriz.iloc[pivot,-1] = 1
    return (matriz,True, operations,rows_changes)

def transform_to_0(matriz, pivot, row_index):
    if pivot == row_index: return (matriz,True)
    print(f'F{row_index} => F{row_index} +  (F{pivot} * {-1} * {matriz.iloc[row_index,pivot]}) ---------------')
    matriz.iloc[row_index] = matriz.iloc[row_index].astype(float) + (((matriz.iloc[pivot].astype(float)) * -1) * (matriz.iloc[row_index,pivot].astype(float)))
    matriz.iloc[row_index,-1] = 0
    return (matriz,True)

def gauss_jordan(matriz, pivot, operations_det, rows_changes):
    # print(f'pivot => {pivot}--{range(matriz.shape[0]-1)}')
    pivote_transform = False
    isValid = True
    for row_count in range(matriz.shape[0]):
        # print(f'row_count => {row_count}')
        if not pivote_transform:
            if (matriz.iloc[row_count,pivot] != 1): 
                (matriz,isValid, operations_det, rows_changes) = transform_pivot_to_1(matriz,pivot, operations_det, rows_changes)
                if not isValid:
                    return (matriz,False, operations_det)
            pivote_transform = True
        if (matriz.iloc[row_count,pivot] != 0): 
            (matriz,isValid) = transform_to_0(matriz,pivot,row_count)
        print(matriz.iloc[:,:-1])
    return (matriz,True, operations_det, rows_changes)

def prepare_matrix(matriz, pivot, rows_changes):
    print('PREPARE')
    row = matriz.iloc[pivot]
    for i in range(matriz.shape[0]):
        # print("(",matriz.iloc[i,pivot]," != 0) and ",matriz.iloc[i,-1]," == 0")
        if (matriz.iloc[i,pivot] != 0) and matriz.iloc[i,-1] == 0:
            row = matriz.iloc[i].copy()
            matriz.iloc[i] = matriz.iloc[0]
            matriz.iloc[0] = row
            print(matriz.iloc[:,:-1])
            rows_changes+=1
            return matriz, True, rows_changes
    print(matriz_df.iloc[:,:-1])
    return matriz, False, rows_changes
            
def validate_matrix(matriz):
    if (zeros_pivot > number_equation-1):
        print('LA MATRIZ NO TIENE SOLUCIÓN 1')
        return matriz, False
    for i in matriz.columns:
        if i != _RES_COLUMN and i != _TR_COLUMN:
            ceros = matriz[matriz[i] == 0]
            if ceros.shape[0] == matriz.shape[0]:
                print('LA MATRIZ NO TIENE SOLUCIÓN 2')
                return matriz, False
    return matriz, True

def determinantes(matriz, operations, rows_changes):
    res_op = 1
    res_diag = 1
    for i in range(len(operations)):
        res_op = operations[i]*res_op
        
    for i in range(matriz.shape[0]):
        if i == 0:
            res_diag = matriz.iloc[i,i]
        res_diag = res_diag * matriz.iloc[i,i]
    res = res_diag * (1/res_op) * ((-1)**rows_changes)
    print(f"DETERMINANTE => {res}")

print('VALIDATE')
isValid = False
print(zeros_pivot," <= ",number_equation-1)
matriz_df,isValid = validate_matrix(matriz_df)

print(matriz_df.iloc[:,:-1])
if isValid:
    count_column = 0
    iterations_count = 0
    operations_det = []
    changes = 0
    while not matriz_comparation.equals(matriz_df.iloc[:, :-2].astype(float)):
        (matriz_df,isValid, operations_det, changes) = gauss_jordan(matriz_df, count_column, operations_det, changes)
        if not isValid:
            print('La matriz no tiene solución')
            break
        count_column += 1
        iterations_count += 1
        if count_column == matriz_df.columns.size-2: count_column = 0
        # print("iterations_count => ",iterations_count)
        if iterations_count > (number_columns**2)+10: 
            print("Límite de iteraciones, no se pudo solucionar la matriz")
            isValid = False
            break
        time.sleep(0.5)
    if isValid:
        print("SOLUCIONADO:")
        print(matriz_df.iloc[:,:-1])
        determinantes(matriz_df,operations_det, changes)
    else:
        print("Sucedió un error")