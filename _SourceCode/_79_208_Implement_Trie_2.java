
public class _79_208_Implement_Trie_2 {

    private class TrieNode{
        public static final int N = 26;
        public TrieNode[] children = new TrieNode[N];
        public boolean isLast = false;
    }

    private TrieNode root;

    public _79_208_Implement_Trie_2() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curNode = root;
        int index = 0;
        while(index < word.length()){
            int childIndex = word.charAt(index) - 'a';
            if(curNode.children[childIndex] == null){
                curNode.children[childIndex] = new TrieNode();
            }
            if(index == word.length() - 1){
                curNode.children[childIndex].isLast = true;
            }
            curNode = curNode.children[childIndex];
            index++;
        }
    }
    

    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        int index = 0;
        while(index < prefix.length())
        {
            int childIndex = prefix.charAt(index) - 'a';
            if(curNode.children[childIndex] == null)
                return false;
            curNode = curNode.children[childIndex];
            index++;
        }
        return true;
    }


    public boolean search(String word) {
        TrieNode curNode = root;
        int index = 0;
        while(index < word.length())
        {
            int childIndex = word.charAt(index) - 'a';
            if(curNode.children[childIndex] == null)
                return false;
            curNode = curNode.children[childIndex];
            index++;
        }
        return curNode.isLast;
    }
    

 
}
