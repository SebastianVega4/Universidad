package co.edu.uptc.model;

import co.edu.uptc.model.Empleado;

public class Gerente extends Empleado {

    private String area;

    public Gerente(String nombre, String telefono, Double sueldoBase, String area) {
        super(nombre, telefono, sueldoBase);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int alcularHorasTrabajadas(int hInicio, int hFin) {
        return hFin-hInicio;
    }

    //El gerente no tiene ninguna modificacion del sueldo base
    @Override
    public Double calcularSueldoBase(){
        return getSueldoBase()*2;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + super.getNombre() + '\'' +
                ", telefono='" + super.getTelefono() + '\'' +
                ", sueldoBase=" + super.getSueldoBase() + '\'' +
                "area='" + area +
                '}';
    }
}
