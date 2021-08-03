// https://leetcode.com/problems/open-the-lock

import javax.swing.text.MutableAttributeSet;
import java.util.*;

public class MyMergeSort {

    public int[] merge(int[] a1, int[] a2)
    {
        int n = a1.length + a2.length;
        int[] result = new int[n];

        int i = 0, i1 = 0, i2 = 0;
        while (i < n){
            if(i1 < a1.length && i2 < a2.length){ // a1 & a2 != Rong
                if(a1[i1] <= a2[i2]){ // a1 nho hon
                    result[i] = a1[i1];
                    i++; i1++;
                }else{// a2 nho hon
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }else{// a1 rong or a2 rong
                if(i1 < a1.length){ // a1 ok
                    result[i] = a1[i1];
                    i++; i1++;
                }else{ //a2 ok
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }
        }

        return result;
    }

    public int[] mergeSort(int a[], int L, int R)
    {
        // THDB DKD
        if(L > R) return new int[0];
        if(L == R){
            int[] singleElement = {a[L]};
            return singleElement;
        }

        // Chia ra
//        System.out.println("Chia: " + L + " - " + R);
        int k = (L+R)/2;
        int[] a1 = mergeSort(a, L, k);
        int[] a2 = mergeSort(a, k+1, R);


        // Tron vao: a2 va a1 la cac mang da duoc sap xep
        int[] result = merge(a1, a2);
//        System.out.println("Ket Qua Merge: " + Arrays.toString(result));
        return result;
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }


    public static void main(String[] args) {
        MyMergeSort s = new MyMergeSort();
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};
        int[] c = {1,5,3,2,8,7,6,4};

        System.out.println(Arrays.toString(s.mergeSort(c, 0, c.length-1)));
    }
}
