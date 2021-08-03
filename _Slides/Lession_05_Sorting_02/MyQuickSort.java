import java.util.Arrays;

/**
 * MyQuickSort
 */
public class MyQuickSort {
 
    static void quickSort(int[] a, int L, int R)
    {
        // Dieu kien dung
        if(L >= R) return;

        // B1. Chon khoa
        int key = a[(L+R)/2]; // 0-7: (0+7)/2 = 3

        // B2. Phan bo lai mang theo khoa
        int k = partition(a, L, R, key);
        System.out.println("L=" + L + " R=" + R + " key = " + key + " k = " + k);
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, L, R+1)));
        System.out.println("=============");
        // B3. Chia doi mang => Lap lai
        quickSort(a, L, k-1);
        quickSort(a, k, R);
    }

    // Return pivot value
    static int partition(int[] a, int L, int R, int key)
    {
        int iL = L;
        int iR = R;
        while(iL <= iR)
        {
            // Voi iL, di tim phan tu >= key de doi cho
            while(a[iL] < key) iL++;
            // voi iR, di tim phan tu <= key de doi cho
            while(a[iR] > key) iR--;
            // doi cho 2 phan tu dang dung khong dung vi tri
            if(iL <= iR)
            {
                int temp = a[iL];
                a[iL] = a[iR];
                a[iR] = temp;
                iL++; iR--;
            }
        }

        return iL;
    }

    public static void main(String[] args) {
        int[] a = {6, 7, 8, 5, 4, 1, 2, 3};
        System.out.println(Arrays.toString(a));
        System.out.println("Start");
        quickSort(a, 0, a.length-1);
        System.out.println("Finish");
        System.out.println(Arrays.toString(a));
    }
}