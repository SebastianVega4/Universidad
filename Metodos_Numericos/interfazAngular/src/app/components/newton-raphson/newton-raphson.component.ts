import { Component ,OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import{NewtonRaphson}from 'src/app/models/NewtonRaphson'
import {NewtonRaphsonService} from "src/app/services/newtonRaphsonService";

@Component({
  selector: 'app-newton-raphson',
  templateUrl: './newton-raphson.component.html',
  styleUrls: ['./newton-raphson.component.css']
})
export class NewtonRaphsonComponent implements OnInit {
  eventForm: FormGroup;
  titulo = 'Método De Newton Raphson';
  lista: any = [];
  raiz: number = 0;
  imagen: string = '';
  selectedField: string = ''; // Campo seleccionado para actualizar
  constructor(
    private fb: FormBuilder,
    private newtonRaphsonService: NewtonRaphsonService
  ){
    this.eventForm = this.fb.group({
      funcion: ['', Validators.required],
      derivada:['',Validators.required],
      puntoI: ['', Validators.required],
    });
  }
  ngOnInit():void{}

  consulta() {
    const newtonRaphson: NewtonRaphson = {
      funcion: this.eventForm.get('funcion')?.value,
      derivada: this.eventForm.get('derivada')?.value,
      punto_inicial: this.eventForm.get('puntoI')?.value
    };
    this.newtonRaphsonService.save(newtonRaphson).subscribe(
      response => {
        console.log(response);
        const data = response.Iteraciones;
        this.raiz = response.Raiz;
        this.imagen = 'data:image/png;base64,' + response.Imagen;
        if (Array.isArray(data)) {
          this.lista = data;
          for (const iterator of this.lista) {
            console.log(iterator.iteracion);
          }
        } else {
          console.error('Los datos recibidos no son un array:', data);
        }
      },
      error => {
        console.log(error);
        this.eventForm.reset();
      }
    );

  }

  openCalculator(field: string) {
    this.selectedField = field; // Guarda el campo seleccionado
    const calculatorModal = document.getElementById('calculatorModal');
    if (calculatorModal) {
      calculatorModal.style.display = 'flex';
    }
  }

  closeCalculator() {
    const calculatorModal = document.getElementById('calculatorModal');
    if (calculatorModal) {
      calculatorModal.style.display = 'none';
    }
  }

  saveFunction(func: string) {
    if (this.selectedField) {
      this.eventForm.get(this.selectedField)?.setValue(func);
      this.closeCalculator();
    }
  }

}
