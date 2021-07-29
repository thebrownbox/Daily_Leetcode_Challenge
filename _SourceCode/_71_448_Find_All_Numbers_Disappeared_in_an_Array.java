/**
 * 448. Find All Numbers Disappeared in an Array [E]
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Tags: #array
 */

import java.util.ArrayList;
import java.util.List;

public class _71_448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] a) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) - 1;
            a[index] = Math.abs(a[index]) * -1;
        }

        for (int index = 0; index < a.length; index++) {
            if(a[index] > 0)
            {
                results.add(index+1);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        
    }
}