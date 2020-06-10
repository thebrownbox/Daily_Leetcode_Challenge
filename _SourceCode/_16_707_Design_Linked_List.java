public class _16_707_Design_Linked_List {

    public static class SinglyListNode
    {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) { val = x; }
    }


    static class  MyLinkedList {

        // head luon tro vao dau list
        private SinglyListNode head;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = null;
        }

        /** Get the value of the index-th node in the linked list.
         * If the index is invalid, return -1. */
        public int get(int index) {
            SinglyListNode tempNode = head;
            int count = 0;

            while (tempNode != null)
            {
                if(count == index)
                {
                    return tempNode.val;
                }
                count++;
                tempNode = tempNode.next;
            }
            return -1;
        }

        /** Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            SinglyListNode newNode = new SinglyListNode(val);
            newNode.next = head;
            head = newNode;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            SinglyListNode lastNode = head;
            while (lastNode != null)
            {
                // Xac dinh last node
                if(lastNode.next == null)
                {
                    SinglyListNode newNode = new SinglyListNode(val);
                    lastNode.next = newNode;
                    return;
                }
                lastNode = lastNode.next;
            }
        }

        /** Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list,
         * the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index == 0)
            {
                addAtHead(val);
            }
            else
            {
                SinglyListNode cur = head;
                SinglyListNode newNode = new SinglyListNode(val);
                int count = 0;

                while (cur != null)
                {
                    if(count == (index-1))
                    {
                        newNode.next = cur.next;
                        cur.next = newNode;
                        return;
                    }
                    count++;
                    cur = cur.next;
                }

                if(count == index)
                {
                    addAtTail(val);
                }
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index)
        {
            SinglyListNode cur = head;
            SinglyListNode prev = null;
            int count = 0;

            while (cur != null)
            {
                if(count == index)
                {
                    if(index == 0)
                    {
                        head = head.next;
                    }
                    else
                    {
                        prev.next = cur.next;
                        return;
                    }
                }
                count++;
                prev = cur;
                cur = cur.next;
            }
        }

        public void printList()
        {
            SinglyListNode temp = head;
            System.out.printf("List: ");

            while (temp != null)
            {
                System.out.printf("%d ", temp.val);
                temp = temp.next;
            }
            System.out.println();
        }

    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        linkedList.addAtHead(1); linkedList.printList();
        linkedList.addAtTail(3); linkedList.printList();
        linkedList.addAtIndex(1, 2);  linkedList.printList();// linked list becomes 1->2->3
        linkedList.get(1);            // linkedList.printList();returns 2
        linkedList.deleteAtIndex(1); linkedList.printList(); // linkedList.printList();now the linked list is 1->3
        linkedList.get(1);
    }
}
