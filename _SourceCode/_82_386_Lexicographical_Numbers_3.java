/**
 * 386. Lexicographical Numbers [M]
 * https://leetcode.com/problems/lexicographical-numbers/
 * Tags: #recursion #trie #tree
 */
import java.util.ArrayList;
import java.util.List;

public class _82_386_Lexicographical_Numbers_3 {

    private class TrieNode{
        public static final int SIZE = 10;
        public TrieNode[] children = new TrieNode[SIZE];
    }

    private TrieNode root = new TrieNode();
    private List<Integer> result = new ArrayList<>();
    private void insert(TrieNode parent, int curIndex, String number) {
        if(curIndex < number.length())
        {
            int childIndex = number.charAt(curIndex) - '0';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }
            insert(parent.children[childIndex], curIndex+1, number);
        }
    }

    private void travel(TrieNode parent, int prefixNumber) {
        if(parent != null)
        {
            for (int i = 0; i < TrieNode.SIZE; i++) {
                if(parent.children[i] != null)
                {
                    int newNumber = prefixNumber*10 + i;
                    result.add(newNumber);
                    travel(parent.children[i], newNumber);
                }
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        //O(n)
        for (int i = 1; i <= n; i++) {
            String iString = String.valueOf(i);
            insert(root, 0, iString);// O(5)
        }
        // O(n)
        travel(root, 0);

        return result;
    }



 
}
