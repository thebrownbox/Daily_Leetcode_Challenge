import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test
 */
public class Bai_1_OK {
    private static Map<String, Integer> mMyCount = new HashMap<>();
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        for (String dict : dictionary) {
            char[] arr = dict.toCharArray();
            Arrays.sort(arr);
            String sortedString = String.valueOf(arr);
            mMyCount.put(sortedString, mMyCount.getOrDefault(sortedString, 0)+1);
        }

        for (String q : query) {
            char[] arr = q.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            int count = (int)mMyCount.getOrDefault(key, 0);
            result.add(count);
        }
        return result;
    }
    
}