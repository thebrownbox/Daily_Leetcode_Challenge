import java.util.LinkedList;
import java.util.Queue;

public class _933NumberofRecentCalls {

    private Queue<Integer> myQueue = new LinkedList<>();
    public int ping(int t) {
        myQueue.add(t);

        while(myQueue.peek() < (t-3000)){
            myQueue.remove();
        }

        return myQueue.size();
    }

}
