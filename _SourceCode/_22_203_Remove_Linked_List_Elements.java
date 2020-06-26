/*
URL: https://leetcode.com/problems/remove-linked-list-elements/
203. Remove Linked List Elements
Tags: Linked List
*/

public class _22_203_Remove_Linked_List_Elements {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {  val = x; next = null; }
    }

    public static ListNode removeElements(ListNode head, int val)
    {
        ListNode curNode = head;
        ListNode prevNode = null;

        while (curNode != null)
        {
            boolean bFound = false;
            // Remove current node
            if(curNode.val == val)
            {
                bFound = true;
                if(prevNode == null)
                {
                    head = curNode.next;
                }
                else
                {
                    prevNode.next = curNode.next;
                }
            }

            prevNode = bFound == true ? prevNode : curNode;
            curNode = curNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        a1.next = a2;

        removeElements(a1, 1);
    }
}
