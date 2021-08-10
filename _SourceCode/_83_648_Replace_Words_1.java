/**
 * 648. Replace Words [M]
 * https://leetcode.com/problems/replace-words/
 * Tags: #hashtable #string
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class _83_648_Replace_Words_1 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> prefixSet = new HashSet<>();
        for (String prefix : dictionary) {
            prefixSet.add(prefix);
        }

        String[] arr = sentence.split(" ");
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                String prefix = arr[i].substring(0, j+1);
                if(prefixSet.contains(prefix)){
                    arr[i] = prefix;
                    break;
                }
            }
            if(results.length() == 0){
                results.append(arr[i]);
            }else{
                results.append(" ");
                results.append(arr[i]);
            }
        }

        return results.toString();
    }
}
