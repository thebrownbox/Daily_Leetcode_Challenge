import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bai2068 {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            set.add(c1);
            count1.put(c1, count1.getOrDefault(c1, 0) + 1);

            char c2 = word2.charAt(i);
            set.add(c2);
            count2.put(c2, count2.getOrDefault(c2, 0) + 1);
        }

        for (Character c : set) {
            int c1 = count1.getOrDefault(c, 0);
            int c2 = count2.getOrDefault(c, 0);
            if(Math.abs(c1 - c2) > 3){
                return false;
            }
        }

        return true;
    }
}
