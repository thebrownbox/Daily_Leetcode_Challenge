import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class _797_All_Paths_From_Source_to_Target {

    List< List<Integer> > results = new ArrayList<>();

    public void DFS(int u, int target, int[][] graph, List<Integer> path)
    {
        if(u == target){
            results.add(new ArrayList<>(path));
            return;
        }

        for (int v : graph[u]) {
            path.add(v);
            DFS(v, target, graph, path);
            path.remove(path.size()-1);
        }
    }

    public List< List<Integer> > allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int target = n-1;
        List<Integer> path = new Stack<>();

        path.add(0);
        DFS(0, target, graph, path);

        return results;
    }

    public static void main(String[] args) {
        _797_All_Paths_From_Source_to_Target t = new _797_All_Paths_From_Source_to_Target();
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        t.allPathsSourceTarget(graph);
    }
}
