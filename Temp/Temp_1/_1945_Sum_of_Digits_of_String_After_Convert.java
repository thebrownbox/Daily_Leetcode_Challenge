import java.util.Arrays;
import java.util.Comparator;

public class _1945_Sum_of_Digits_of_String_After_Convert {

    public static String convert(String s){
        String result = "";
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int numberC = c - 'a' + 1;
            result += String.valueOf(numberC);
        }
        return result;
    }

    public static String transform(String s){
        int sum = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int value = c - '0';
            sum += value;
        }
        return String.valueOf(sum);
    }

    public static int getLucky(String s, int k) {
        s = convert(s);
        for (int i = 0; i < k; i++) {
            s = transform(s);
        }
        return Integer.parseInt(s);
    }

}
