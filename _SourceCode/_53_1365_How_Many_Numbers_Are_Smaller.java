/**
 * 1365. How Many Numbers Are Smaller Than the Current Number [E]
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Tags: #array
 */
public class _53_1365_How_Many_Numbers_Are_Smaller {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        // countSmaller[i] = so phan tu nho hon nums[i]
        int[] countSmaller = new int[n];

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] < k){
                    countSmaller[i]++;
                }
            }
        }

        return countSmaller;
    }
}
