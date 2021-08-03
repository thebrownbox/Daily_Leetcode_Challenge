public class MyLinkedListQueue implements IStackQueue{

    public class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    Node headNode, tailNode;

    MyLinkedListQueue(){
        headNode = tailNode = null;
    }

    @Override
    public boolean push(int value) {
        if(isFull()){
            return false;
        }

        Node newNode = new Node(value);
        if(isEmpty()){
            headNode = tailNode = newNode;
        }else{
            tailNode.next = newNode;
            tailNode = newNode;
        }

        return true;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int value = headNode.value;

        if(headNode == tailNode){
            headNode = tailNode = null;
        }else{
            headNode = headNode.next;
        }

        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (headNode == null && tailNode == null);
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return;
        }

        Node curNode = headNode;
        while(curNode != null){
            System.out.print(curNode.value + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }
    
}
