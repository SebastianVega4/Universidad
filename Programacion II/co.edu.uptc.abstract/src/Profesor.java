import java.util.Objects;

public class Profesor extends Persona implements Inscripcion, Estacionamiento, BienestarU{
    private String cod;

    public Profesor(String name, String genero, String cod) {
        super(name, genero);
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public boolean revisarCod(int cod) {
        return cod % 2 != 0;
    }

    @Override
    public String revisarGen(String gen) {
        if (Objects.equals(gen, "Masculino")) {
            return "Es Masculino";
        } else if (Objects.equals(gen, "Femenino")) {
            return "Es Femenino";
        }
        return "No esta Definido";
    }

    @Override
    public String inscribir() {
        return "El profesor se escribio a un grupo de investigacion";
    }

    @Override
    public String estacionamientoVeicular() {
        return "El profesor "+super.getName()+" estaciono en el de profesores";
    }

    @Override
    public String BinestarUni() {
        return "El Profesor "+super.getName()+" hizo uso del binestar univercitario";
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "name='" + super.getName() + '\'' +
                ", genero='" + super.getGenero() + '\'' +
                ", cod='" + cod + '\'' +
                '}';
    }

}
