/**
 * 1365. How Many Numbers Are Smaller Than the Current Number [E]
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Tags: #array #hashtable
 */

public class _54_1365_How_Many_Numbers_Are_Smaller {
    public int[] smallerNumbersThanCurrent(int[] a) {
        int[] count = new int[101]; // count[j]: so lan xuat hien cua j
        int[] result = new int[a.length];

        // Diem so lan xuat hien cua cac phan tu
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        // 100 * n | N*N
        for (int i = 0; i < a.length; i++) {
            // Tinh so luong phan tu nho hon a[i]
            for (int j = 0; j < a[i]; j++) {
                result[i] += count[j];
            }
        }

        return result;
    }
}
