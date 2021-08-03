import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SampleBFSWithQueue {
    public static void main(String[] args) {
        int[][] graph = {   { 0, 1, 0, 0, 0, 0, 0}, 
                            { 1, 0, 1, 1, 1, 0, 0},
                            { 0, 1, 0, 0, 0, 1, 0},
                            { 0, 1, 0, 0, 0, 1, 1},
                            { 0, 1, 0, 0, 0, 0, 1},
                            { 0, 0, 1, 1, 0, 0, 0},
                            { 0, 0, 0, 1, 1, 0, 0}};
        // KHai bao
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> daDuyet = new HashSet<>();

        // Khoi tao
        queue.add(0);
        daDuyet.add(0);

        // Duyet theo stack
        while(!queue.isEmpty())
        {
            int u = queue.poll();
            // process u
            System.out.print(u + " ");
            //Add tất cả các đỉnh kề v với u  mà chưa được duyệt vào stack.

            for (int v = 0; v < graph.length; v++) {
                if(graph[u][v] == 1 && daDuyet.contains(v) == false)
                {
                    queue.add(v);
                    // Đánh dấu đã duyệt v. 
                    daDuyet.add(v);
                }
            }
        }
    }
}
