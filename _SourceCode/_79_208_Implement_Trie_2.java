
public class _79_208_Implement_Trie_2 {

    private class TrieNode{
        public static final int SIZE = 26;
        public TrieNode[] children = new TrieNode[SIZE];
        public boolean isWord = false;
    }

    private TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode parent = root;
        int curIndex = 0;

        while(curIndex < word.length()){
            int childIndex = word.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }

            if(curIndex == word.length()-1){
                parent.children[childIndex].isWord = true;
            }

            parent = parent.children[childIndex];
            curIndex++;
        }
    }
    

    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        int curIndex = 0;

        while(curIndex < prefix.length()){
            int childIndex = prefix.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                return false;
            }
            parent = parent.children[childIndex];
            curIndex++;
        }

        return true;
    }


    public boolean search(String word) {
        TrieNode parent = root;
        int curIndex = 0;

        while(curIndex < word.length()){
            int childIndex = word.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                return false;
            }
            parent = parent.children[childIndex];
            curIndex++;
        }

        return parent.isWord;
    }
 
}
