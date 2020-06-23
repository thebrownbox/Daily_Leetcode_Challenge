/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
ID: 19
Name: Remove Nth Node From End of List
Tags: Linked List
 */


import java.util.List;

public class _20_19_Remove_Nth_Node_From_End_of_List
{
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode curNode = head;
        ListNode theWantedNode = null;
        int count = 1;

        while (curNode != null)
        {
            if(count == n+1)
            {
                theWantedNode = head;
            }

            // The Last Node
            if(curNode.next == null)
            {
                if(theWantedNode == null)
                {
                    if(count == n)
                        return head.next;
                    return head;
                }
                else
                {
                    if(theWantedNode.next != null)
                        theWantedNode.next = theWantedNode.next.next;

                    return head;
                }
            }

            count++;
            curNode = curNode.next;
            theWantedNode = theWantedNode == null ? null : theWantedNode.next;
        }


        return head;
    }

    public static void main(String[] args) {


    }
}
