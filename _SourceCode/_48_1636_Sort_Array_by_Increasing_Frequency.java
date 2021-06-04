import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _48_1636_Sort_Array_by_Increasing_Frequency {
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
            int convertedValue = a[i] - ADD_VALUE;
            count[convertedValue]++;
        }

        Queue<Node> pQueue = new PriorityQueue<>();
        for (int convertedValue = 0; convertedValue <= MAX_VALUE; convertedValue++) {
            if(count[convertedValue] > 0)
            {
                int originValue = convertedValue - ADD_VALUE;
                Node newNode = new Node(originValue, count[convertedValue]);
                pQueue.add(newNode);
            }
        }

        int[] result = new int[a.length];
        int indexResult = 0;
        while(pQueue.isEmpty() == false){
            Node node = pQueue.remove();
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
