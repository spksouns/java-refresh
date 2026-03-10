package DSA.LeetCodeExamples.TwoSum;

import java.util.HashSet;

public class ContainsDuplicate
{
    public static void main(String args[])
    {
        int[] nums = new int[]{3,4};
        System.out.println(theOtherWay(nums));
        System.out.println(theUsualWay(nums));
    }

    private static boolean theUsualWay(int[] nums)
    {
        int numsLen = nums.length;
        for(int numsIndex = 0; numsIndex < numsLen; numsIndex++)
        {
            for(int innerNumsIndex = numsIndex + 1; innerNumsIndex < numsLen; innerNumsIndex++)
            {
                if(nums[numsIndex] == nums[innerNumsIndex])
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean theOtherWay(int[] nums)
    {
        int numsLen = nums.length;
        HashSet<Integer> uniqueNums = new HashSet<>();
        for(int numsIndex = 0; numsIndex < numsLen; numsIndex++)
        {
            if(uniqueNums.contains(nums[numsIndex]))
            {
                return true;
            }
            uniqueNums.add(nums[numsIndex]);
        }
        return false;
    }
}
