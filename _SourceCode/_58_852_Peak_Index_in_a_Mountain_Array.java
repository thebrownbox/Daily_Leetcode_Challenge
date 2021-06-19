import java.util.Arrays;

/**
 * 852. Peak Index in a Mountain Array [E]
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * Tags: #array #bSearch #recursion
 */
public class _58_852_Peak_Index_in_a_Mountain_Array {

    public int find(int[] a, int L, int R){
        // Kiem tra tinh hop le
        // L ... R 012
        if(R - L >= 2){
            int i = (L+R)/2;

            if(a[i] > a[i-1] && a[i] > a[i+1]){
                return i;
            }else if(a[i-1] < a[i]){ // di chuyen ve ben phai
                return find(a, i, R);
            }else{ //Di chuyen sang ben trai
                return find(a, L, i);
            }

        }else{
            return -1;
        }
    }

    public int peakIndexInMountainArray(int[] arr) {
        int index = find(arr, 0, arr.length-1);
        return index;
    }
}
