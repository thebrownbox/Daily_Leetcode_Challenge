/**
 * LC_089
 * Find the Running Median [H]
 * Tags: #heap
 * #Java #Hard
 * https://www.hackerrank.com/challenges/find-the-running-median
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _89_Find_the_Running_Median {
    public static List<Double> runningMedian(List<Integer> list) {
        List<Double> result = new ArrayList<>();
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        result.add(list.get(0) * 1.0);
        maxHeap.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i);

            // log(n)
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(a);
            }else{
                maxHeap.add(a);
            }

            // Validate: maxHeap < minHeap
            while(maxHeap.peek() > minHeap.peek()){
                int bigger = maxHeap.poll();
                int smaller = minHeap.poll();
                maxHeap.add(smaller);
                minHeap.add(bigger);
            }

            if(maxHeap.size() > minHeap.size()){
                result.add(maxHeap.peek() * 1.0);
            }else{
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }

        return result;
    }
}
