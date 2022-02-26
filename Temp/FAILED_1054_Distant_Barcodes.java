import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FAILED_1054_Distant_Barcodes {
    public int[] rearrangeBarcodes(int[] a) {
        int[] b = new int[a.length];

        Map<Integer, Integer> count = new HashMap<>();
        for (int ai : a) {
            count.put(ai, count.getOrDefault(ai, 0) + 1);
        }
        
        Integer[] keys = (Integer[])count.keySet().toArray();
        int i = 0;
        int j = 1;

        while(i < keys.length){
        }

        return b;
    }
}
