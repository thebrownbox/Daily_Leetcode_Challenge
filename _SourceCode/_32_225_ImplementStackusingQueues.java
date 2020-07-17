/*
https://leetcode.com/problems/implement-stack-using-queues/
225. Implement Stack using Queues [Easy]
Tags: #Stack, #Queue
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _32_225_ImplementStackusingQueues {
    static class MyStack {
        Queue<Integer> mainQueue = new LinkedList<>(); // Q1
        Queue<Integer> secondQueue = new LinkedList<>(); // Q2

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            mainQueue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int value = -1;
            // Chuyen main -> second
            while (mainQueue.isEmpty() == false){
                if(mainQueue.size() == 1){
                    value = mainQueue.remove();
                }else{
                    secondQueue.add(mainQueue.remove());
                }
            }

            // Doi cho main va second
            Queue<Integer> temp = mainQueue;
            mainQueue = secondQueue;
            secondQueue = temp;

            return value;
        }

        /** Get the top element. */
        public int top() {
            int value = -1;
            // Chuyen main -> second
            while (mainQueue.isEmpty() == false){
                if(mainQueue.size() == 1){
                    value = mainQueue.remove();
                    secondQueue.add(value);
                }else{
                    secondQueue.add(mainQueue.remove());
                }
            }

            // Doi cho main va second
            Queue<Integer> temp = mainQueue;
            mainQueue = secondQueue;
            secondQueue = temp;

            return value;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return mainQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.push(5);
        stack.pop();
    }
}
