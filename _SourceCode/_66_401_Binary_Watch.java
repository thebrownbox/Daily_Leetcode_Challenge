/**
 * 401. Binary Watch [E]
 * https://leetcode.com/problems/binary-watch/
 * Tags: #BitManipulation
 */

import java.util.ArrayList;
import java.util.List;

public class _66_401_Binary_Watch {
  

    public static int countBitOne(int number)
    {
        int count = 0;
        while(number != 0)
        {
            if((number & 1) == 1){
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> results = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                int totalBitCount = Integer.bitCount(h) + Integer.bitCount(m);
                if(totalBitCount == turnedOn){
                    String time = String.format("%d:%02d", h, m);
                    results.add(time);
                    // StringBuilder sb = new StringBuilder();
                    // sb.append(h);
                    // sb.append(':');
                    // if(m < 10){
                    //     sb.append(0);
                    // }
                    // sb.append(m);
                    // results.add(sb.toString());
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        var s = readBinaryWatch(1);
    }
}
