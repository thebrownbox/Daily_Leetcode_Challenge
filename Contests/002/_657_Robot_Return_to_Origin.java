public class _657_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int i = 0, j = 0;
        for (char c : arr) {
            if (c == 'U') {
                j++;
            } else if (c == 'D') {
                j--;
            } else if (c == 'L') {
                i++;
            } else { // c == "R"
                i--;
            }
        }
        return i == 0 && j == 0;
    }
}
