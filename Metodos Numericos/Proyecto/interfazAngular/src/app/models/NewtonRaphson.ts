export class NewtonRaphson{

  funcion:String;
  derivada:String;
  punto_inicial:Number;

  constructor(funcion:String,derivada:String,punto_inicial:Number) {
      this.funcion = funcion;
      this.derivada = derivada;
      this.punto_inicial = punto_inicial;

  }

}
