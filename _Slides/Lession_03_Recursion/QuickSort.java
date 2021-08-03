package Lesson04_Recursion;

import java.util.Arrays;


class QuickSort {

    void quickSort(int[] a, int L, int R)
    {
        if(L >= R) return;
        int k = partition1(a, L, R);
        quickSort(a, L, k);
        quickSort(a, k+1, R);
    }

    /**
     * Chi mảng thành 2 phần:
     * [NHỎ HƠN, LỚN HƠN HOẶC BẰNG]
     * @param a
     */
    int partition1(int[] a, int L, int R)
    {
        int key = a[L];
        int iL = L;
        int iR = R;
        while (iL < iR)
        {
            while (a[iL] < key && iL < R) iL++;
            while (a[iR] >= key && iR > L) iR--;
            if(iL < iR)
            {
                int t = a[iL];
                a[iL] = a[iR];
                a[iR] = t;
            }
        }
        return iR;
    }

    public static void main(String[] args) {
        System.out.println("k = " + ((3+4)/2));
        int[] a = { 2,2,1,2};
        QuickSort q = new QuickSort();
        q.quickSort(a, 0, a.length-1);
    }

}