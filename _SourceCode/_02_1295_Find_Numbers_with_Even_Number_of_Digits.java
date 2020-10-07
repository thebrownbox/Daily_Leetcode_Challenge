import javax.management.MBeanAttributeInfo;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * Tags: #array
 */
public class _02_1295_Find_Numbers_with_Even_Number_of_Digits {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int numberOfDigit = (int)Math.floor(Math.log10(nums[i])) + 1;
            if(numberOfDigit % 2 == 0){
                count++;
            }
        }

        return count;
    }

}
