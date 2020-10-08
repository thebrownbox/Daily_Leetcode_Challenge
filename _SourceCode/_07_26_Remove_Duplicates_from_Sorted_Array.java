/**
 * The Brown Box / hoangvancong.com
 * Id: 26
 * Name: Remove Duplicates from Sorted Array
 * Url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class _07_26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] a) {
        int n = a.length;
        int curIndex = 0;

        if(n == 0)
        {
            return 0;
        }

        for (int i = 0; i < n; i++)
        {
            if(a[i] != a[curIndex])
            {
                curIndex++;
                a[curIndex] = a[i];
            }
        }

        return curIndex+1;
    }
}
