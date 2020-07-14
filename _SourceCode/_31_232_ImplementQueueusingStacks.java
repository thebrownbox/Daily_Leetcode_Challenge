/*
https://leetcode.com/problems/implement-queue-using-stacks/
232. Implement Queue using Stacks [Easy]
Tags: Stack, Queue
 */

import java.util.Stack;

public class _31_232_ImplementQueueusingStacks {

    class MyQueue {
        Stack<Integer> mainStack = new Stack<>(); // s1
        Stack<Integer> reverseStack = new Stack<>(); //s2
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            mainStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(reverseStack.isEmpty())
                while (mainStack.isEmpty() == false)
                    reverseStack.push(mainStack.pop());
            return reverseStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(reverseStack.isEmpty())
                while (mainStack.isEmpty() == false)
                    reverseStack.push(mainStack.pop());
            return reverseStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mainStack.isEmpty() && reverseStack.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
