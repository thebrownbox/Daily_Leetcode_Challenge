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
        List<Integer> result = new ArrayList<>();
        List<String> stringNumbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String iString = String.valueOf(i);
            stringNumbers.add(iString);
        }

        Collections.sort(stringNumbers);

        for (String string : stringNumbers) {
            result.add(Integer.parseInt(string));
        }

        return result;
    }
}
