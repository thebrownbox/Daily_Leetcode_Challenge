/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * 953. Verifying an Alien Dictionary [E]
 * Tags: #sort #string
 */
import java.util.Arrays;
import java.util.Comparator;

public class _953_Verifying_an_Alien_Dictionary {

    public static class SoSanhString implements Comparator<String> {
        private int[] orderValues;

        public SoSanhString(String order) {
            orderValues = new int['z' + 1];
            for (int i = 0; i < order.length(); i++) {
                orderValues[order.charAt(i)] = i;
            }
        }

        @Override
        public int compare(String o1, String o2) {
            int max = Math.min(o1.length(), o2.length());
            for (int i = 0; i < max; i++) {
                int k1 = orderValues[o1.charAt(i)];
                int k2 = orderValues[o2.charAt(i)];
                if(k1 != k2){
                    return Integer.compare(k1, k2);
                }
            }
            if(o1.length() == o2.length()){
                return 0;
            }
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public static boolean isAlienSorted(String[] words, String order) {
        String[] sortedStrings = Arrays.copyOf(words, words.length);
        SoSanhString s = new SoSanhString(order);
        Arrays.sort(sortedStrings, s);

        for (int i = 0; i < sortedStrings.length; i++) {
            if(!sortedStrings[i].equals(words[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        String[] words = {"ab","a"};
        isAlienSorted(words, "abcdefghijklmnopqrstuvwxyz");
    }
}
