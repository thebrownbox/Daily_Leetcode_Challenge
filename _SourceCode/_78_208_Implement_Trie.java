
public class _78_208_Implement_Trie {

    private class TrieNode{
        public static final int N = 26;
        public TrieNode[] children = new TrieNode[N];
        public boolean isLast = false;
    }


    private TrieNode root;

    public _78_208_Implement_Trie() {
        root = new TrieNode();
    }

    // return new TrieNode parent
    private TrieNode insert(TrieNode parent, int index, String word){
        if(index < word.length())
        {
            int childIndex = word.charAt(index) - 'a';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }

            if(index == word.length() - 1){
                parent.children[childIndex].isLast = true;
            }else{
                insert(parent.children[childIndex], index+1, word);
            }
        }
        return parent;
    }
    
    public void insert(String word) {
        insert(root, 0, word);
    }
    
    private boolean checkPrefix(TrieNode parent, int index, String prefix)
    {
        if(index < prefix.length())
        {
            int childIndex = prefix.charAt(index) - 'a';
            if(parent.children[childIndex] == null){
                return false;
            }
            if(index == prefix.length() - 1){
                return true;
            }
            return checkPrefix(parent.children[childIndex], index+1, prefix);
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        return checkPrefix(root, 0, prefix);
    }

    private boolean search(TrieNode parent, int index, String word)
    {
        if(index < word.length())
        {
            int childIndex = word.charAt(index) - 'a';
            if(parent.children[childIndex] == null){
                return false;
            }

            if(index == word.length()-1){
                return parent.children[childIndex].isLast;
            }

            return search(parent.children[childIndex], index+1, word);
        }
        return false;
    }

    public boolean search(String word) {
        return search(root, 0, word);
    }
    

    public static void main(String[] args) {
        _78_208_Implement_Trie trie = new _78_208_Implement_Trie();
        trie.insert("apple");
        boolean check = trie.startsWith("app");
    }
 
}
