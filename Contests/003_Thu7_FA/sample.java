/**
 * sample
 */
public class sample {

    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = numberOfBit1(i);
        }
        return arr;
    }

    private static int numberOfBit1(int k) {
        int count = 0;
        while (k != 0) {
            if ((k & 1) == 1)
                count++;
            k = k >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(numberOfBit1(3));
    }
}