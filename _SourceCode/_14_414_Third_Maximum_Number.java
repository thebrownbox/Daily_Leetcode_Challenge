public class _14_414_Third_Maximum_Number
{
    public static void printArr(long[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.println();
    }

    public static void insert(long[] maxArr, int val)
    {
        int i = 0;
        while(i < maxArr.length)
        {
            if(val == maxArr[i])
            {
                // Ko duoc trung
                return;
            }
            else if (val > maxArr[i])
            {
                // Chen val vao maxArr[i]
                break;
            }
            else// val < maxArr
            {
                i++;
            }
        }
        // 4 3 2 | 3
        if(i < maxArr.length)
        {
            for (int j = maxArr.length-2; j >= i; j--)
            {
                maxArr[j+1] = maxArr[j];
            }
            maxArr[i] = val;
            printArr(maxArr);
        }
    }

    public static int thirdMax(int[] a)
    {
        long[] maxArr = {Long.MIN_VALUE,
                Long.MIN_VALUE, Long.MIN_VALUE};

        for (int i = 0; i < a.length; i++) {
            insert(maxArr, a[i]);
        }

        if(maxArr[2] == Long.MIN_VALUE)
            return (int)maxArr[0];

        return (int)maxArr[2];
    }

    public static void main(String[] args)
    {
        int[] a = {2, 2, 3, 1};
        System.out.println(thirdMax(a));
    }
}
