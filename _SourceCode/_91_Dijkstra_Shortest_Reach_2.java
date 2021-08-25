/**
 * LC_0091
 * Dijkstra: Shortest Reach 2 [H]
 * Tags: #bfs #queue
 * #Java #Hard
 * https://www.hackerrank.com/challenges/dijkstrashortreach
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _91_Dijkstra_Shortest_Reach_2 {

    private static int[][] distances;
    private static int[] shortestPaths;
    private static boolean[] isChecked;

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Your code here
        List<Integer> result = new ArrayList<>();
        distances = new int[n+1][n+1];
        shortestPaths = new int[n+1];
        isChecked = new boolean[n+1];

        Arrays.fill(shortestPaths, Integer.MAX_VALUE);
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int length = e.get(2);
            if(distances[u][v] == 0 || length < distances[u][v]){
                distances[u][v] = length;
                distances[v][u] = length;
            }
        }

        int curNode = s;
        shortestPaths[curNode] = 0;
        isChecked[curNode] = true;
        
        while(curNode != -1){
            // 1.  update shortestPaths
            for (int i = 1; i <= n; i++) {
                if(distances[curNode][i] != 0 && isChecked[i] == false){
                    int newDistanceFromCurNode = shortestPaths[curNode] + distances[curNode][i];
                    if(newDistanceFromCurNode < shortestPaths[i]){
                        shortestPaths[i] = newDistanceFromCurNode;
                    }
                }
            }

            // 2. mark curNode as checked
            isChecked[curNode] = true;

            // 3. Find shortest vertex which is not checked
            curNode = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if(shortestPaths[i] < minDistance && isChecked[i] == false){
                    curNode = i;
                    minDistance = shortestPaths[i];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(i != s){
                if(shortestPaths[i] == Integer.MAX_VALUE){
                    result.add(-1);
                }else{
                    result.add(shortestPaths[i]);
                }
            }
        }

        return result;
    }

}
