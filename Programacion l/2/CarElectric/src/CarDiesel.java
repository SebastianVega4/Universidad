public class CarDiesel extends Gasoline {
    public CarDiesel(int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de carro: Diesel";
    }
}