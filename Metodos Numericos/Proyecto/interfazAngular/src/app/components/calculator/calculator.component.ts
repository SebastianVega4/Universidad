import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  operationString: string = '';
  basicOperationShape = /[-+*/]/;

  @Output() save = new EventEmitter<string>();
  @Output() close = new EventEmitter<void>();

  // Métodos de la calculadora
  writeToDisplay(value: string) {
    const displayBox = document.getElementById("displayBox") as HTMLInputElement;
    displayBox.value += value;
    this.operationString = displayBox.value;
  }

  writeMathFunction(data: string) {
    const displayBox = document.getElementById("displayBox") as HTMLInputElement;
    let currentValue = displayBox.value;

    // Reemplaza las funciones matemáticas con las funciones de Math
    if (data === 'sin(') {
      currentValue += 'math.sin(';
    } else if (data === 'cos(') {
      currentValue += 'math.cos(';
    } else if (data === 'tan(') {
      currentValue += 'math.tan(';
    } else if (data === 'sqrt(') {
      currentValue += 'math.sqrt(';
    } else if (data === 'log(') {
      currentValue += 'math.log10('; // Math.log10 para log base 10
    } else if (data === 'ln(') {
      currentValue += 'math.log(';
    } else if (data === '10^x') {
      currentValue += 'math.pow(10,';
    } else if (data === 'x^2') {
      currentValue += '**2';
    } else if (data === 'x^3') {
      currentValue += '**3';
    } else if (data === 'x^-1') {
      currentValue += '**-1';
    } else if (data === 'e') {
      currentValue += 'math.exp';
    } else if (data === '!') {
      // Implementar factorial si es necesario
    } else {
      currentValue += data;
    }

    displayBox.value = currentValue;
    this.operationString = currentValue;
  }

  writeOperatorToDisplay(operator: string) {
    const displayBox = document.getElementById("displayBox") as HTMLInputElement;
    let legacy = displayBox.value;

    // Si el último carácter es una operación básica, reemplazarlo
    if (this.basicOperationShape.test(legacy.slice(-1))) {
      this.operationString = legacy.slice(0, -1) + operator;
    } else {
      this.operationString = legacy + operator;
    }

    displayBox.value = this.operationString;
  }

  toggleSign() {
    const displayBox = document.getElementById("displayBox") as HTMLInputElement;
    let currentValue = displayBox.value;

    if (currentValue.startsWith('-')) {
      displayBox.value = currentValue.slice(1);
    } else {
      displayBox.value = '-' + currentValue;
    }

    this.operationString = displayBox.value;
  }

  clearDisplay() {
    const displayBox = document.getElementById("displayBox") as HTMLInputElement;
    displayBox.value = '';
    this.operationString = '';
  }

  eraseLastInput() {
    const displayBox = document.getElementById("displayBox") as HTMLInputElement;
    let currentValue = displayBox.value;
    displayBox.value = currentValue.slice(0, -1);
    this.operationString = displayBox.value;
  }

  passOperationString() {
    try {
      // Evalúa la expresión matemática usando la función Function constructor
      const result = new Function('Math', 'return ' + this.operationString)(Math);
      this.save.emit(result.toString());
    } catch (e) {
      this.save.emit('Error');
    }
    this.close.emit();
  }

  saveFunctionString() {
    // Emitir el string de la función sin realizar la operación
    this.save.emit(this.operationString);
    this.close.emit();
  }

  // Método para el botón X
  writex() {
    this.writeToDisplay('x');
  }

  writey() {
    this.writeToDisplay('y');
  }

  // Métodos para la memoria
  clearMemory() {
    // Implementa la funcionalidad de memoria
  }

  readMemory() {
    // Implementa la funcionalidad de lectura de memoria
  }

  addToMemory() {
    // Implementa la funcionalidad de añadir a memoria
  }

  subtractFromMemory() {
    // Implementa la funcionalidad de restar de memoria
  }

  saveToMemory() {
    // Implementa la funcionalidad de guardar en memoria
  }
}
