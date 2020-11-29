/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Level: M
 * Tags: #array #set #map
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] a) {
        List<Integer> result = new ArrayList<>();
        int n = a.length;
        boolean[] existed = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            if(existed[a[i]] == false){
                existed[a[i]] = true;
            }else{
                result.add(a[i]);
            }
        }
        

        return result;
    }

    public List<Integer> findDuplicates2(int[] a) {
        List<Integer> result = new ArrayList<>();
        int n = a.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(set.contains(a[i]) == true){
                result.add(a[i]);
            }else{
                set.add(a[i]);
            }
        }
        

        return result;
    }
}
