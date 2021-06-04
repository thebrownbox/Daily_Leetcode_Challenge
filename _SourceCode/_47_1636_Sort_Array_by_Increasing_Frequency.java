import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1636. Sort Array by Increasing Frequency [E]
 * URL: https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Tags: #hashtable #array
 */
public class _47_1636_Sort_Array_by_Increasing_Frequency {
    
    /**
     * Node
     */
    public static class Node implements Comparable {
        Node(int v, int f){
            this.value = v;
            this.freq = f;
        }
        int value;
        int freq;

        @Override
        public int compareTo(Object o) {
            if(o instanceof Node){
                Node other = (Node)o;
                if(this.freq == other.freq){
                    return -Integer.compare(this.value, other.value);
                }
                return Integer.compare(this.freq, other.freq);
            }
            return 0;
        }
    }
    
    public int[] frequencySort(int[] a) {

        int ADD_VALUE = 100;
        int MAX_VALUE = 100 + ADD_VALUE;
        // count[i] = số lần xuất hiện của i trong mảng.
        int[] count = new int[MAX_VALUE+1];

        //B0. Di dem so lan xuat hien cua cac phan tu
        for (int i = 0; i < a.length; i++) {
            int convertedValue = a[i] + ADD_VALUE;
            count[convertedValue]++;
        }

        //
        Set<Node> mSet = new TreeSet<>();
        for (int convertedValue = 0; convertedValue <= MAX_VALUE; convertedValue++) {
            if(count[convertedValue] > 0)
            {
                int originalValue = convertedValue - ADD_VALUE;
                Node newNode = new Node(originalValue, count[convertedValue]);
                mSet.add(newNode);
            }
        }

        int[] result = new int[a.length];
        int indexResult = 0;
        for (Node node : mSet) {
            int value = node.value;
            int freq = node.freq;
            for (int i = 0; i < freq; i++) {
                result[indexResult] = value;
                indexResult++;
            }
        }
        return result;
    }

}
