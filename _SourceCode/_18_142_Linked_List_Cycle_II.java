/**
 * The Brown Box | hoangvancong.com
 * Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * #linkedlist
 */

public class _18_142_Linked_List_Cycle_II {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * -1: Khong tao thanh cycle
     * 0: Tao thanh cycle, nhung khong trung voi diem bat dau
     * 1: Tao thanh cycle, trung voi diem bat dau
     */
    public int checkNode(ListNode curNode)
    {
        if(curNode == null)
            return -1;

        ListNode slow = curNode;
        ListNode fast = curNode;

        while (slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
            {
                if(fast == curNode)
                    return 1;
                return 0;
            }
        }

        // Khong ton tai cycle
        return -1;
    }


    public ListNode detectCycle(ListNode head)
    {
        ListNode curNode = head;

        while(curNode != null)
        {
            int result = checkNode(curNode);
            if(result == -1)
                return null;
            else if (result == 1)
                return curNode;
            else
                curNode = curNode.next;
        }

        return null;
    }

    public static void main(String[] args)
    {

    }
}
