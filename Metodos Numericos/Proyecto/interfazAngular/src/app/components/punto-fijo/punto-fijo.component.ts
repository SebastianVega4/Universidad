import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PuntoF } from 'src/app/models/PuntoF';
import { PuntoFService } from 'src/app/services/puntoFService';

@Component({
  selector: 'app-punto-fijo',
  templateUrl: './punto-fijo.component.html',
  styleUrls: ['./punto-fijo.component.css']
})
export class PuntoFijoComponent implements OnInit {
  eventForm: FormGroup;
  titulo = 'Metodo Punto Fijo';
  lista: any[] = [];
  raiz: number = 0;
  imagen: string = '';
  selectedField: string = ''; // Campo seleccionado para actualizar

  constructor(
    private fb: FormBuilder,
    private puntoService: PuntoFService
  ) {
    this.eventForm = this.fb.group({
      funcion: ['', Validators.required],
      funcionO: ['', Validators.required],
      puntoI: ['', Validators.required],
    });
  }

  ngOnInit(): void { }

  consulta() {
    const puntoF: PuntoF = {
      funcion: this.eventForm.get('funcion')?.value,
      funcion_original: this.eventForm.get('funcionO')?.value,
      punto_inicial: this.eventForm.get('puntoI')?.value
    };
    this.puntoService.save(puntoF).subscribe(
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
