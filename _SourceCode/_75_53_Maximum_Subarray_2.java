/**
 * 53. Maximum Subarray [E]
 * https://leetcode.com/problems/maximum-subarray/
 * Tags: #dp #array
 */

public class _75_53_Maximum_Subarray_2 {
    public static int maxSubArray(int[] a) {
        int result = a[0];
        int[] max = new int[a.length];

        max[0] = a[0];
        for (int i = 1; i < max.length; i++) {
            max[i] = Math.max(a[i], a[i] + max[i-1]);
            result = Math.max(result, max[i]);
            result = max[i] > result ? max[i] : result; 
        }

        return result;
    }

}
