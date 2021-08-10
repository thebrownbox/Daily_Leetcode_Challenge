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
            int nextBase = base * 10;
            for (int i = 0; i < 10; i++) {
                int nextNumber = nextBase + i;
                if(nextNumber <= MAX && nextNumber != 0){
                    result.add(nextNumber);
                    dfs(nextNumber);
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
