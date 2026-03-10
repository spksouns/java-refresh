package DSA.LeetCodeExamples.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram
{
    public static void main(String args[])
    {
        System.out.println(isAnagram("cat", "act"));
    }

    private static boolean isAnagram(String s, String t)
    {
        s = getSortedString(s);
        t = getSortedString(t);
        return s.equals(t);
    }

    private static String getSortedString(String s)
    {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        return new String(s1);
    }

    private static boolean theOtherWay(String s, String t)
    {
        if(s.length() != t.length())
        {
            return false;
        }
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(int charIndex = 0; charIndex < s.length(); charIndex++)
        {
            if(countMap.containsKey(s.charAt(charIndex)))
            {
                countMap.put(s.charAt(charIndex), countMap.get(s.charAt(charIndex)) + 1);
            }
            else
            {
                countMap.put(s.charAt(charIndex), 1);
            }
        }
        for(int charIndex = 0; charIndex < s.length(); charIndex++)
        {
            if(!countMap.containsKey(t.charAt(charIndex)))
            {
                return false;
            }
            countMap.put(t.charAt(charIndex), countMap.get(t.charAt(charIndex)) - 1);
        }
        for(Integer count: countMap.values())
        {
            if(!count.equals(0))
            {
                return false;
            }
        }
        return true;
    }
}
