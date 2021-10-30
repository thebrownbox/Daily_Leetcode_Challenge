import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _46_Permutations
 */
public class _46_Permutations {
    List<List<Integer>> result = new ArrayList<>();
    int[] origin;

    public void generate(Integer[] list, int index, int n, boolean[] daXet) {
        if (index >= n) {
            result.add(new ArrayList<>(Arrays.asList(list)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (daXet[i] == false) {
                list[index] = origin[i];
                daXet[i] = true;
                generate(list, index + 1, n, daXet);
                daXet[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] a) {
        this.origin = a;
        int n = a.length;
        Integer[] list = new Integer[n];
        boolean[] daXet = new boolean[n];
        generate(list, 0, n, daXet);

        return result;
    }

    public static void main(String[] args) {
        _46_Permutations test = new _46_Permutations();
        int[] a = { 1, 2, 3 };
        test.permute(a);
    }
}