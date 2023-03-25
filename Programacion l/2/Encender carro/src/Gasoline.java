public class Gasoline extends Car implements IEngineable {
    public Gasoline(int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }
    @Override
    public void powerOn(boolean power) {
        if (power && getVolume() >= 2) {
            setVolume(getVolume() - 2);
            System.out.printf("""
                    
                    Encendio el carro
                    La Gasolina esta al %s""", getVolume());
        } else if (power && getVolume() < 2) {
            throw new InsufficientCombusException("No hay suficiente gasolina para encender el carro");
        }
    }

    @Override
    public void powerOff(boolean power) {

        System.out.printf("""
                    
                    Se Apago el carro
                    La Gasolina esta al %s""", getVolume());
    }
}
