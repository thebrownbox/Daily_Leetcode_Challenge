/**
 * 268. Missing Number [E] 
 * https://leetcode.com/problems/missing-number/
 * Tags: #array #BitManipulation #hashtable #sort
 */
public class _73_268_Missing_Number {
    public int missingNumber(int[] nums) {
        int result = 0;

        for (int ai : nums) {
            result ^= ai;
        }

        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
