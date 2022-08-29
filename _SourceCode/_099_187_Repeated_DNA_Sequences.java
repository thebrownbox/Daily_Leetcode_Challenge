
/**
 * 187. Repeated DNA Sequences [M]
 * https://leetcode.com/problems/repeated-dna-sequences/
 * Tags: #hashtable #sliding_window
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _098_187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        char[] arr = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        int SIZE = 10;
        StringBuilder sb = new StringBuilder();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i == SIZE - 1) {
                map.put(sb.toString(), 1);
            } else if (i >= SIZE) {
                sb.deleteCharAt(0);
                String nextString = sb.toString();
                map.put(nextString, map.getOrDefault(nextString, 0) + 1);
            }
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                results.add(entry.getKey());
            }
        }

        return results;
    }
}