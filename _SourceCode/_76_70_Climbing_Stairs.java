/**
 * 70. Climbing Stairs [E]
 * https://leetcode.com/problems/climbing-stairs/
 * Tags: #array #dp
 */
public class _76_70_Climbing_Stairs {
    public int climbStairs(int n) {
        //count[i]: so cach de buoc len bac i
        int[] count = new int[n+1];

        // BTCS: 
        count[0] = 1;
        count[1] = 1;

        // CTTH: 
        for (int i = 2; i <= n; i++) {
            count[i] = count[i-1] + count[i-2];
        }

        return count[n];
    }
}