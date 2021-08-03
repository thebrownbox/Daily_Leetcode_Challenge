package Lesson04_Recursion;

public class SimpleRecursion {

    public static int find(int x, int[] a, int i)
    {
        if(i >= 0 && i < a.length)
        {
            if(a[i] == x) return i;
            return find(x, a, i+1);
        }
        else
        {
            // invalid index
            return -1;
        }
    }

    public static int sum1(int[] a, int i)
    {
        if(i >= 0 && i < a.length)
        {
            return a[i] + sum1(a, i+1);
        }
        else
        {
            // invalid index
            return 0;
        }
    }

    public static int sum2(int[] a, int startIndex, int endIndex)
    {
        if((startIndex >= 0 && startIndex < a.length)
                && (endIndex >= 0 && endIndex < a.length)
                && (startIndex <= endIndex))
        {
            return a[startIndex] + sum2(a, startIndex+1, endIndex);
        }
        else
        {
            // invalid index
            return 0;
        }
    }

    public static void travel2ndArray(int[][] a, int i, int j)
    {
        int nRow = a.length;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("find(10, a, 0): " + find(9, a, 0));
        System.out.println("sum1(a,0): " + sum1(a,0));
        System.out.println("sum2(a,0,9): " + sum2(a,0, 2));
    }
}
