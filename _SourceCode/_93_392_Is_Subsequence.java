
/**
* LC_093
* 392. Is Subsequence [E]
* Tags: #DP #string #array
* #Java #Easy
* https://leetcode.com/problems/is-subsequence/
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _93_392_Is_Subsequence {
    public boolean isSubsequence(String dst, String src) {
        Map<Character, List<Integer>> vitri = new HashMap<>();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            List<Integer> list = vitri.getOrDefault(c, null);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);

        }
        return false;
    }
}
