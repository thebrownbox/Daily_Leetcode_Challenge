/**
 * https://leetcode.com/problems/richest-customer-wealth/
 * Level: E
 * Tags: Array
 */

public class _1672_Richest_Customer_Wealth {
    public int maximumWealth(int[][] accounts) {
        int maxMoney = 0;
        int n = accounts.length;
        if(n == 0)
            return 0;
            
        for (int i = 0; i < accounts.length; i++) {
            int curTotal = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                curTotal += accounts[i][j];
            }
            if(curTotal > maxMoney)
                maxMoney = curTotal;
        }

        return maxMoney;
    }
}
