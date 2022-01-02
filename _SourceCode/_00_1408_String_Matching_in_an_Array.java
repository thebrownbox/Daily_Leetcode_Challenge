import java.util.ArrayList;
import java.util.List;

/**
 * 1408. String Matching in an Array [3]
 * https://leetcode.com/problems/string-matching-in-an-array/
 * Tags: #string
 */
public class _00_1408_String_Matching_in_an_Array {
    public List<String> stringMatching(String[] words) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i != j && words[j].contains(words[i])){
                    results.add(words[i]);
                    break;
                }
            }
        }

        return results;
    }
}
