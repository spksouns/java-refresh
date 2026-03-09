package OOP.Abstraction;

public abstract class Vehicle {
    String vehicleType;

    Integer vehicleModel;

    void print() {
        System.out.println(vehicleType + " " + vehicleModel);
    }

    abstract void start();
}
