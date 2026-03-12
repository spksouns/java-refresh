package DSA.LeetCodeExamples.LinkedList;

public class ReverseLinkedList {
    private static ListNode listNode;

    public static void main(String args[]) {
        generateValuesForLinkedList(new int[]{1,2,3,4,5,7,8,9});
        System.out.println("Initial Linked List");
        printLinkedList();
        reverseLinkedList();
        System.out.println("After Reversing the Linked List");
        printLinkedList();
    }

    // Reverse the Linked List using three pointers
    private static ListNode reverseLinkedList() {
        ListNode prevNode = null;
        ListNode currNode = listNode;
        ListNode nextNode;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        listNode = prevNode;
        return prevNode;
    }

    // generates different values for the Linked List
    public static void generateValuesForLinkedList(int[] vals)
    {
        ListNode prevNode = new ListNode(0);
        ListNode currNode = prevNode;
        for(int val : vals)
        {
            currNode.next = new ListNode(val);
            currNode = currNode.next;
        }
        listNode = prevNode.next;
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
