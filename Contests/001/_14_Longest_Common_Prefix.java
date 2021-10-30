public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        for (int i = 0; i < strs[0].length(); i++) {
            String prefix = sb.toString();
            boolean isCorrect = true;
            for (String s : strs) {
                if (s.startsWith(prefix) == false) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect)
                return prefix;
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
