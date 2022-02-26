public class _1859_Sorting_the_Sentence {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] sorted = new String[arr.length];

        for (String str : arr) {
            int index = Integer.parseInt(str.substring(str.length() - 1, str.length())) - 1;
            sorted[index] = str.substring(0, str.length() - 1);
        }

        StringBuilder sb = new StringBuilder();

        for (String str : sorted) {
            if (sb.length() == 0) {
                sb.append(str);
            } else {
                sb.append(" ");
                sb.append(str);
            }
        }

        return sb.toString();
    }
}
