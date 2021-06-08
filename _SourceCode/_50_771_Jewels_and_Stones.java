/**
 * 771. Jewels and Stones [E]
 * https://leetcode.com/problems/jewels-and-stones/
 * Tags: #hashtable #array
 */
import java.util.Hashtable;


public class _50_771_Jewels_and_Stones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        boolean[] isBest = new boolean[123];

        for (int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);
            isBest[c] = true;
        }

        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if(isBest[c] == true){
                count++;
            }
        }

        return count;
    }
}
