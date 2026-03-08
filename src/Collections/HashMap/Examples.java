package Collections.HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Examples
{
    private static HashMap<String, Integer> univerSalMap;
    private final Scanner inputFetcher = new Scanner(System.in);
    public static void main(String args[])
    {
        intialize();
        print();
        fetch();
        proveCollision();
        modify();
    }

    private static void intialize()
    {
        univerSalMap = new HashMap<>();
        univerSalMap.put("India", 1);
        univerSalMap.put("US", 2);
        univerSalMap.put("Kenya", 3);
        univerSalMap.put("Aa", 4);
        univerSalMap.put("BB", 5);
    }

    private static void print()
    {
        System.out.println(univerSalMap);
    }

    private static void fetch()
    {
       System.out.println("Can we fetch position of your country? enter your country name right here :");
       String country = inputFetcher.nextLine();
       Integer position = univerSalMap.get(country);
       System.out.println(position == null ? "Sorry your country doesn't exist in this list" : "Your country's ( " + country + ") position is " + position);
    }

    private static void proveCollision()
    {
        System.out.println("Now we are going to prove that HashMap has collision in it :");
        iterate();
        System.out.println("Can you find the values with same hashCode ?");
    }

    private static void iterate()
    {
        for(Map.Entry<String, Integer> entry : univerSalMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue() + " " + entry.getKey().hashCode() + " " + entry.getValue().hashCode());
        }
    }

    private static void modify()
    {
        System.out.println("Do you need to update your country's position ? If so please enter the country name and the position to be updated");
        String country = inputFetcher.nextLine();
        int position = inputFetcher.nextInt();
        inputFetcher.nextLine();
        univerSalMap.put(country, position);
        print();
        System.out.println("Shall we check whether your country present in this list? If so please enter you country's name right here :");
        country = inputFetcher.nextLine();
        System.out.println(univerSalMap.containsKey(country) ? "Yes you'r country is there is in the list" : "Sorry your cuntry is not in the list");
        System.out.println("Do you need to replace your country's poistion ? if so enter the desiered position and your country's name:");
        country = inputFetcher.nextLine();
        position = inputFetcher.nextInt();
        inputFetcher.nextLine();
        univerSalMap.replace(country, position);
        print();
        System.out.println("Do you need to remove your country from the list ? If so please enter your country's name right here :");
        country = inputFetcher.nextLine();
        univerSalMap.remove(country);
        print();
    }
}
