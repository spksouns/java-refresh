package java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Examples
{
    private static List<String> countries;
    public static void main(String args[])
    {
        initialize();
        print(countries);
        operations();
    }

    private static void initialize()
    {
        countries = new ArrayList<>();
        countries.add("Indianaaaa");
        countries.add("UK");
        countries.add("USA");
        countries.add("Congo");
        countries.add("Kenya");
    }

    private static void operations()
    {
        print(countries.stream().filter(country -> country.length() > 5).toList());
        print(countries.stream().map(country -> country.toUpperCase()).toList());
        print(countries);
        print(countries.stream().sorted().toList());
        countries.stream().forEach(country -> System.out.println(country));
        System.out.println(countries.stream().filter(country -> country.length() > 5).count());
        String firstCountry = countries.stream().filter(country -> country.length() > 5).findFirst().orElse("No Country matched");
        System.out.println(firstCountry);
    }

    private static void print(List<String> countries)
    {
        System.out.println(countries);
    }
}
