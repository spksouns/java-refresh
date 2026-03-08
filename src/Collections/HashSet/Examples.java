package Collections.HashSet;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Examples
{
    private static HashSet<String> universalSet;
    private static Scanner inputFetcher = new Scanner(System.in);

    public static void main(String args[])
    {
        intialize();
        print();
        fetch();
        iterate();
    }

    private static void intialize()
    {
        universalSet = new HashSet<>();
        universalSet.add("India");
        universalSet.add("USA");
        universalSet.add("Congo");
        universalSet.add("Kenya");
        //this operation doesn't have any impact because set doesn't support duplicate values
    }

    private static void print()
    {
        System.out.println(universalSet);
    }

    private static void fetch()
    {
        System.out.println("Don't find your country in the list ? If so enter your country's name right here i'll add it for you : ");
        String country = inputFetcher.nextLine();
        boolean isCountryAdded = !universalSet.contains(country) ? universalSet.add(country) : false;
        System.out.println(isCountryAdded ? "Your Country has been successfully added in the list" : "Seems your country is already in the list");
        print();
        System.out.println("Want to remove any of the country let me know right here : ");
        country = inputFetcher.nextLine();
        boolean isCountryRemoved = universalSet.contains(country) ? universalSet.remove(country) : false;
        System.out.println(isCountryRemoved ? "Your Country has been successfully removed from the list" : "Seems your country is not in the list");
        print();
    }

    private static void iterate()
    {
        for(String country : universalSet)
        {
            System.out.println(country);
        }
    }
}
