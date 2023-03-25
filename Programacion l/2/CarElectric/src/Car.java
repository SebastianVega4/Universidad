public abstract class Car implements Moveable {
    private int volume = 100;
    private String model;
    private String year;
    private String color;
    private String place;

    public Car(int volume, String model, String year, String color, String place, TypeCar typecar) {
        this.volume = volume;
        this.model = model;
        this.year = year;
        this.color = color;
        this.place = place;
        TypeCar Typecar = typecar;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "volumen: " + volume + '\n' +
                "Modelo: " + model + '\n' +
                "Year: " + year + '\n' +
                "Color: " + color + '\n' +
                "Placa: " + place;
    }

    @Override
    public Boolean moveForward(Integer distance) {
        return null;
    }

    @Override
    public boolean advance(Integer distance) {
        return Moveable.super.advance(distance);
    }

    @Override
    public Boolean back(Integer distance) {
        return Moveable.super.back(distance);
    }

    @Override
    public Boolean scrollRight(Integer distance) {
        return Moveable.super.scrollRight(distance);
    }

    @Override
    public Boolean scrollLeft(Integer distance) {
        return Moveable.super.scrollLeft(distance);
    }

    @Override
    public Boolean scrollUp(Integer distance) {
        return Moveable.super.scrollUp(distance);
    }

    @Override
    public boolean scrollDown(Integer distance) {
        return Moveable.super.scrollDown(distance);
    }
}