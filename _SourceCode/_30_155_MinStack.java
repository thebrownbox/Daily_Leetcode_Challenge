/*
https://leetcode.com/problems/min-stack/
155. Min Stack [Easy]
Tags: Stack
 */

import java.util.Stack;

public class _30_155_MinStack {
    static class MinStack {
        class Node{
            int value;
            int MIN;
            Node(int value) { this.value = value; }
        }

        Stack<Node> stack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            Node newNode = new Node(x);
            newNode.MIN = stack.isEmpty() ? x : Math.min(x, stack.peek().MIN);
            stack.add(newNode);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return stack.peek().MIN;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(0);
        minStack.push(2);
        minStack.push(-1);
    }
}
