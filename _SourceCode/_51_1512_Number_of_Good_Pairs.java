/**
 * 1512. Number of Good Pairs [E]
 * https://leetcode.com/problems/number-of-good-pairs/
 * Tags: #array
 */

public class _51_1512_Number_of_Good_Pairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }

        return count;
    }
}
