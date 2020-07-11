import java.util.SimpleTimeZone;

/*
https://leetcode.com/problems/design-circular-queue/
622. Design Circular Queue [Medium]
Tags: Array, Queue
 */
public class _28_622_DesignCircularQueue {

    static class MyCircularQueue{
        int[] array;
        int SIZE;
        int headIndex;
        int tailIndex;
        int count; // Current number of elements

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            SIZE = k;
            array = new int[SIZE];
            headIndex = tailIndex = -1;
            count = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(isFull() == true)
                return false;

            tailIndex++;
            if(tailIndex == SIZE)
                tailIndex = 0;
            if(isEmpty() == true)
                headIndex = tailIndex;
            array[tailIndex] = value;
            count++;

            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty() == true)
                return false;
            headIndex++;
            if(headIndex == SIZE)
                headIndex = 0;
            count--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return isEmpty() ? -1 : array[headIndex];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return isEmpty() ? -1 : array[tailIndex];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return count <= 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return count >= SIZE;
        }
    }



    public static void main(String[] args) {
        MyCircularQueue myQueue = new MyCircularQueue(3);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.deQueue();
        myQueue.enQueue(4);

    }
}
