package DSA.LeetCodeExamples;

public class BinarySearch
{
    public static void main(String args[])
    {
        System.out.println(binarySearchTheTarget(new int[]{1, 2, 3, 5, 7, 9, 12, 32}, 32));
    }

    private static int binarySearchTheTarget(int[] values, int target)
    {
        int left = 0;
        int right = values.length - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(values[mid] == target)
            {
                return mid;
            }
            if(values[mid] > target)
            {
                right = mid - 1;
            }
            if(values[mid] < target)
            {
                left = mid + 1;
            }
        }

        return -1;
    }
}
