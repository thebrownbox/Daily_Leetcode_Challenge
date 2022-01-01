import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array [E]
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 * Tags: #Array
 */
public class _00_2089_Find_Target_Indices_After_Sorting_Array {

    public List<Integer> targetIndices(int[] a, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if(a[i] == target){
                result.add(i);
            }
        }
        return result;
    }
    
}