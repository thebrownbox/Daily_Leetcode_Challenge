/*
https://leetcode.com/problems/palindrome-linked-list/
234. Palindrome Linked List [Easy]
Tags: Linked List
 */

import java.awt.*;

public class _26_234_Palindrome_Linked_List {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {  val = x; next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static int count(ListNode head)
    {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }

    public static ListNode reverse(ListNode head)
    {
        ListNode lastNode = head;

        while (lastNode != null && lastNode.next != null)
        {
            ListNode nextNode = lastNode.next;
            lastNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }

        return head;
    }

    public static boolean isPalindrome(ListNode head) {
        int n = count(head);
        int k = n/2;

        if(k == 0)
            return true;

        int index = 0;
        ListNode curNode = head;

        // 1->2 (2/2 = 1)
        // 1 -> 2 -> 3 (3/2 = 1) => k+1
        // 1 -> 2 -> 3 -> 4 (4/2 = 2) => k
        // 1 2 3 4 5 -> (5/2 = 2) -> 3
        while (curNode != null)
        {

            if(index == (n%2 == 0 ? k : (k+1)))
            {
                break;
            }
            index++;
            curNode = curNode.next;
        }

        ListNode the2ndList = reverse(curNode);
        index = 0;
        while (index < k)
        {
            if(head.val != the2ndList.val)
                return false;
            head = head.next;
            the2ndList = the2ndList.next;
            index++;
        }


        return true;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);

        n1.next = n2; //n2.next = n3;

        System.out.println(isPalindrome(n1));


    }
}
