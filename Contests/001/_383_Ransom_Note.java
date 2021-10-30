import java.util.HashMap;
import java.util.Map;

public class _383_Ransom_Note {
    public boolean canConstruct(String destination, String source) {
        char[] dest = destination.toCharArray();
        char[] src = source.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        for (char c : src) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : dest) {
            int k = count.getOrDefault(c, 0);
            if (k == 0) {
                return false;
            } else {
                count.put(c, k - 1);
            }
        }

        return true;
    }
}
