export class GaussSeidel{
    matriz:number[][];
    vector:number[];
    error_min:number;
    iteraciones_max:number;
    
    constructor(matriz:number[][],vector:number[],error_min:number,iteraciones_max:number){
        this.matriz=matriz;
        this.vector=vector;
        this.error_min=error_min;
        this.iteraciones_max=iteraciones_max;
    }
}