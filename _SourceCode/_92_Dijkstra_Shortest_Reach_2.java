/**
 * LC_0092
 * Dijkstra: Shortest Reach 2 [H]
 * Tags: #bfs #heap
 * #Java #Hard
 * https://www.hackerrank.com/challenges/dijkstrashortreach
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class _92_Dijkstra_Shortest_Reach_2 {

    private static class Node implements Comparable{
        public int index;
        public int shortestPath;
        public List<Integer> neighbors;
        public boolean isChecked;
        public Node(int i){
            this.index = i;
            this.shortestPath = Integer.MAX_VALUE;
            neighbors = new LinkedList<>();
            isChecked = false;
        }
        @Override
        public int compareTo(Object o) {
            Node other = (Node)o;
            return Integer.compare(this.shortestPath, other.shortestPath);
        }
    }

    private static int[][] distances;
    private static Node[] nodes;

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Your code here
        List<Integer> result = new ArrayList<>();
        Queue<Node> minHeap = new PriorityQueue<>();

        distances = new int[n+1][n+1];
        nodes = new Node[n+1];
     
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int length = e.get(2);
            if(distances[u][v] == 0){
                nodes[u].neighbors.add(v);
                nodes[v].neighbors.add(u);
            }
            if(distances[u][v] == 0 || length < distances[u][v]){
                distances[u][v] = length;
                distances[v][u] = length;
            }
        }

        int curNode = s;
        nodes[curNode].shortestPath = 0;
        nodes[curNode].isChecked = true;
        
        while(curNode != -1){
            // 1.  update shortestPaths with curNode's neighbors
            for (int i : nodes[curNode].neighbors) {
                if(distances[curNode][i] != 0 && nodes[i].isChecked == false){
                    int newDistanceFromCurNode = nodes[curNode].shortestPath + distances[curNode][i];
                    if(newDistanceFromCurNode < nodes[i].shortestPath){
                        minHeap.remove(nodes[i]);
                        nodes[i].shortestPath = newDistanceFromCurNode;
                        minHeap.add(nodes[i]);
                    }
                }
            }

            // 2. mark curNode as checked
            nodes[curNode].isChecked = true;

            // 3. Find shortest vertex which is not checked
            curNode = -1;
            while(!minHeap.isEmpty() && minHeap.peek().isChecked == true){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()){
                curNode = minHeap.poll().index;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(i != s){
                if(nodes[i].shortestPath == Integer.MAX_VALUE){
                    result.add(-1);
                }else{
                    result.add(nodes[i].shortestPath);
                }
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        Integer[] e1 = {1, 2, 24};
        Integer[] e2 = {1, 4, 20};
        Integer[] e3 = {1, 3, 3};
        Integer[] e4 = {3, 4, 12};
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(e1));
        edges.add(Arrays.asList(e2));
        edges.add(Arrays.asList(e3));
        edges.add(Arrays.asList(e4));
        shortestReach(4, edges, 1);
    }

}
