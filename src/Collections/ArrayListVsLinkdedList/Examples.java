package Collections.ArrayListVsLinkdedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Examples
{
    public static void main(String args[])
    {
        arrayVsLinkedList();
        Scanner inputFetcher = new Scanner(System.in);
        String neededCountryName = "";
        int neededCountryIndex = -1;
        System.out.println("ArrayList Example :");
        arrayList(neededCountryName, neededCountryIndex);
        System.out.println("LinkedList Example :");
        linkedList(neededCountryName, neededCountryIndex);

        System.out.println("So let's fetch any country index you like ? please enter it here : " );
        neededCountryName = inputFetcher.nextLine();
        arrayList(neededCountryName, neededCountryIndex);
        linkedList(neededCountryName, neededCountryIndex);

        neededCountryName = "";

        System.out.println("So now let's try the other way tell me the index i'll fetch you the country : ");
        neededCountryIndex = inputFetcher.nextInt();
        arrayList(neededCountryName, neededCountryIndex);
        linkedList(neededCountryName, neededCountryIndex);

    }

    private static void arrayList(String country, int countryIndex)
    {
        ArrayList<String> countries = new ArrayList<>();
        addDataToList(countries);
        System.out.println(countries);
        fetchingOperations(countries, country, countryIndex);
        countries.addFirst("Japan");
        System.out.println(countries);
    }

    private static void linkedList(String country, int countryIndex)
    {
        LinkedList<String> countries = new LinkedList<>();
        addDataToList(countries);
        System.out.println(countries);
        fetchingOperations(countries, country, countryIndex);
        countries.addFirst("Japan");
        System.out.println(countries);
    }


    private static int findTheCountryIndex(List<String> countries, String neededCountryName)
    {
        int countryIndex = -1;
        int countriesLength =  countries.size();
        for(int countriesIndex = 0; countriesIndex < countriesLength; countriesIndex++)
        {
            if(neededCountryName.equals(countries.get(countriesIndex)))
            {
                countryIndex = countriesIndex + 1;
                break;
            }
        }
        return countryIndex;
    }

    private static void addDataToList(List<String> countries)
    {
        countries.add("India");
        countries.add("USA");
        countries.add("Russia");
        countries.add("UK");
        countries.add("China");
    }

    private static void fetchingOperations(List<String> countries, String country, int countryIndex)
    {
        int countriesLen = countries.size();
        if(!country.isEmpty())
        {
            int neededCountryIndex = findTheCountryIndex(countries, country);
            System.out.println(neededCountryIndex != -1 ? neededCountryIndex : "there is no country in this you have been searching for");
        }
        if(countryIndex != -1 && countryIndex !=0 && countryIndex < countriesLen)
        {
            System.out.println(countries.get(countryIndex -1));
        }
        else if(countryIndex > countriesLen)
        {
            System.out.println("Please enter the index that is within our available list, the maximum length of the list is : " + countries.size());
        }
    }


    private static void arrayVsLinkedList()
    {
        ArrayList<String> arrayCountries = new ArrayList<>();
        addAMillionElements(arrayCountries);
        long arrayBeforeAddFirstTime = System.nanoTime();
        arrayCountries.addFirst("Japan");
        long arrayAfterAddFirstTime = System.nanoTime();
        LinkedList<String> linkedCountries = new LinkedList<>();
        addAMillionElements(linkedCountries);
        long linkedAddBeforeFirstTime = System.nanoTime();
        linkedCountries.addFirst("Japan");
        long linkedAddAfterFirstTime = System.nanoTime();
        System.out.println(linkedAddAfterFirstTime - linkedAddBeforeFirstTime);
        System.out.println(arrayAfterAddFirstTime - arrayBeforeAddFirstTime);
    }

    private static void addAMillionElements(List<String> countries)
    {
        for(int countryIndex = 0; countryIndex < 1000000; countryIndex++)
        {
            countries.add("One " + countryIndex + 1);
        }
    }
}
