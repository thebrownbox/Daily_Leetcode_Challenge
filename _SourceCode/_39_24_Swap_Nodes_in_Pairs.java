

// Recursion for Linked List


import java.util.List;

public class _39_24_Swap_Nodes_in_Pairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {
        // THCS
        if(head == null) return null;
        if(head.next == null) return head;

        // THTQ
        ListNode nextNode = head.next;
        // Swap head & nextNode
        head.next = nextNode.next;
        nextNode.next = head;

        // Xu ly bai toan con
        ListNode newHead = swapPairs(head.next);
        // Noi bai toan hien tai, vao bai toan con
        head.next = newHead;

        return nextNode;
    }

    public  static void printLinkedList(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4;

        printLinkedList(n1);
        ListNode newList = swapPairs(n3);
        printLinkedList(newList);
    }


}
