/**
 * LC_90
 * Breadth First Search: Shortest Reach [M]
 * Tags: #bfs #queue
 * #Java #Medium
 * https://www.hackerrank.com/challenges/bfsshortreach
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

public class _90_Breadth_First_Search_Shortest_Reach {

    private static int[][] distances;
    private static int[] bfsDistances;
    private static boolean[] isChecked;
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        distances = new int[n+1][n+1];
        bfsDistances = new int[n+1];
        isChecked = new boolean[n+1];
        List<Integer> result = new ArrayList<>();

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            distances[u][v] = 6;
            distances[v][u] = 6;
        }

        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(s);
        isChecked[s] = true;
        bfsDistances[s] = 0;

        while(!myQueue.isEmpty()){
            int curNode = myQueue.poll();
            for (int i = 1; i <= n; i++) {
                if(distances[curNode][i] != 0 && isChecked[i] == false){
                    isChecked[i] = true;
                    bfsDistances[i] = bfsDistances[curNode] + distances[curNode][i];
                    myQueue.add(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(i != s){
                if(bfsDistances[i] == 0){
                    result.add(-1);
                }else{
                    result.add(bfsDistances[i]);
                }
            }
        }

        return result;
    }
}
