/**
 * The Brown Box
 * Id: 27
 * Name: Remove Element
 * Url: https://leetcode.com/problems/remove-element/
 */
public class _06_27_Remove_Element {
    public int removeElement(int[] a, int val)
    {
        int n = a.length;
        int curIndex = 0;

        for (int i = 0; i < n; i++)
        {
            if(a[i] != val)
            {
                a[curIndex] = a[i];
                curIndex++;
            }
        }

        return curIndex;
    }
}
