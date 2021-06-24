/**
 * 23. Merge k Sorted Lists [H]
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Tags: #LinkedList
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _61_23_Merge_k_Sorted_Lists {

    public ListNode merge2LinkedList(ListNode l1, ListNode l2){
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

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> tempArr = new ArrayList<>();
        List<ListNode> listResult = Arrays.asList(lists);

        while(listResult.size() > 1){
            for (int i = 0; i < listResult.size(); i += 2) {
                ListNode l1 = listResult.get(i);
                ListNode l2 = (i+1) < listResult.size() ? listResult.get(i+1) : null;
                ListNode result = merge2LinkedList(l1, l2);
                tempArr.add(result);
            }
            listResult = tempArr;
        }

        if(listResult.size() == 0)
            return null;

        return listResult.get(0);
    }

    public static void main(String[] args) {
    }
}
