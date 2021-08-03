import java.util.Arrays;

/**
 * BacktrackingBasic
 */
public class BacktrackingBasic {

    private static String[] colors = { "red", "green", "blue", "yellow", "purple" };
    private static int[] selections = new int[colors.length];
    private static int[] validValues = { 0, 1 };

    private static void backtrack(int curIndex) {
        for (int i = 0; i < validValues.length; i++) {
            selections[curIndex] = validValues[i];
            if (curIndex == colors.length - 1) {
                process(selections);
            } else {
                backtrack(curIndex + 1);
            }
        }
    }

    private static int count = 0;

    public static void process(int[] selections) {
        String newMixColor = "";
        for (int i = 0; i < selections.length; i++) {
            if (selections[i] == 1) {
                newMixColor += "-" + colors[i];
            }
        }
        count++;
        System.out.println(count + " newColor: " + newMixColor);
        System.out.println(Arrays.toString(selections));
    }

    public static void main(String[] args) {
        backtrack(0);
    }
}