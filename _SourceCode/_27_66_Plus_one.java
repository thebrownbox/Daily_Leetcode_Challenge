/*
https://leetcode.com/problems/plus-one/
66. Plus One [Easy]
Tags: Array
 */

public class _27_66_Plus_one {
    public static int[] plusOne(int[] a)
    {
        int n = a.length;
        int soDu = 1;

        int i = n-1;
        while( i >= 0 && soDu > 0)
        {
            int temp = a[i] + soDu; //9 + 4 = 13 => 3 = 13 % 10 | 1 = 13/10
            a[i] = temp % 10;
            soDu = temp / 10;
            i--;
        }

        if(soDu == 0)
            return a;

        int[] b = new int[n+1];
        b[0] = soDu;

        for (i = 0;  i < n; i++)
        {
            b[i+1] = a[i];
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = {9,9};
        int[] b = plusOne(a);
    }
}
