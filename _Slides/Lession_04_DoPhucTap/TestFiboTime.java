import java.util.Scanner;

public class TestFiboTime {
    public static final int MAX = 100;

    public static long fib1(int n) {
        if(n <= 1) return n;
        return fib1(n-1) + fib1(n-2);
    }

    public static long fib2(int n) {
        long[] F = new long[n+1];
        F[0] = 0; F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        return F[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");
        int n = scanner.nextInt();

        long t0 =  System.currentTimeMillis();
        long F1 = fib1(n);
        long t1 =  System.currentTimeMillis();
        long F2 = fib2(n);
        long t2 =  System.currentTimeMillis();

        System.out.println("fib1: " + F1 +" | time: " + (t1-t0));

        System.out.println("fib2: " + F2 +" | time: " + (t2-t1));

    }
}
