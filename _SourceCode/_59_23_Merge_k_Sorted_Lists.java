
/**
 * 23. Merge k Sorted Lists [H]
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Tags: #LinkedList
 */

public class _59_23_Merge_k_Sorted_Lists {
    public ListNode addNodeToList(ListNode head, ListNode newNode)
    {
        newNode.next = null;
        if(head == null){
            return newNode;
        }

        ListNode prevNode = null;
        ListNode curNode = head;
        // dung lai khi newNode.val <= curNode
        while(curNode != null && newNode.val > curNode.val){
            prevNode = curNode;
            curNode = curNode.next;
        }

        if(prevNode == null){ // add newNode to head
            newNode.next = curNode;
            head = newNode;
        }else{
            if(curNode == null){ // add newNode to tail
                prevNode.next = newNode;
            }else{ // add vao giua prevNode va curNode
                newNode.next = curNode;
                prevNode.next = newNode;
            }
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultList = null;
        for (int i = 0; i < lists.length; i++) {
            ListNode headNode = lists[i];
            ListNode nextNode = null;
            while(headNode != null){
                nextNode = headNode.next;
                resultList = addNodeToList(resultList, headNode);
                headNode = nextNode;
            }
        }
        return resultList;
    }
}
