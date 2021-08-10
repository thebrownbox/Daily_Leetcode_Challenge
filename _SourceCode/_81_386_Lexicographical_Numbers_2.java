/**
 * 386. Lexicographical Numbers [M]
 * https://leetcode.com/problems/lexicographical-numbers/
 * Tags: #recursion #dfs
 */

import java.util.ArrayList;
import java.util.List;

public class _81_386_Lexicographical_Numbers_2 {
    private List<Integer> result = new ArrayList<>();
    private int MAX = 0;
    private void dfs(int base)
    {
        if(base <= MAX)
        {
            for (int i = 0; i <= 9; i++) {
                int newNumber = base * 10 + i;
                if(newNumber != 0 && newNumber <= MAX)
                {
                    result.add(newNumber);
                    dfs(newNumber);
                }
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        MAX = n;
        dfs(0);
        return result;
    }
}
