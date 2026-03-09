package OOP.Abstraction;

public class Examples
{
    public static void main(String args[])
    {
        Car car = new Car();
        car.vehicleType = "car";
        car.vehicleModel = 2025;
        car.carModel = "Hyundai";

        car.print();
        car.start();
        car.transform();
        car.untransform();
    }
}
