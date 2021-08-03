import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * StackQueueJava
 */
public class StackQueueJava {
    public void ExQueue()
    {
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        for (Integer integer : myQueue) {
            System.out.println(integer);
        }

        System.out.println("IsEmpty: " + myQueue.isEmpty());
        System.out.println("Peek: " + myQueue.peek());
        System.out.println("Remove: " + myQueue.remove());

        System.out.println("Peek: " + myQueue.peek());
        System.out.println("Remove: " + myQueue.remove());

        System.out.println("Peek: " + myQueue.peek());
        System.out.println("Remove: " + myQueue.remove());

        System.out.println("IsEmpty: " + myQueue.isEmpty());
        // for (Integer integer : myQueue) {
        //     System.out.println(integer);
        // }
    }

    public void ExStack()
    {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        for (Integer integer : myStack) {
            System.out.println(integer);
        }

        System.out.println("peek: " + myStack.peek());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("peek: " + myStack.peek());

        System.out.println("IsEmpty: " + myStack.isEmpty());
    }

    public static void main(String[] args) {

    }

}