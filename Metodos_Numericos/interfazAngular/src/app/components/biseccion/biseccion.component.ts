import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Biseccion } from 'src/app/models/biseccion';
import {BiseccionService} from 'src/app/services/biseccionService';


@Component({
  selector: 'app-biseccion',
  templateUrl: './biseccion.component.html',
  styleUrls: ['./biseccion.component.css']
})
export class BiseccionComponent implements OnInit{
  eventForm: FormGroup;
  titulo = 'Método de Bisección';
  lista: any[] = [];
  raiz: number = 0;
  imagen: string = '';
  selectedField: string = ''; 
constructor( private fb: FormBuilder,
  private biseccionService:BiseccionService
){
    this.eventForm = this.fb.group({
      funcion: ['', Validators.required],
      x0:['',Validators.required],
      x1: ['', Validators.required],
    });
}
ngOnInit():void{}
consulta() {
  const biseccion:Biseccion = {
    funcion: this.eventForm.get('funcion')?.value,
    x0:this.eventForm.get('x0')?.value,
    x1: this.eventForm.get('x1')?.value
  };

  this.biseccionService.save(biseccion).subscribe(
    response=>{
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


