import java.util.Arrays;

public class FAILED_567_Permutation_in_String {

    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        for (int i = 0; (i+n) <= s2.length(); i++) {
            String sub = s2.substring(i, i+n);
            if(isPermutation(s1, sub)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        checkInclusion(s1, s2);
    }
}
