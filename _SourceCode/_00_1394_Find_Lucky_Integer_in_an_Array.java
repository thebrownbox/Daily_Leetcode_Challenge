/**
 * 1394. Find Lucky Integer in an Array [E]
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 * Tags: #array
 */
public class _00_1394_Find_Lucky_Integer_in_an_Array {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int ai : arr) {
            count[ai]++;
        }

        int result = -1;
        for (int i = 1; i < count.length; i++) {
            if(i == count[i]){
                result = i;
            }
        }
        return result;
    }
}
