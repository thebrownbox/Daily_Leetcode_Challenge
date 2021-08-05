public class _74_53_Maximum_Subarray_2 {
    public static int maxSubArray(int[] nums) {
        int result = 0;
        int[] maxs = new int[nums.length];

        maxs[0] = nums[0];
        result = maxs[0];
        for (int i = 1; i < maxs.length; i++) {
            maxs[i] = Math.max(nums[i], maxs[i-1] + nums[i]);
            result = Math.max(result, maxs[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        maxSubArray(arr);
    }
}
