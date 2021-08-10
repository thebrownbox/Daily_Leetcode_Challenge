/**
 * LC_085 
 * 677. Map Sum Pairs [M]
 * Tags: #string #hashtable 
 * #Java #medium
 * https://leetcode.com/problems/map-sum-pairs/
 */

import java.util.HashMap;
import java.util.Map;

public class _85_677_Map_Sum_Pairs_1 {

    private Map<String, Integer> myMap = new HashMap<>();
    public void insert(String key, int val) {
        myMap.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry entry : myMap.entrySet()) {
            String key = (String)entry.getKey();
            if(key.startsWith(prefix)){
                sum += (int)entry.getValue();
            }
        }
        return sum;
    }
}
