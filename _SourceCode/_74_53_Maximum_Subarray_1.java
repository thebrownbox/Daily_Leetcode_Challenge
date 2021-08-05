/**
 * 53. Maximum Subarray [E]
 * https://leetcode.com/problems/maximum-subarray/
 */
public class _74_53_Maximum_Subarray_1 {

    public static int maxSubArray(int[] nums) {
        int result = 0;
        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        result = sums[0];
        for (int i = 0; i < sums.length; i++) {
            for (int j = i; j < sums.length; j++) {
                int sum_i_to_j = sums[j] - sums[i] + nums[i];
                if(sum_i_to_j > result){
                    result = sum_i_to_j;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}