import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls [E]
 * https://leetcode.com/problems/number-of-recent-calls/
 * Tags: #Queue
 */

 public class _56_933_Number_of_Recent_Calls {
 
    Queue<Integer> mRecentCallQueue = new LinkedList<>();

    public int ping(int t) {
        mRecentCallQueue.add(t);

        while(mRecentCallQueue.peek() < (t-3000)){
            mRecentCallQueue.remove();
        }

        return mRecentCallQueue.size();
    }

 }