/**
 * 1365. How Many Numbers Are Smaller Than the Current Number [E]
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Tags: #array #sort
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class _55_1365_How_Many_Numbers_Are_Smaller {
   
    public int[] smallerNumbersThanCurrent(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        int[] original = Arrays.copyOf(a, n);
        Map<Integer, Integer> myMap = new HashMap<>();

        // n*log(n)
        Arrays.sort(a);

        // O(n)
        for (int i = 0; i < a.length; i++) {
            if(myMap.containsKey(a[i]) == false){
                myMap.put(a[i], i);
            }
        }

        //n
        for (int i = 0; i < original.length; i++) {
            result[i] = myMap.get(original[i]);
        }

        return result;
    }


}
