/**
 * 53. Maximum Subarray [E]
 * https://leetcode.com/problems/maximum-subarray/
 * Tags: #dp #array
 */
public class _74_53_Maximum_Subarray_1 {

    // Cong thuc truy hoi: tong(i,j) = sum[j] - sum[i] + a[i] 
    public static int maxSubArray(int[] a) {
        int result = a[0];
        int[] sum = new int[a.length];
        
        sum[0] = a[0];
        // sum[i] = sum[i-1] + a[i]
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + a[i];
        }

        //tong(i,j) = sum[j] - sum[i] + a[i] 
        for (int i = 0; i < sum.length; i++) {
            for (int j = i; j < sum.length; j++) {
                int tong_i_j = sum[j] - sum[i] + a[i];
                result = Math.max(result, tong_i_j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}