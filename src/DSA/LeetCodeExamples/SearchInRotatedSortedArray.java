package DSA.LeetCodeExamples;

public class SearchInRotatedSortedArray
{
    public static void main(String args[])
    {
        System.out.println(binarySearchTheTarget(new int[]{9, 11, 13, 1, 3, 5, 7}, 3));
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
            if(values[left] <= values[mid])
            {
                if(target >= values[left] && target <= values[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                if(target >= values[mid] && target <= values[right])
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
