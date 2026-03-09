package OOP.Inheritance;

public class Car extends Vehicle
{
    String carBrand;

    @Override
    void print()
    {
        System.out.println(vehicleType + " " + vehicleYear + " " + carBrand);
    }
}
