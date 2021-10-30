import java.util.HashSet;
import java.util.Set;

public class _219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (i > k) {
                numbers.remove(a[i - k - 1]);
            }
            if (numbers.contains(a[i])) {
                return true;
            } else {
                numbers.add(a[i]);
            }
        }
        return false;
    }
}
