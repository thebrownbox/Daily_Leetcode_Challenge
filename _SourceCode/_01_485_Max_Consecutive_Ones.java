/**
 * https://leetcode.com/problems/max-consecutive-ones/
 * Tags: #array
 */

public class _01_485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
}
