/**
 * The Brown Box / hoangvancong.com
 * Id: 905.
 * Name: Sort Array By Parity
 * Url: https://leetcode.com/problems/sort-array-by-parity/
 */
public class _12_905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] a) {
        int n = a.length;
        int i = 0;
        int j = n - 1;

        while(i < j)
        {
            if(a[i]%2 != 0)// a[i] la so le
            {
                // Xu ly
                if(a[j]%2 == 0)// a[j] la So chan
                {
                    if(i < j)
                    {
                        int t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                    }
                }
                else// So le
                {
                    j--;
                }
            }
            else// a[i] la so chan
            {
                i++;
            }
        }

        return a;
    }
}
