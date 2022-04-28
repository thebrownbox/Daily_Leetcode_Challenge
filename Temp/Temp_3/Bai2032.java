import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bai2032 {
    public void updateMap(int[] a, Map<Integer, Integer> map){
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (Integer i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        updateMap(nums1, map);
        updateMap(nums2, map);
        updateMap(nums3, map);

        for (var row : map.entrySet()) {
            if(row.getValue() > 1){
                result.add(row.getKey());
            }
        }

        return result;
    }
}
