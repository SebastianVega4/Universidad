import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Jacobi } from 'src/app/models/jacobi';
import { JacobiService } from 'src/app/services/jacobiService';

@Component({
  selector: 'app-jacobi',
  templateUrl: './jacobi.component.html',
  styleUrls: ['./jacobi.component.css']
})
export class JacobiComponent implements OnInit {
  
  titulo = 'Método De Jacobi';
  matrizSize: number=0;
  matriz: number[][]=[];
  vector: number[] = [];
  resultado: [] = [];
  iteraciones: { iteration: number,error:number, x: number[] }[]=[];

  constructor(private fb: FormBuilder,
    private jacobiService: JacobiService
  ){

  }
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
   calculate() {
    const jacobi: Jacobi = {
        Matriz: this.matriz,
        Vector_Resultado: this.vector
    };
    

    this.jacobiService.save(jacobi).subscribe(
      response => {
        console.log(response);
        this.resultado = response.solucion;
        this.iteraciones = response.iteracion;
      },
      error => {
        console.log(error);
      }
    );
  }
}
