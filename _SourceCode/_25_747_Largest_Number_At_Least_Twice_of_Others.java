/*
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
747. Largest Number At Least Twice of Others [Easy]
Tags: Array
 */

public class _25_747_Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] a) {
        int n = a.length;
        int the1stLargest = -1;
        int the2ndLargest = -1;
        int maxIndex = 0;

        if(n == 1)
            return 0;

        for (int i = 0; i < n; i++) {
            if(a[i] > the1stLargest){
                the2ndLargest = the1stLargest;
                the1stLargest = a[i];
                maxIndex = i;
            }else if(a[i] > the2ndLargest){
                the2ndLargest = a[i];
            }
        }

        if(the1stLargest >= the2ndLargest*2)
            return maxIndex;
        return -1;
    }
}
