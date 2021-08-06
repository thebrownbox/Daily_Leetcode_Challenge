/**
 * 53. Maximum Subarray [E]
 * https://leetcode.com/problems/maximum-subarray/
 * Tags: #dp #array
 */
public class _74_53_Maximum_Subarray_1 {

    public static int maxSubArray(int[] a) {
        int result = a[0];

        // tinh tong sum
        int[] sums = new int[a.length];

        // BTCS:
        sums[0] = a[0];

        // CTTH:
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + a[i];
        }

        // Tinh tong ij
        for (int i = 0; i < sums.length; i++) {
            for (int j = i; j < sums.length; j++) {
                int sum_i_j = sums[j] - sums[i] + a[i];
                result = Math.max(result, sum_i_j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}