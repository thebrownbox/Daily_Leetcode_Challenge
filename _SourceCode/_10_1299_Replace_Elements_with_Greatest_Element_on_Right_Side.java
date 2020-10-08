/**
 * The Brown Box / hoangvancong.com
 * Id: 1299
 * Name: Replace Elements with Greatest Element on Right Side
 * Url: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class _10_1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public int[] replaceElements(int[] a) {
        int n = a.length;
        for (int i = n-1; i >= 0; i--)
        {
            if(i != n-1)
            {
                a[i] = Math.max(a[i], a[i+1]);
            }
        }

        for (int i = 1; i < n; i++)
        {
            a[i-1] = a[i];
        }

        if(n > 0)
        {
            a[n-1] = -1;
        }

        return a;
    }
}
