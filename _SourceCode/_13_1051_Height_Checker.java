import java.util.Arrays;

public class _13_1051_Height_Checker {

    public static void printArray(int[] a)
    {
        System.out.printf("Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d, ", a[i]);
        }
        System.out.println();
    }

    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] copied = new int[n];

        for (int i = 0; i < n; i++) {
            copied[i] = heights[i];
        }
//        printArray(copied);

        // selection sort
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(copied[j] < copied[minIndex])
                {
                    minIndex = j;
                }
            }
            if(minIndex != i)
            {
                int t = copied[i];
                copied[i] = copied[minIndex];
                copied[minIndex] = t;
            }

        }

//        printArray(copied);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(heights[i] != copied[i])
            {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,4,2,1,3};
        System.out.println(heightChecker(arr));;
    }
}
