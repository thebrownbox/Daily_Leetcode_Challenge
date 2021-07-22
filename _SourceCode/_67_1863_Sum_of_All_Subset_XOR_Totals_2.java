/**
 * 1863. Sum of All Subset XOR Totals [E]
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 * Tags: #backtracking #BitManipulation
 */


/**
 * _67_1863_Sum_of_All_Subset_XOR_Totals
 */
public class _67_1863_Sum_of_All_Subset_XOR_Totals_2 {

    private int resultSum = 0;

    private void backtrack(int index, int[] nums, int curXOR)
    {
        for (int i = 0; i <= 1; i++) {
            curXOR = i == 0 ? curXOR : (curXOR ^ nums[index]);

            if(index == nums.length - 1) {
                this.resultSum += curXOR;
            } else {
                backtrack(index + 1, nums, curXOR);
            }
        }
    }

    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, 0);
        return this.resultSum;
    }

}