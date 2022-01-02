import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _00_49_Group_Anagrams {

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) 
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < tArr.length; i++) {
            if(sArr[i] != tArr[i]){
                return false;
            }
        }

        return true;
    }

    public List<String> getGroupAnagramAndRemove(String origin, List<String> list, List<List<String>> results ){
        List<String> group = new ArrayList<>();
        List<String> newList = new ArrayList<>();

        for (String s : list) {
            if(isAnagram(s, origin)){
                group.add(s);
            }else{
                newList.add(s);
            }
        }

        results.add(group);
        return newList;
    }

    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> results = new ArrayList<>();
        List<String> list = Arrays.asList(arr);

        while(list.isEmpty() == false){
            list = getGroupAnagramAndRemove(list.get(0), list, results);
        }

        return results;
    }
}
