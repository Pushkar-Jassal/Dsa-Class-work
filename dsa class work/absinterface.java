interface Vehicle {
    void start();
    void stop();
    void fuelType();
}
class ElectricCar implements Vehicle {
    String brand;

    ElectricCar(String brand) {
        this.brand = brand;
    }

    @Override
    public void start() {
        System.out.println(brand + " start");
    }

    @Override
    public void stop() {
        System.out.println(brand + " stop");
    }

    @Override
    public void fuelType() {
        System.out.println(brand + " uses electricity.");
    }

    void displayBrand() {
        System.out.println("Car brand: " + brand);
    }
}

public class absinterface {
    public static void main(String[] args) {
        ElectricCar myCar = new ElectricCar("Tesla");
        myCar.displayBrand();
        myCar.start();
        myCar.stop();
        myCar.fuelType();
    }
}