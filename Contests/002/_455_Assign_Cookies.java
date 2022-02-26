import java.util.Arrays;

/**
 * _455_Assign_Cookies
 */
public class _455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {

            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j < s.length) {
                result++;
                j++;
            } else {
                return result;
            }
        }

        return result;
    }
}