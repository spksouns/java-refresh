package OOP.Abstraction;

public class Car extends Vehicle implements Transform
{
    String carModel;
    @Override
    public void transform() {
        System.out.println(vehicleType + " " + vehicleModel + " " + carModel + " has been transformed");
    }

    @Override
    void start() {
        System.out.println(vehicleType + " " + vehicleModel + " " + carModel + " has been started");
    }
}
