public class _35_509_Fibonacci_Number {

    public int fib(int n) {
        int[] F = new int[31];
        F[0] = 0; F[1] = 1;
        for (int i = 3; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        return F[n];
    }

    public static void main(String[] args) {

    }
}
