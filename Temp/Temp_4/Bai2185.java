public class Bai2185 {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String string : words) {
            if (string.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
