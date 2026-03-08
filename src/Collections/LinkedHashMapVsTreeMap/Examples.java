package Collections.LinkedHashMapVsTreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Examples
{
    private static HashMap<String, Integer> universalHashMap;
    private static LinkedHashMap<String, Integer> universalLinkedHashMap;
    private static TreeMap<String, Integer> universalTreeMap;
    public static void main(String args[])
    {
        intialize();
        print();
    }

    private static void intialize()
    {
        universalHashMap = new HashMap<>();
        universalLinkedHashMap = new LinkedHashMap<>();
        universalTreeMap = new TreeMap<>();

        insertData(universalHashMap);
        insertData(universalLinkedHashMap);
        insertData(universalTreeMap);
    }

    private static void print()
    {
        System.out.println(universalHashMap);
        System.out.println(universalLinkedHashMap);
        System.out.println(universalTreeMap);
    }

    private static void insertData(Map<String, Integer> parentOfAllMap)
    {
        parentOfAllMap.put("India", 1);
        parentOfAllMap.put("USA", 2);
        parentOfAllMap.put("Kenya", 3);
        parentOfAllMap.put("Congo", 4);
        parentOfAllMap.put("Lebanon", 5);
    }

}
