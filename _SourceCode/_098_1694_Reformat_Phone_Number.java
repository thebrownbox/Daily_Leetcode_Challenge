/**
 * 1694. Reformat Phone Number [E]
 * https://leetcode.com/problems/reformat-phone-number/
 * Tags: #recursion #string
 */
public class _098_1694_Reformat_Phone_Number {
    public String reformatNumber(String s) {
        s = s.replaceAll("[ -]", "");
        return F(s);
    }

    public static String F(String s) {
        int n = s.length();
        if (n == 2 || n == 3)
            return s;
        if (n == 4)
            return s.substring(0, 2) + "-" + s.substring(2);
        return s.substring(0, 3) + "-" + F(s.substring(3));
    }

    public static void main(String[] args) {
        System.out.println(F("12345"));
    }
}