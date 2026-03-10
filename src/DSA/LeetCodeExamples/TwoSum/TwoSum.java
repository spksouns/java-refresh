package DSA.LeetCodeExamples.TwoSum;

import java.util.HashMap;

public class TwoSum
{
    public static void main(String args[])
    {
        int[] samArray = new int[]{3,3};
        int[] resultArray = theDifferentWay(samArray, 6);
        for(int result : resultArray)
        {
            System.out.println(result);
        }
    }

    private static int[] theUsualWay(int[] nums, int target)
    {
        int numsLen = nums.length;
        int[] resultArray = new int[2];
        for(int numsIndex = 0; numsIndex < numsLen; numsIndex++)
        {
            for(int internalIndex = numsIndex + 1; internalIndex < numsLen; internalIndex++)
            {
                if(nums[numsIndex] + nums[internalIndex] == target)
                {
                    resultArray[0] = numsIndex;
                    resultArray[1] = internalIndex;
                }
            }
        }
        return resultArray;
    }

    private static int[] theDifferentWay(int[] nums, int target)
    {
        int numsLen = nums.length;
        int[] resultArray = new int[2];

        HashMap<Integer, Integer> numsVsIndex = new HashMap<>();

        for(int numsIndex = 0; numsIndex < numsLen; numsIndex++)
        {
            numsVsIndex.put(nums[numsIndex], numsIndex);
        }

        for(int numsIndex = 0; numsIndex < numsLen; numsIndex++)
        {
            int neededNumber = target - nums[numsIndex];
            if(numsVsIndex.containsKey(neededNumber) && numsVsIndex.get(neededNumber) != numsIndex)
            {
                resultArray[0] = numsIndex;
                resultArray[1] = numsVsIndex.get(neededNumber);
            }
        }

        return resultArray;
    }
}
