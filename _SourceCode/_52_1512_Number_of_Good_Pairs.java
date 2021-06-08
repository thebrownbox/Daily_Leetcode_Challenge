import java.util.HashMap;
import java.util.Map;

/**
 * 1512. Number of Good Pairs [E]
 * https://leetcode.com/problems/number-of-good-pairs/
 * Tags: #hashtable #array
 */

public class _52_1512_Number_of_Good_Pairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> mapCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(mapCount.containsKey(nums[i]) == true){
                int soLanDaXuatHien = mapCount.get(nums[i]);
                count += soLanDaXuatHien;
                mapCount.put(nums[i], soLanDaXuatHien + 1);
            }else{
                mapCount.put(nums[i], 1);
            }
        }

        return count;
    }
}
