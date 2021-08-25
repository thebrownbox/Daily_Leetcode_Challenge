/**
 * LC_088
 * Jesse and Cookies [E]
 * Tags: #heap
 * #Java #Easy
 * https://www.hackerrank.com/challenges/jesse-and-cookies/problem
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _88_Jesse_and_Cookies {

    public static int cookies(int k, List<Integer> candies) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (Integer c : candies) {
            minHeap.add(c);
        }

        int count = 0;
        while(minHeap.peek() < k){
            if(minHeap.size() < 2){
                return -1;
            }
            int k1 = minHeap.poll();
            int k2 = minHeap.poll();
            int newK = k1 + 2*k2;
            minHeap.add(newK);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
       
    }
}