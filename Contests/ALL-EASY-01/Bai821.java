import java.util.Arrays;

public class Bai821 {
    public static int[] shortestToChar(String s, char c) {
        int[] kq = new int[s.length()];

        for (int i = 0; i < kq.length; i++) {
            if (s.charAt(i) != c)
                kq[i] = findKq(i, s, c);
        }

        return kq;
    }

    private static int findKq(int k, String s, char c) {
        int i = k + 1;
        int foundR = Integer.MAX_VALUE;
        for (i = k + 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                foundR = Math.abs(i - k);
                break;
            }
        }
        int foundL = Integer.MAX_VALUE;
        for (i = k - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                foundL = Math.abs(i - k);
                break;
            }
        }

        return Math.min(foundL, foundR);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}
