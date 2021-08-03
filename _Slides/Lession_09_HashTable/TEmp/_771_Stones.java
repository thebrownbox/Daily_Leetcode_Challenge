import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * _771_Stones
 */
public class _771_Stones {

    public int numJewelsInStones(String jewels, String stones) {
        int[] isGood = new int[1000];

        for (int i = 0; i < jewels.length(); i++) {
            isGood[jewels.charAt(i)] = 1;
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if(isGood[stones.charAt(i)] == 1){
                count++;
            }
        }
        return count;
    }
}