public class CarGasoline extends Gasoline {
    public CarGasoline(int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de carro: Gasolina";
    }
}
