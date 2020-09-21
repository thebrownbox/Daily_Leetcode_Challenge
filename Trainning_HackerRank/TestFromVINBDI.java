// https://leetcode.com/problems/open-the-lock

import javax.swing.text.MutableAttributeSet;
import java.util.*;

public class Game_of_Two_Stacks {
    public static int largestArea(List<List<Integer>> a) {
        // Write your code here
        int MAX = 0;
        int n = a.size();
        int m = a.get(0).size();
        boolean[][] marked = new boolean[n][m];
        int[][] F = new int[n][m]; // F is max size square at i,j
        for (int i = 0; i < n; i++) {
            F[i][0] = a.get(i).get(0);
            MAX = Math.max(MAX, F[i][0]);
        }
        for (int j = 0; j < m; j++) {
            F[0][j] = a.get(0).get(j);
            MAX = Math.max(MAX, F[j][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a.get(i).get(j) == 1){
//                    int prevSize = F[i-1][j-1];
                    F[i][j] = Math.min(F[i-1][j-1], Math.min(F[i-1][j], F[i][j-1])) + 1;
                    MAX = Math.max(MAX, F[i][j]);
                }
            }
        }
        return MAX;
    }

    static class Caller{
        public int start;
        public int duration;
        public int volume;
        public int nextAvaiableTime;
        public int index;
        Caller(int s, int d, int v){
            start = s;
            duration = d;
            volume = v;
            nextAvaiableTime = start+duration+1;
        }

    }

    static class SortByStartTime implements Comparator<Caller>
    {
        @Override
        public int compare(Caller caller, Caller other) {
            return caller.start - other.start;
        }
    }

    public static int phoneCalls(List<Integer> start, List<Integer> duration, List<Integer> volume) {
        // Write your code here
        int result = 0;
        List<Caller> callers = new ArrayList<>();
        int n = start.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            callers.add(new Caller(start.get(i), duration.get(i), volume.get(i)));
        }

        Collections.sort(callers, new SortByStartTime());

        int[] FMAX = new int[n];
        for (int i = 0; i < n; i++) {
            FMAX[i] = callers.get(i).volume;
            result = Math.max(result, FMAX[i]);
            callers.get(i).index = i;
        }

        for (int i = 0; i < n; i++) {
            Caller curCaller = callers.get(i);
            if(FMAX[curCaller.index] == curCaller.volume && visited[curCaller.index] ==false){
                // Not visit, not final
            }else{
                //already visit => skip
                continue;
            }

            //Do BFS from current Caller
            Queue<Caller> mQueue = new LinkedList<>();
            mQueue.add(curCaller);

            while (mQueue.isEmpty() == false){
                Caller c = mQueue.poll();
                visited[c.index] = true;
                for (int j = c.index+1; j < n; j++) {
                    Caller nextCall = callers.get(j);
                    if(nextCall.start >= c.nextAvaiableTime){
                        int nVol = FMAX[c.index] + nextCall.volume;
//                        FMAX[nextCall.index] = Math.max(FMAX[nextCall.index], nVol);
//                        result = Math.max(result, FMAX[nextCall.index]);
//                        mQueue.add(callers.get(j));
                        if(nVol >= FMAX[nextCall.index]){
                            FMAX[nextCall.index] = nVol;
                            mQueue.add(nextCall);
                            result = Math.max(result, FMAX[nextCall.index]);
                        }else{
                            // Duong di nay da kem hon duong di truoc
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<Integer> start = new ArrayList<>();
        List<Integer> duration = new ArrayList<>();
        List<Integer> volume = new ArrayList<>();

        start.add(10); start.add(5); start.add(15); start.add(18); start.add(30);
        duration.add(30); duration.add(12); duration.add(20); duration.add(35); duration.add(35);
        volume.add(50); volume.add(51); volume.add(20); volume.add(25); volume.add(10);

        System.out.println(phoneCalls(start, duration, volume));
    }
}
