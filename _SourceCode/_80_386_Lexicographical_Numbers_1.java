/**
 * 386. Lexicographical Numbers [M]
 * https://leetcode.com/problems/lexicographical-numbers/
 * Tags: #sort #string
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _80_386_Lexicographical_Numbers_1 {
    public List<Integer> lexicalOrder(int n) {
        List<String> listString = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            listString.add(String.valueOf(i));
        }

        // O(nlogn)
        Collections.sort(listString);

        List<Integer> result = new ArrayList<>();
        for (String string : listString) {
            result.add(Integer.parseInt(string));
        }

        return result;
    }
}
