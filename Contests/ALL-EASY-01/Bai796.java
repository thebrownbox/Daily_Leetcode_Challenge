/**
 * Bai796
 */
public class Bai796 {

    public static String shift(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        int MAX = s.length();
        for (int i = 0; i < MAX; i++) {
            s = shift(s);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(shift("s"));
    }
}