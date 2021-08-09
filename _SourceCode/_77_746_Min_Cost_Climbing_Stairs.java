/**
 * 746. Min Cost Climbing Stairs [E]
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * Tags: #array #dp
 */
public class _77_746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] a) {
        int[] tien = new int[a.length + 1];

        //BTCS: 
        tien[0] = 0;
        tien[1] = 0;

        // CTTH:
        for (int i = 2; i <= a.length; i++) {
            tien[i] = Math.min(tien[i-1] + a[i-1], tien[i-2] + a[i-2]);
        }

        return tien[a.length];
    }
}
