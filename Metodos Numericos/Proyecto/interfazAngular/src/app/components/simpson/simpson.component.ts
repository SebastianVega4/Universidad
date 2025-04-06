import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Simpson } from 'src/app/models/Simpson';
import { SimpsonService } from 'src/app/services/simpsonService';

@Component({
  selector: 'app-simpson',
  templateUrl: './simpson.component.html',
  styleUrls: ['./simpson.component.css']
})
export class SimpsonComponent implements OnInit {
  eventForm: FormGroup;
  titulo = 'Método de Simpson';
  lista: any[] = [];
  raiz: number = 0;
  imagen: string = '';
  selectedField: string = ''; // Campo seleccionado para actualizar

  constructor(
    private fb: FormBuilder,
    private simpsonS: SimpsonService,
  ) {
    this.eventForm = this.fb.group({
      funcion: ['', Validators.required],
      limitea: ['', Validators.required],
      limiteb: ['', Validators.required],
      nimagenes: ['', [Validators.required, Validators.min(2), this.parValidator]],
    });
  }

  ngOnInit(): void {}

  // Validador personalizado para el campo nimagenes (verifica que sea par)
  parValidator(control: any) {
    if (control.value && control.value % 2 !== 0) {
      return { parError: 'El número de imágenes debe ser par' };
    }
    return null;
  }

  consulta() {
    if (this.eventForm.invalid) {
      return; // Si el formulario es inválido, no hacer nada
    }

    const simpson: Simpson = {
      funcion: this.eventForm.get('funcion')?.value,
      limitea: this.eventForm.get('limitea')?.value,
      limiteb: this.eventForm.get('limiteb')?.value,
      nimagenes: this.eventForm.get('nimagenes')?.value
    };

    this.simpsonS.save(simpson).subscribe(
      response => {
        console.log(response);
        const data = response.Resultados;
        this.raiz = response.Raiz;
        this.imagen = 'data:image/png;base64,' + response.Grafica;

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
