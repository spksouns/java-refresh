package Collections.StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Examples
{
    private static Stack<String> universalStack;
    private static Queue<String> universalQueue;

    public static void main(String args[])
    {
        intialize();
        print();
    }

    private static void intialize()
    {
        universalStack = new Stack<>();
        universalQueue = new LinkedList<>();

        universalStack.add("India");
        universalStack.add("USA");
        universalStack.add("Kenya");


        universalQueue.add("India");
        universalQueue.add("USA");
        universalQueue.add("Kenya");
    }

    private static void print()
    {
        while(!universalStack.isEmpty())
        {
            System.out.println(universalStack.peek());
            System.out.println(universalStack.pop());
        }

        while(!universalQueue.isEmpty())
        {
            System.out.println(universalQueue.peek());
            System.out.println(universalQueue.poll());
        }
    }
}
