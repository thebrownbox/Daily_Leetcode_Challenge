import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight [E]
 * https://leetcode.com/problems/last-stone-weight/
 * Tags: #array #queue #heap
 */
public class _63_1046_Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));

        //B1. add all to heap
        for (Integer s : stones) {
            maxHeap.add(s);
        }

        // B2. Thuc hien yeu cau bai toan
        while(maxHeap.size() >= 2){
            int bigger = maxHeap.poll();
            int smaller = maxHeap.poll();
            if(bigger > smaller){
                maxHeap.add(bigger - smaller);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
    
}