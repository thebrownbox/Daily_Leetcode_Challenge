/**
 * LC_087
 * 1636. Sort Array by Increasing Frequency [E]
 * Tags: #sort #array #hashtable 
 * #Java #Easy
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _87_1636_Sort_Array_by_Increasing_Frequency {

    private class MyNumber implements Comparable{
        public int value;
        public int freq;
        public MyNumber(int value, int freq){
            this.value = value;
            this.freq = freq;
        }
        @Override
        public int compareTo(Object o) {
            MyNumber other = (MyNumber)o;
            if(this.freq == other.freq){
                // Sap xep theo value giam dan
                return -Integer.compare(this.value, other.value);
            }else{
                // Sap xep theo freq tang dan
                return Integer.compare(this.freq, other.freq);
            }
        }
    }

    public int[] frequencySort(int[] a) {
        //Buoc 1
        // count[i] => so lan xuat hien cua (i-100) trong mang a
        // int[] count = new int[201];
        // for (int ai : a) {
        //     count[ai+100]++;
        // }

        // List<MyNumber> myList = new ArrayList<>();
        // for (int i = 0; i < count.length; i++) {
        //     int value = i-100;
        //     int freq = count[i];
        //     if(freq != 0){
        //         MyNumber myNumber = new MyNumber(value, freq);
        //         myList.add(myNumber);
        //     }
        // }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ai : a) {
            countMap.put(ai, countMap.getOrDefault(ai, 0) + 1);
        }

        List<MyNumber> myList = new ArrayList<>();
        for (Map.Entry entry : countMap.entrySet()) {
            myList.add(new MyNumber((int)entry.getKey(), (int)entry.getValue()));
        }

        // Buoc 2: O(n(logn))
        Collections.sort(myList);

        // Buoc 3
        int index_a = 0;
        for (MyNumber myNumber : myList) {
            int value = myNumber.value;
            int freq = myNumber.freq;
            for (int i = 0; i < freq; i++) {
                a[index_a] = value;
                index_a++;
            }
        }

        return a;
    }


}
