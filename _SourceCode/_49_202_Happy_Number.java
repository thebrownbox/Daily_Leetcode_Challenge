/**
 * 202. Happy Number [E]
 * https://leetcode.com/problems/happy-number/
 * Tags: #hashtable
 */

import java.util.HashSet;
import java.util.Set;



public class _49_202_Happy_Number {

    public static int nextNumber(int n){
        int sum = 0;
        while(n != 0){
            int k = n % 10;
            sum += (k*k);
            n = n/10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> existNumbers = new HashSet<>();
        
        while(existNumbers.contains(n) == false){
            existNumbers.add(n);
            if(n == 1){
                return true;
            }
            n = nextNumber(n);
        }

        return false;
    }

    public static void main(String[] args) {
        isHappy(2);
    }
}
