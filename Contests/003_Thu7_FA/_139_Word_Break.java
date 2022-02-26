import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_Word_Break {

    public class Node {
        public boolean isWord;
        public Node[] children = new Node[30];
    }

    Node root = new Node();

    private void build(Node curNode, String word, int charIndex) {
        if (charIndex < word.length()) {
            char c = word.charAt(charIndex);
            int childIndex = c - 'a';
            if (curNode.children[childIndex] == null) {
                curNode.children[childIndex] = new Node();
            }

            if (charIndex == word.length() - 1) {
                curNode.children[childIndex].isWord = true;
            } else {
                build(curNode.children[childIndex], word, charIndex + 1);
            }
        }
    }

    private void buildTrie(List<String> wordDict) {
        for (String s : wordDict) {
            build(root, s, 0);
        }
    }

    // return true: if separate successfully
    private boolean search(Node parent, String s, int charIndex) {
        if (charIndex < s.length()) {
            char c = s.charAt(charIndex);
            int childIndex = c - 'a';
            if (parent.children[childIndex] == null) {
                if (parent.isWord == false) {
                    return false;
                } else {
                    return search(root, s, charIndex);
                }
            } else {
                // TH1 parent is not a word
                if (parent.isWord == false) {
                    if (parent.children[childIndex] == null) {
                        return false;
                    } else {
                        if (charIndex == s.length() - 1 && parent.children[childIndex].isWord) {
                            return true;
                        }
                        return search(parent.children[childIndex], s, charIndex + 1);
                    }
                } else { // TH2 parent is a word
                    // TH2.1: Keep going
                    if (charIndex == s.length() - 1 && parent.children[childIndex].isWord) {
                        return true;
                    }
                    boolean result1 = false;
                    if (parent.children[childIndex] != null) {
                        // co the di tiep
                        if ((charIndex == s.length() - 1) && parent.children[childIndex].isWord) {
                            return true;
                        }
                        result1 = search(parent.children[childIndex], s, charIndex + 1);
                    }

                    // Th2.2: Go up to the root to begin the new path
                    if (result1 == false) {
                        boolean result2 = false;
                        if (parent == root)
                            return false;

                        if (root.children[childIndex] != null) {
                            result2 = search(root, s, charIndex);
                        }
                        return result2;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict = preprocessing(wordDict);
        buildTrie(wordDict);
        boolean r = search(root, s, 0);
        return r;
    }

    private boolean isDupplicate(String core, String s) {
        while (s.startsWith(core)) {
            s = s.substring(core.length(), s.length());
        }
        return s.isEmpty();
    }

    private List<String> preprocessing(List<String> wordDict) {
        List<String> convertedList = new ArrayList<>();
        for (int i = 0; i < wordDict.size(); i++) {
            if (convertedList.size() == 0) {
                convertedList.add(wordDict.get(i));
            } else {
                boolean isAdd = true;
                for (int j = 0; j < convertedList.size(); j++) {
                    if (isDupplicate(convertedList.get(j), wordDict.get(i))) {
                        isAdd = false;
                        break;
                    }
                }
                if (isAdd) {
                    convertedList.add(wordDict.get(i));
                }
            }
        }
        return convertedList;
    }

    public static void main(String[] args) {
        _139_Word_Break test = new _139_Word_Break();
        // List<String> list = new ArrayList<>();
        // list.add("aaaa");
        // list.add("aaa");
        // System.out.println(test.wordBreak("aaaaaaa", list));

        // List<String> list = new ArrayList<>();
        // list.add("a");
        // System.out.println(test.wordBreak("a", list));
        String[] arr = { "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa",
                "ba" };
        System.out.println(test.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList(arr)));
    }
}
