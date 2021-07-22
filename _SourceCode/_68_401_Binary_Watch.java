
/**
 * 401. Binary Watch [E]
 * https://leetcode.com/problems/binary-watch/
 * Tags: #backtracking #recursion
 */
import java.util.ArrayList;
import java.util.List;

public class _68_401_Binary_Watch {
    private List<String> results = new ArrayList<>();
    // i <= 3 => bieu dien gio
    private int[] values = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
    private int EXPECTED_COUNT = 0;

    // curCount: den so luong so 1 da xuat hien
    private void backtracking(int index, int curCount, int h, int m) {
        for (int i = 0; i <= 1; i++) {
            if(i == 1){
                curCount++;
                if(index <= 3){
                    h += values[index];
                }else{
                    m += values[index];
                }
            }

            if(index == values.length-1){
                if(curCount == EXPECTED_COUNT && h < 12 && m < 60)
                {
                    String time = String.format("%d:%02d", h, m);
                    this.results.add(time);
                }
            }else{
                backtracking(index+1, curCount, h, m);
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        EXPECTED_COUNT = turnedOn;
        backtracking(0, 0, 0, 0);
        return this.results;
    }
}
