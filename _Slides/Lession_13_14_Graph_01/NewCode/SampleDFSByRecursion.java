import java.util.HashSet;
import java.util.Set;

public class SampleDFSByRecursion {

    public static void DFS(int u, int[][] graph, Set<Integer> daDuyet)
    {
        // process u
        System.out.print(u + " ");

        for (int v = graph.length-1; v >= 0; v--) 
        {
            if(graph[u][v] == 1 && daDuyet.contains(v) == false)
            {
                daDuyet.add(v);
                DFS(v, graph, daDuyet);
            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = {   { 0, 1, 0, 0, 0, 0, 0}, 
                            { 1, 0, 1, 1, 1, 0, 0},
                            { 0, 1, 0, 0, 0, 1, 0},
                            { 0, 1, 0, 0, 0, 1, 1},
                            { 0, 1, 0, 0, 0, 0, 1},
                            { 0, 0, 1, 1, 0, 0, 0},
                            { 0, 0, 0, 1, 1, 0, 0}};
        //
        Set<Integer> daDuyet = new HashSet<>();
        daDuyet.add(0);
        DFS(0, graph, daDuyet);
    }
}
