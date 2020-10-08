/**
 * The Brown Box / hoangvancong.com
 * Id: 1346
 * Name: Check If N and Its Double Exist
 * Url: https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class _08_1346_Check_If_N_and_Its_Double_Exist {
    public boolean checkIfExist(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                if(a[i] == 2*a[j] || a[j] == 2*a[i])
                {
                    return true;
                }
            }

        }

        return false;
    }
}
