// https://leetcode.com/problems/open-the-lock

import java.util.*;

public class Game_of_Two_Stacks {
    static int twoStacks(int x, int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
//        a = reverseArray(a);
//        b = reverseArray(b);

        int[][] F = new int[n+1][m+1];
        int max = 0;

        for (int i = 1; i <=n ; i++) {
            F[i][0] = F[i-1][0] + a[i-1];
            if(F[i][0] <= x)
                max = Math.max(max, i);
        }
        for (int j = 1; j <= m; j++) {
            F[0][j] = F[0][j-1] + b[j-1];
            if(F[0][j] <= x)
                max = Math.max(max, j);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                F[i][j] = F[i][0] + F[0][j];

                if(F[i][j] <= x)
                    max = Math.max(max, i+j);
                else
                    break;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int x = 10;
        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};
        System.out.println(twoStacks(x, a, b));
    }
}
