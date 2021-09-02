import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bai_01: Using Trie
 * 1. Use wordDict to build trie
 * 2. Travel (DFS) in trie in the word sequence...
 * -> Each time travel try to buil the word in the sentence
 * -> To the end of the word => create the hold sentence.
 * Impotance Note: when it hit a Node.isWord = true, there are 2 option:
 * - Create new word for the next character
 * - Continue build the current word for the next character
 */
public class Bai_01 {
    private static class Node{
        public static final int SIZE = 26;
        public Node[] children = new Node[SIZE];
        public boolean isWord = false;
    }

    private static Node root = new Node();
    private static List<String> resultList = new ArrayList<>();

    // Build dictionary trie
    private static void addToMyTrie(String s, int index, Node parentNode)
    {
        if(index < s.length()){
            int childIndex = s.charAt(index)-'a';
            if(parentNode.children[childIndex] == null){
                parentNode.children[childIndex] = new Node();
            }
            if(index == s.length()-1){
                parentNode.children[childIndex].isWord = true;
            }else{
                addToMyTrie(s, index+1, parentNode.children[childIndex]);
            }
        }
    }

    private static List<String> tempStringList = new ArrayList<>();
    private static void travel(String word, int index, Node parentNode, String prevString, int wordCount) {
        if(index < word.length()){
            char curChar = word.charAt(index);
            int childIndex = curChar-'a';

            // This character is not exist in current branch => swith to another branch
            // It means => create NEW_WORD from this character
            if(parentNode.children[childIndex] == null){ 
                travel(word, index, root, "", wordCount+1);
            }else{ // continue previous word
                String curString = prevString + word.charAt(index);

                if(parentNode.children[childIndex].isWord){
                    // Finish create the current word
                    if(wordCount < tempStringList.size()){
                        tempStringList.set(wordCount, curString);
                    }else{
                        tempStringList.add(curString);
                    }

                    // last character in the word => Finish create a sentance
                    if(index == word.length()-1){
                        buildSentanceResult(tempStringList, wordCount);
                    }else{ // if not last continue create NEW_WORD forn next character
                        travel(word, index+1, root, "", wordCount+1);
                    }

                    // If there is more word on this branch => continue travel
                    if(index+1 < word.length()){
                        int nextChildIndex = word.charAt(index+1) - 'a';
                        if(parentNode.children[childIndex].children[nextChildIndex] != null){
                            travel(word, index+1, parentNode.children[childIndex], curString, wordCount);
                        }
                    }
                }else{ // If not finish word => continue travel in current branch
                    travel(word, index+1, parentNode.children[childIndex], curString, wordCount);
                }
            }
        }
    }

    // Create a sentance from stringList
    private static void buildSentanceResult(List<String> stringList, int wordCount) {
        String sentance = "";
        for (int i = 0; i <= wordCount; i++) {
            if(sentance.length() == 0){
                sentance = stringList.get(i);
            }else{
                sentance += (" " + stringList.get(i));
            }
        }
        resultList.add(sentance);
    }

    // main functions
    private static List<String> doMyThing(String word, String[] wordDict)
    {
        for (String s : wordDict) {
            addToMyTrie(s, 0, root);
        }

        travel(word, 0, root, "", 0);

        return resultList;
    }


    public static void main(String[] args) {
        //Test 1:
        // Expected: cat sand dog, cats and dog
        // String word = "catsanddog";
        // String[] wordDict = {"cat", "cats", "and", "sand", "dog"};

        // Test 2:
        // Expected: cat and cat, ca t and ca t, cat and ca t, ca t and cat
        // String word = "catandcat";
        // String[] wordDict = {"cat", "and", "ca", "t"};

        // Test 4:
        // Expected: 
        String word = "aaabbc";
        String[] wordDict = {"a", "aa", "aaa", "bb", "c"};

        List<String> results = doMyThing(word, wordDict);
        for (String sentance : results) {
            System.out.println(sentance);
        }
    }
}