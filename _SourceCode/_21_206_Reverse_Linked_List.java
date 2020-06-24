/*
https://leetcode.com/problems/reverse-linked-list/
206. Reverse Linked List
Tags:  Linked List
*/

public class _21_206_Reverse_Linked_List
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode curNode = head;

        while (curNode != null && curNode.next != null)
        {
            ListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }

        return head;
    }

    public static void printLinkedList(ListNode head)
    {
        while (head != null)
        {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2; a2.next = a3;

        printLinkedList(a1);
        ListNode newList = reverseList(a1);
        printLinkedList(newList);
    }
}
