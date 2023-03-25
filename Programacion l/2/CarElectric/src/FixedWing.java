public class FixedWing extends AirVehicle{

    public FixedWing(int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }

    public void takeOffDiagonel(){
        scrollUp(10);
        advance(20);
        setVolume(getVolume() - 20);
        System.out.println("despego Diagonalemnte");
    }
    @Override
    public String toString() {
        return super.toString() + "\nVeiculo: Avion";
    }
}
