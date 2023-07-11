package co.edu.uptc.model;

import co.edu.uptc.model.Empleado;

public class Vendedor extends Empleado {

    private Double comision;

    public Vendedor(String nombre, String telefono, Double sueldoBase, Double comision) {
        super(nombre, telefono, sueldoBase);
        this.comision = comision;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }


    //multiplica el Sueldo base por la Comision
    @Override
    public Double calcularSueldoBase(){
        return getSueldoBase()*comision;
    }

    //Se le agrega una hora por politica de la empresa
    @Override
    public int alcularHorasTrabajadas(int hInicio, int hFin) {
        return hFin-hInicio+1;
    }


    public String toString() {
        return "Empleado{" +
                "nombre='" + super.getNombre() + '\'' +
                ", telefono='" + super.getTelefono() + '\'' +
                ", sueldoBase=" + super.getSueldoBase() + '\'' +
                "comision=" + comision +
                '}';
    }
}
