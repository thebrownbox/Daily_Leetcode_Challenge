/**
 * 386. Lexicographical Numbers [M]
 * https://leetcode.com/problems/lexicographical-numbers/
 * Tags: #recursion #trie #tree
 */
import java.util.ArrayList;
import java.util.List;

public class _82_386_Lexicographical_Numbers_3 {

    private class TrieNode{
        private static final int CHILD_COUNT = 10;
        public TrieNode[] children = new TrieNode[CHILD_COUNT];
        public boolean isLast = false;
    }

    private TrieNode root = new TrieNode();
    private List<Integer> result = new ArrayList<>();

    private void insert(TrieNode parent, int curIndex, String number)
    {
        if(curIndex < number.length())
        {
            int childIndex = number.charAt(curIndex) - '0';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }
            if(curIndex == number.length() - 1){
                parent.children[childIndex].isLast = true;
            }
            insert(parent.children[childIndex], curIndex+1, number);
        }
    }

    private void travel(TrieNode parent, StringBuilder sBuilder)
    {
        if(parent != null)
        {
            for (int i = 0; i < TrieNode.CHILD_COUNT; i++) {
                if(parent.children[i] != null){
                    sBuilder.append(i);
                    if(parent.children[i].isLast){
                        result.add(Integer.parseInt(sBuilder.toString()));
                    }
                    travel(parent.children[i], sBuilder);
                    sBuilder.deleteCharAt(sBuilder.length()-1);
                }
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            insert(root, 0, number);
        }

        StringBuilder sBuilder = new StringBuilder();
        travel(root, sBuilder);

        return result;
    }
}
