public class _19_160_Intersection_of_Two_Linked_Lists
{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isCommon(ListNode curNodeA, ListNode headB)
    {
        while(headB != null)
        {
            if(headB == curNodeA)
                return true;
            headB = headB.next;
        }
        return false;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB)
    {
        while (headA != null)
        {
            if(isCommon(headA, headB))
                return headA;
            headA = headA.next;
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB)
        {
            if(pA != null)
                pA = pA.next;
            else pA = headB;

            if(pB != null)
                pB = pB.next;
            else pB = headA;
        }

        return pA;
    }

}
