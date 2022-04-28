import java.util.HashMap;
import java.util.Map;

/**
 * Bai2085
 */
public class Bai2085 {

    public Map<String, Integer> buildMap(String[] words){
        Map<String, Integer> count = new HashMap<>();

        for (String str : words) {
            count.put(str, count.getOrDefault(str, 0) + 1);
        }
        
        return count;
    }

    public int countWords(String[] words1, String[] words2) {
        int count = 0;

        var map1 = buildMap(words1);
        var map2 = buildMap(words2);

        for (var row : map1.entrySet()) {
            var count2 = map2.getOrDefault(row.getKey(), 0);
            if(row.getValue().equals(1) &&  count2.equals(1)){
                count++;
            }
        }

        return count;
    }
}