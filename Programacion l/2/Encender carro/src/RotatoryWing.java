public class RotatoryWing extends AirVehicle{

    public RotatoryWing(int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }

    public void takeOffVerticall() {
        setVolume(getVolume() - 20);
        scrollUp(10);
        System.out.println("despego Vertialemnte");
    }

    @Override
    public String toString() {
        return super.toString() + "\n Veiculo: Helicoptero";
    }
}
