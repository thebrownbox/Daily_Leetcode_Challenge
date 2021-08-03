public class FloydCycleDetection {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if(head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                // => Tao thanh 1 cycle
                isCycle = true;
                break;
            }
        }

        if(isCycle)
        {
            fast = head;
            while (fast != null && slow != null)
            {
                if(fast == slow)
                {
                    return fast;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }

        return null;
    }


    public static void main(String[] args) {

    }
}
