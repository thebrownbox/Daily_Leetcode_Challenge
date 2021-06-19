/**
 * 70. Climbing Stairs [E]
 * https://leetcode.com/problems/climbing-stairs/
 * Tags: #recursion #DP
 */

public class _57_70_Climbing_Stairs {
    int[] soBuoc = new int[46];

    public int soBuoc(int n){
        if(soBuoc[n] == 0){
            soBuoc[n] = soBuoc(n-1) + soBuoc(n-2);
        }
        return soBuoc[n];
    }

    public int climbStairs(int n) {
        // Bai toan co so
        soBuoc[1] = 1;
        soBuoc[2] = 2;

        // CongThucDe Quy:
        soBuoc(n);
        return soBuoc[n];
    }
}
