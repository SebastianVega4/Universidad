public class CarElectric extends Car implements IEngineable {

    public CarElectric( int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }

    public void acelerar(int velocidad) {
        if (getVolume() >= 10) {
            System.out.printf("""
                    Acelerando el carro electrico
                    Velocidad actual: %d km/h""", velocidad);
            setVolume(getVolume() - 10);
        } else if (getVolume() < 10) {
            throw new InsufficientCombusException("No hay suficiente Bateria para encender el carro");
        }

    }

    @Override
    public void powerOn(boolean power) {
        System.out.printf("""
                
                Encendio el carro
                La bateria esta al %s""", getVolume());
    }
    @Override
    public void powerOff(boolean power) {

        System.out.printf("""
                    
                    Se Apago el carro
                    La Bateria esta al %s""", getVolume());
    }
    @Override
    public String toString() {
        return super.toString() + "\nTipo de carro: Eléctrico";
    }
}