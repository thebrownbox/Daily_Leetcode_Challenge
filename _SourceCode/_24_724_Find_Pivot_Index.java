/*
https://leetcode.com/problems/find-pivot-index/
724. Find Pivot Index [Easy]
Tags: Array
*/

public class _24_724_Find_Pivot_Index
{
    public int pivotIndex(int[] a)
    {
        int n = a.length;
        if(n == 1)
            return 0;

        if(n == 0)
            return -1;

        int[] St = new int[n];

        for (int i = 0; i < n; i++)
        {
            St[i] = (i == 0) ? a[i] : (St[i-1] + a[i]);
        }

        for (int i = 0; i < n; i++)
        {
            int Sp_i = 0;
            if(i == 0){ // 1-n-1
                Sp_i = St[n-1] - a[i];
                if(Sp_i == 0)
                    return i;
            }else if(i == n-1){
                if(St[n-2] == 0)
                    return i;
            }else{ //
                Sp_i = St[n-1] - St[i];
                if(St[i-1] == Sp_i)
                    return i;
            }

        }

        return -1;
    }
}
