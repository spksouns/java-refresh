package DSA.LeetCodeExamples.LinkedList;

public class FloydAlgorithm
{
    private static ListNode listNode;
    public static void main(String args[])
    {
        generateValuesForLinkedList(new int[]{1,2,3,4,5});
        printResult();
        generateValuesForLinkedList(new int[]{1,2,6,4,5});
        printResult();
    }

    //generates the values for linked list
    private static void generateValuesForLinkedList(int[] values)
    {
        ListNode prevNode = new ListNode(0);
        ListNode currNode = prevNode;
        ListNode circularNode = null;
        for(int value : values)
        {
            currNode.next = new ListNode(value);
            currNode = currNode.next;
            if(value == 3) {
                circularNode = currNode;
            }
        }
        currNode.next = circularNode;
        listNode = prevNode.next;
    }

    //detects whether the given Linked List is cyclic or not
    private static boolean isItCylicLinkedList()
    {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return true;
            }
        }
        return false;
    }

    //prints the message or linked list based on the given list
    private static void printResult()
    {
        if(isItCylicLinkedList())
        {
            System.out.println("Cyclic list can't be printed sorry !");
        }
        else
        {
            printLinkedList();
        }
    }
    // prints the linkedlist
    private static void printLinkedList()
    {
        while(listNode != null)
        {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
