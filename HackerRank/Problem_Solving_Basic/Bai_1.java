import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test
 */
public class Bai_1 {
    private static boolean isAnagram(String s1, Map<Character, Integer> count_2) {
        Map<Character, Integer> count_1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            count_1.put(s1.charAt(i), count_1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        if(count_1.size() != count_2.size())
            return false;

        for (Character key : count_1.keySet()) {
            if(count_2.containsKey(key)){
                if(!count_1.get(key).equals(count_2.get(key))){
                    return false;
                }
            }else{
                return false;
            }
            
        }

        return true;
    }



    private static List< Map<Character, Integer> > mMyMaps = new ArrayList<>();
    private static Map<String, Integer> mMyCount = new HashMap<>();

    private static int countAnagram(String s, List<String> dictionary) {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            if(isAnagram(s, mMyMaps.get(i))){
                count++;
            }
        }
        return count;
    }

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