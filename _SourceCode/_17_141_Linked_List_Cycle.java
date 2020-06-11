public class _17_141_Linked_List_Cycle {
      class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public  class Solution {
        public boolean hasCycle(ListNode head)
        {
            if(head == null || head.next == null)
            {
                return false;
            }

            int STEP_MAX = 2;
            ListNode slow = head;
            ListNode fast = head.next;

            while(slow != null)
            {
                int count = 0;

                while (fast != null)
                {
                    if(fast == slow)
                    {
                        return true;
                    }

                    fast = fast.next;
                    count++;
                    if(count == STEP_MAX)
                    {
                        break;
                    }
                }

                slow = slow.next;
            }

            return false;
        }
    }


    public static void main(String[] args) {

    }
}
