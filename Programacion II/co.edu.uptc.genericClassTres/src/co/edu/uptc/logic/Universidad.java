package co.edu.uptc.logic;

public class Universidad<T> {
    private T persona;

    public Universidad(T persona) {
        this.persona = persona;
    }

    public void mostrarPersona() {
        System.out.println(persona.toString());
    }
}
