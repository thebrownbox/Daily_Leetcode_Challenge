import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists [H]
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Tags: #LinkedList
 */

public class _62_23_Merge_k_Sorted_Lists {
    
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (Integer.compare(a.val, b.val)));
        for (ListNode headListNode : lists) {
            if(headListNode != null){
                queue.add(headListNode);
            }
        }

        ListNode head = null;
        ListNode lastNode = null;
        while(queue.isEmpty() == false){
            ListNode curNode = queue.poll();
            if(head == null){
                head = curNode;
            }else{
                lastNode.next = curNode;
            }
            ListNode nextNode = curNode.next;
            if(nextNode != null){
                queue.add(nextNode);
            }

            lastNode = curNode;
        }

        return head;
    }


    public static void main(String[] args) {
    }
}
