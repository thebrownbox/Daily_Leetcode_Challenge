import java.util.HashSet;
import java.util.Set;

public class Bai645 {
    public int[] findErrorNums(int[] a) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            if(set.add(i) == false){
                result[0] = i;
            }
        }

        for (int i = 1; i <= a.length; i++) {
            if(set.contains(i) == false){
                result[1] = i;
            }
        }

        return result;
    }
}
