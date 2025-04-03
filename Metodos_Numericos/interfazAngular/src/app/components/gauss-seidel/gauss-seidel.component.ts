import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GaussSeidel } from 'src/app/models/gauss';
import { GaussSeidelService } from 'src/app/services/gaussSeidelService';


@Component({
  selector: 'app-gauss-seidel',
  templateUrl: './gauss-seidel.component.html',
  styleUrls: ['./gauss-seidel.component.css']
})
export class GaussSeidelComponent implements OnInit {
  
  titulo = 'Método De Gauss Seidel';
  matrizSize: number=0;
  matriz: number[][]=[];
  vector: number[] = [];

  resultado: [] = [];
  error: [] = [];
  iteraciones: { iteracion: number, x: number[] }[]=[];

  constructor( private fb: FormBuilder,
    private gaussService: GaussSeidelService
  ){  }
  ngOnInit():void{
     this.matrizSize = 2;
    }
    generar(): void {
      this.generateMatriz();
    }
  
    generateMatriz(): void {
      this.matriz = Array.from({ length: this.matrizSize }, () => Array(this.matrizSize).fill(0));
      this.vector = Array(this.matrizSize).fill(0);
    }
    roundToDecimal(num: number, decimalPlaces: number): number {
      return Math.round(num * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
    }
    
    //calculate(){}
    calculate() {
    const gauss: GaussSeidel = {
        matriz: this.matriz,
        vector: this.vector,
        error_min: 0.0001,
        iteraciones_max: 100
    };
    

    this.gaussService.save(gauss).subscribe(
      response => {
        console.log(response);
        this.resultado = response.resultado;
        this.error = response.error;
        this.iteraciones = response.iteraciones;
      },
      error => {
        console.log(error);
      }
    );
  }
}




 