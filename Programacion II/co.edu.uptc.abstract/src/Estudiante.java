import java.util.Objects;

public class Estudiante extends Persona implements Inscripcion,Estacionamiento, BienestarU{
    private String cod;

    public Estudiante(String name, String genero, String cod) {
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
        if (cod%2==0) return false;
        else{
            return true;
        }
    }

    @Override
    public String revisarGen(String gen) {
        if (Objects.equals(gen, "Masculino")){
            return "Es Masculino";
        } else if (Objects.equals(gen, "Femenino")) {
            return "Es Femenino";
        }
        return "No esta Definido";
    }

    @Override
    public String inscribir() {
        return "el estudiante inscribio una materia";
    }

    @Override
    public String estacionamientoVeicular() {
        return "El Estudiante "+super.getName()+" estaciono en parquedaro estudiantil";
    }

    @Override
    public String BinestarUni() {
        return "El Estudiante "+super.getName()+" hizo uso del binestar univercitario";
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "name='" + super.getName() + '\'' +
                ", genero='" + super.getGenero() + '\'' +
                ", cod='" + cod + '\'' +
                '}';
    }
}