/**
 * The Brown Box / hoangvancong.com
 * Id: 283
 * Name: Move Zeroes
 * Url: https://leetcode.com/problems/move-zeroes/
 */
public class _11_283_Move_Zeroes {
    public void moveZeroes(int[] a) {
        int n = a.length;
        int curIndex = 0;
        for (int i = 0; i < n; i++)
        {
            if(a[i] != 0)
            {
                a[curIndex] = a[i];
                curIndex++;
            }
        }

        for (; curIndex < n; curIndex++)
        {
            a[curIndex] = 0;
        }
    }
}
