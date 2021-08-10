/**
 * LC_086
 * 677. Map Sum Pairs [M]
 * Tags: #recursion #trie #tree
 * #Java #medium
 * https://leetcode.com/problems/map-sum-pairs/
 */

public class _86_677_Map_Sum_Pairs_2 {
    private class TrieNode{
        public static final int SIZE = 26;
        public TrieNode[] children = new TrieNode[SIZE];
        public int score = 0;
    }
    
    private TrieNode root = new TrieNode();
    private void insert(TrieNode parent, int curIndex, String word, int score)
    {
        if(curIndex < word.length())
        {
            int childIndex = word.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                parent.children[childIndex] = new TrieNode();
            }
            if(curIndex == word.length() - 1){
                parent.children[childIndex].score = score;
            }else{
                insert(parent.children[childIndex], curIndex+1, word, score);
            }
        }
    }

    public void insert(String key, int val) {
        insert(root, 0, key, val);
    }

    private int mCurrentSum = 0;
    private void travel(TrieNode parent, int curIndex, String prefix){
        if(curIndex < prefix.length()){
            int childIndex = prefix.charAt(curIndex) - 'a';
            if(parent.children[childIndex] == null){
                return;
            }
            if(curIndex == prefix.length()-1){
                mCurrentSum += parent.children[childIndex].score;
                travel(parent.children[childIndex], curIndex+1, prefix);
            }else{
                travel(parent.children[childIndex], curIndex+1, prefix);
            }
        }else{
            if(parent == null){
                return;
            }
            for (TrieNode childNode : parent.children) {
                if(childNode != null){
                    mCurrentSum += childNode.score;
                    travel(childNode, curIndex, prefix);
                }
            }
        }
    }

    public int sum(String prefix) {
        mCurrentSum = 0;
        travel(root, 0, prefix);
        return mCurrentSum;
    }
}
