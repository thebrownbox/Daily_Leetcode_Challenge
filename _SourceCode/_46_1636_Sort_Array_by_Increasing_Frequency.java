/**
 * 1636. Sort Array by Increasing Frequency [E]
 * URL: https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Tags: #sort #array
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class _46_1636_Sort_Array_by_Increasing_Frequency {


    /**
     * Node
     */
    public class Node implements Comparable{
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

        List<Node> mList = new ArrayList<>();
        for (int convertedValue = 0; convertedValue <= MAX_VALUE; convertedValue++) {
            if(count[convertedValue] > 0){
                int originValue = convertedValue - ADD_VALUE;
                Node newNode = new Node(originValue, count[convertedValue]);
                mList.add(newNode);
            }
        }

        Collections.sort(mList);

        int[] result = new int[a.length];
        int idxResult = 0;
        for (Node node : mList) {
            int freq = node.freq;
            int value = node.value;
            for (int i = 0; i < freq; i++) {
                result[idxResult] = value;
                idxResult++;
            }
        }

        return result;
    }

}
