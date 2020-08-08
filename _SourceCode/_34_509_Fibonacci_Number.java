/*
https://leetcode.com/problems/fibonacci-number/
509. Fibonacci Number [Easy]
Tags: Array, Recursion
 */
public class _34_509_Fibonacci_Number {

    // Using pure recursion
    public int fib1(int N) {
        if(N <= 1) return N;
        return fib(N-1) + fib(N-2);
    }

    // Using recursion with saved previous results
    int[] F = new int[31];
    public int fib2(int N) {
        if(N == 0)
            return 0;
        if(N == 1){
            F[1] = 1;
            return F[1];
        }

        if(F[N] != 0)
            return F[N];
        F[N] = fib(N-1) + fib(N-2);
        return F[N];
    }

    // Not use recursion
    int curIndex = 1;
    public int fib(int N) {
        F[1] = 1;

        while (curIndex < N){
            curIndex++;
            F[curIndex] = F[curIndex-1] + F[curIndex-2];
        }

        return F[N];
    }
}
