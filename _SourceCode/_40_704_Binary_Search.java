// https://leetcode.com/problems/open-the-lock

import javax.swing.text.MutableAttributeSet;
import java.util.*;

public class _40_704_Binary_Search {
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(target == nums[i])
                return i;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length-1, target);
    }

    public static int bSearch(int[] a, int L, int R, int x) {
        if(L > R) return -1;
        int k = (L+R)/2;
        if(x == a[k]) return k;
        if(x > a[k]) return bSearch(a, k+1, R, x);
        return bSearch(a, L, k-1, x);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int x = scanner.nextInt();
        System.out.println(search(a,x));
    }
}
