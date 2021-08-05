
// Recursion for Linked List

public class _37_206_Reverse_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        // TH co so
        if(head == null)
            return null;

        ListNode nextNode = head.next;
        // TH 1 node
        if(nextNode == null)
            return head;

        // TH TQ
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;

        return newHead;
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
        ListNode newHead = reverseList(n1);
        printLinkedList(newHead);
    }
}
