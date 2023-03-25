public abstract class AirVehicle extends Gasoline {
    public AirVehicle(int volume, String model, String year, String color, String place, TypeCar typecar) {
        super(volume, model, year, color, place, typecar);
    }

    public void tekeOff(){
        System.out.println("el veiculo Despego");
    }
    @Override
    public void powerOn(boolean power) {
        System.out.printf("""
                
                Encendio el Vehiculo Aereo
                La Gasolina esta al %s
                
                """, getVolume());
    }
    @Override
    public void powerOff(boolean power) {

        System.out.printf("""
                    
                    Se Apago el Vehiculo Aereo
                    La Gasolina esta al %s
                    
                    """, getVolume());
    }
    @Override
    public String toString() {
        return super.toString() + "\nTipo de carro: Aereo";
    }
}
