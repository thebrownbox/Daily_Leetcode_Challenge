/*
https://leetcode.com/problems/valid-parentheses/
20. Valid Parentheses [Easy]
Tags: Stack, Linked List
 */
public class _29_20_ValidParentheses {

    static class MyStack{
        class Node{
            Node next;
            char value;
            Node(char v){
                value = v;
                next = null;
            }
        }

        Node topNode;
        public void push(char value){
            Node newNode = new Node(value);

            if(isEmpty() == false)
                newNode.next = topNode;

            topNode = newNode;
        }

        public char pop(){
            char value = topNode.value;
            topNode = topNode.next;
            return value;
        }

        public boolean isEmpty(){
            return topNode == null;
        }

    }


    public static boolean isValid(String s) {
        MyStack stack = new MyStack();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            if(curChar == '(' || curChar == '[' || curChar == '{')
            {
                stack.push(curChar);
            }
            else
            {
                if(stack.isEmpty())
                    return false;

                char prevChar = stack.pop();
                if((prevChar == '(' && curChar == ')')
                    || (prevChar == '[' && curChar == ']')
                    || (prevChar == '{' && curChar == '}'))
                {
                    // ok
                }
                else
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}]";
        System.out.println(isValid(s));
    }
}
