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
        String[] arr = sentence.split(" ");
        Set<String> mySet = new HashSet<>();

        for (String str : dictionary) {
            mySet.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) { // n
            //abc => a,ab,abc
            for (int j = 0; j < arr[i].length(); j++) { //n
                String prefix = arr[i].substring(0, j+1); 
                if(mySet.contains(prefix)){ //k
                    arr[i] = prefix;
                    break;
                }
            }

            if(sb.length() == 0){
                sb.append(arr[i]);
            }else{
                sb.append(" ");
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}
