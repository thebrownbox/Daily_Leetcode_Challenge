import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 */
public class Bai_3_OK {
    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        List<String> result = new ArrayList<>();
        int n = customers.size();
        float MIN = n * 5.0f / 100;

        Map<String, Integer> myCount = new TreeMap<>();
        for (String s : customers) {
            myCount.put(s, myCount.getOrDefault(s, 0)+1);
        }

        for (Map.Entry entry : myCount.entrySet()) {
            String name = (String)entry.getKey();
            int count = (int)entry.getValue();
            if(count >= MIN){
                result.add(name);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = {"a", "b", "b","a","c"};
        mostActive(Arrays.asList(s));
    }
}
