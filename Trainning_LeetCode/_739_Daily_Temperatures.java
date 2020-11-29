import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _739_Daily_Temperatures {
    // Cach 1: O(n^2)
    public int[] dailyTemperatures_01(int[] T) {
        int n = T.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i+1; j < n; j++) {
                count++;
                if(T[j] > T[i]){
                    result[i] = count;
                    break;
                }
            }
        }

        return result;
    }

    // Cach 2: Su dung hashtable
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
                

        return result;
    }
}

