/**
 * 21. Merge Two Sorted Lists [E]
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Tags: #LinkedList
 */
import java.util.List;

public class _60_21_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        ListNode temp = null;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val){// CHon l1
                if(head == null){ // First time
                    head = l1;
                    temp = l1;
                }else{ // Not the first time
                    temp.next = l1;
                    temp = l1;
                }
                l1 = l1.next;
            }else{// Chon l2
                if(head == null){ // First time
                    head = l2;
                    temp = l2;
                }else{ // Not the first time
                    temp.next = l2;
                    temp = l2;
                }
                l2 = l2.next;     
            }

            if(l1 != null) temp.next = l1;
            if(l2 != null) temp.next = l2;
        }

        return head;
    }

    public static void main(String[] args) {
    }
}
