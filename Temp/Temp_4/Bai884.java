import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bai884
 */
public class Bai884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> r = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                r.add(s);
            }
        }

        String[] a = new String[r.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.get(i);
        }

        return a;
    }
}