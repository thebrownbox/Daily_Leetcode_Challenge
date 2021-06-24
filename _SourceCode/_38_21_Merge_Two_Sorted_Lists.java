
// Recursion for Linked List

public class _38_21_Merge_Two_Sorted_Lists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    // Merge l1 to l2
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dieu kien dung | DKCS
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // THTQ
        if(l1.val <= l2.val){// Lay 1 phan tu cua L1
            ListNode nextL1 = l1.next;
            ListNode nextElement = mergeTwoLists(nextL1, l2);
            l1.next = nextElement;
            return l1;
        }else{ // Lay 1 phan tu cua l2
            mergeTwoLists(l2, l1);
            return l2;
        }
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
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        n1.next = n2; n2.next = n3;

        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(4);
        ListNode L3 = new ListNode(6);
        L1.next = L2; L2.next = L3;

//        printLinkedList(n1);
//        printLinkedList(L1);

        ListNode newList = mergeTwoLists(n1, L1);
        printLinkedList(newList);
    }
}
