/**
 * 136. Single Number [E] 
 * https://leetcode.com/problems/single-number/ 
 * Tags: #array #BitManipulation #hashtable #sort
 */
public class _72_136_Single_Number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int ai : nums) {
            result ^= ai;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}