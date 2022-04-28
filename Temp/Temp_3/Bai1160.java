import java.util.HashMap;
import java.util.Map;

public class Bai1160 {
    public Map<Character, Integer> buildMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public boolean isGood(Map<Character, Integer> mapWord, Map<Character, Integer> mapChar) {
        for (var row : mapWord.entrySet()) {
            int resource = mapChar.getOrDefault(row.getKey(), 0);
            if (resource < row.getValue()) {
                return false;
            }
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        var mapChar = buildMap(chars);
        for (String word : words) {
            var mapWord = buildMap(word);
            if (isGood(mapWord, mapChar)) {
                count += word.length();
            }
        }
        return count;
    }
}
