abstract class Car {
    String brand;

    Car(String brand) {
        this.brand = brand;
    }

    void displayBrand() {
        System.out.println("Car brand: " + brand);
    }

    abstract void start();
    abstract void stop();
    abstract void fuelType();
}

class PetrolCar extends Car {

    PetrolCar(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(brand + " Start");
    }

    @Override
    void stop() {
        System.out.println(brand + " Stop");
    }

    @Override
    void fuelType() {
        System.out.println(brand + " petrol");
    }
}
public class abs {
    public static void main(String[] args) {
        Car myCar = new PetrolCar("Honda City");
        myCar.displayBrand();
        myCar.start();
        myCar.stop();
        myCar.fuelType();
    }
}