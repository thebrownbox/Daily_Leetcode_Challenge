import java.util.List;

/*
https://leetcode.com/problems/odd-even-linked-list/
328. Odd Even Linked List [Medium]
Tags: Linked List
 */
public class _23_328_Odd_Even_Linked_List
{
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {  val = x; next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public static ListNode oddEvenList(ListNode head)
    {
        int index = 1;
        ListNode curNode = head;
        ListNode theLastOddNode = null;
        ListNode theLastEvenNode = null;

        while(curNode != null)
        {
            ListNode nextNode = curNode.next;

            if(index == 1)
                theLastOddNode = curNode;
            else if(index == 2)
                theLastEvenNode = curNode;

            if(index > 2)
            {
                if(index%2 != 0) // odd node ==> insert node
                {
                    curNode.next = theLastOddNode.next;
                    theLastOddNode.next = curNode;
                    theLastEvenNode.next = nextNode;
                }
                else {// event node => Update LO LE
                    theLastEvenNode = theLastEvenNode.next;
                    theLastOddNode = theLastOddNode.next;
                }
            }

            index++;
            curNode = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4;

        oddEvenList(n1);
    }
}
