import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class _890 {


    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words[0].length(); i++) {
            char c = words[0].charAt(i);
            boolean isValid = true;
            for (int j = 1; j < words.length; j++) {
                String other = words[j];
                int index = other.indexOf(c);
                if(index < 0){
                    isValid = false;
                    break;
                }else{
                    words[j] = other.subSequence(0, index) + other.substring(index + 1);
                }
            }
            if(isValid){
                result.add(c + "");
            }
        }
        return result;
    }

    public static boolean check(String s, String p){
        if(s.length() != p.length()) return false;
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] countS = new int['z'+1];
        int[] countP = new int['z'+1];
        
        for (int i = 0; i < sArr.length; i++) {
            countS[sArr[i]]++;
            countP[pArr[i]]++;        
        }

        return true;
    }
    
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String str : words) {
            if(check(str, pattern)){
                result.add(str);
            }
        }

        return result;
    }
}
