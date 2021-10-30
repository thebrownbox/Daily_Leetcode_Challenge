import java.util.Arrays;

public class _242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        return Arrays.toString(arrS).equals(Arrays.toString(arrT));
    }

    public static void main(String[] args) {
        _242_Valid_Anagram test = new _242_Valid_Anagram();
        test.isAnagram("anagram", "nagaram");

    }
}
