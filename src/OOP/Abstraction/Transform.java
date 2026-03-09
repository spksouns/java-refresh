package OOP.Abstraction;

public interface Transform
{
    void transform();

    default void untransform()
    {
        System.out.println("Untransformed");
    }
}
