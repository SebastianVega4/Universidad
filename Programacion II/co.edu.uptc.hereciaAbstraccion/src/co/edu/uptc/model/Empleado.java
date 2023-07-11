package co.edu.uptc.model;

public abstract class  Empleado {
    private String nombre;
    private String telefono;
    private Double sueldoBase;

    public Empleado(String nombre, String telefono, Double sueldoBase) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sueldoBase = sueldoBase;
    }

    public abstract int alcularHorasTrabajadas(int hInicio,int hFin);
    public Double calcularSueldoBase(){
        return this.sueldoBase;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", sueldoBase=" + sueldoBase +
                '}';
    }
}
