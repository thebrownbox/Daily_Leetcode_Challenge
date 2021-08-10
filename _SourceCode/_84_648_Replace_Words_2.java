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
        public boolean isLast = false;
    }
    private TrieNode root = new TrieNode();
    private StringBuilder strBuilder = new StringBuilder();
    private void insert(TrieNode parent, int curIndex, String word)
    {
        if(curIndex < word.length())
        {
            int childIndex = word.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }
            
            if(curIndex == word.length() - 1){
                parent.children[childIndex].isLast = true;
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
            strBuilder.append(word.charAt(curIndex));
            if(parent.children[childIndex].isLast){
                return strBuilder.toString();
            }

            if(curIndex == word.length() - 1){
                return null;
            }else{
                return findPrefix(parent.children[childIndex], curIndex+1, word);
            }
        }
        return null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String prefix : dictionary) {
            insert(root, 0, prefix);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            strBuilder.delete(0, strBuilder.length());
            String prefix = findPrefix(root, 0, words[i]);
            if(prefix != null){
                words[i] = prefix;
            }
        }

        strBuilder.delete(0, strBuilder.length());
        for (String string : words) {
            if(strBuilder.length() == 0){
                strBuilder.append(string);
            }else{
                strBuilder.append(" ");
                strBuilder.append(string);
            }
        }

        return strBuilder.toString();
    }


}
