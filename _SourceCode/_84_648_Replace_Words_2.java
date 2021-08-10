/**
 * 648. Replace Words [M]
 * https://leetcode.com/problems/replace-words/
 * Tags: #trie #recursion
 */
import java.util.List;


public class _84_648_Replace_Words_2 {

    private class TrieNode{
        public static final int SIZE = 26;
        public TrieNode[] children = new TrieNode[SIZE];
        public boolean isWord = false;
    }

    private TrieNode root = new TrieNode();

    private void insert(TrieNode parent, int curIndex, String word)
    {
        if(curIndex < word.length())
        {
            int childIndex = word.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }
            if(curIndex == word.length()-1){
                parent.children[childIndex].isWord = true;
            }else{
                insert(parent.children[childIndex], curIndex+1, word);
            }
        }
    }

    private String findPrefix(TrieNode parent, int curIndex, String word) {
        if(curIndex < word.length()){
            int childIndex = word.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                return null;
            }
            if(parent.children[childIndex].isWord){
                return word.substring(0, curIndex+1);
            }
            return findPrefix(parent.children[childIndex], curIndex+1, word);
        }
        return null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        //1000*100
        for (String word : dictionary) {
            insert(root, 0, word);
        }

        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) { //1000
            String prefix = findPrefix(root, 0, arr[i]);//100
            if(prefix != null){
                arr[i] = prefix;
            }
            if(sb.length() != 0){
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }




}
