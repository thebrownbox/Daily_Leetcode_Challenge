import java.util.List;

/**
 * Bai1
 */
public class Bai1 {

    //2 * 10^9 | 2 147 483 647
    public static int balancedSum(List<Integer> a) {
        int n = a.size();
        int[] sum = new int[n];
        sum[0] = a.get(0);
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + a.get(i);
        }

        for (int i = 1; i < n; i++) {
            int leftSum = sum[i-1];
            int rightSum = sum[n-1] - sum[i];
            if(leftSum == rightSum){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}