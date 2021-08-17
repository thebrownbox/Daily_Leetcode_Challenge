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
            String newString = new String(arr);
            mMyCount.put(newString, mMyCount.getOrDefault(newString, 0)+1);
        }

        for (String q : query) {
            char[] arr = q.toCharArray();
            Arrays.sort(arr);
            String newString = new String(arr);
            if(mMyCount.containsKey(newString)){
                int count = (int)mMyCount.get(newString);
                result.add(count);
            }else{
                result.add(0);
            }
      
        }
        return result;
    }




    
}