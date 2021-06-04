import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * MyDijkstraPriorityQueue
 */
public class MyDijkstraPriorityQueue {

    private static class Node{
        public int index;
        public int distance;
        public Node previous;
        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
            previous = null;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node){
                Node other = (Node)obj;
                return other.index == this.index;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return index;
        }
    }

    public static void main(String[] args) {
        int n = 5; // 0- 4
        int[][] a = {   {0, 6, 0, 1, 0},
                        {6, 0, 5, 2, 2},
                        {0, 5, 0, 0, 5},
                        {1, 2, 0, 0, 1},
                        {0, 2, 5, 1, 0} };

        Node[] nodes = new Node[n];
        Set<Node> visited = new HashSet<>();
        Queue<Node> priQueue = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(MyDijkstraPriorityQueue.Node o1, MyDijkstraPriorityQueue.Node o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        });

        int start = 0;
        int finish = 2;
        int oo = Integer.MAX_VALUE;

        // Bước 1: Khởi tạo khoảng cách
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, oo);
        }
        nodes[start].distance = 0;

        priQueue.add(nodes[start]);
        while(priQueue.isEmpty() == false)
        {
            //Bước 2: Chọn đỉnh chưa duyệt  
            // và đang có khoảng cách nhỏ nhất (từ đỉnh xuất phát) làm đỉnh đang xét.
            Node curNode = priQueue.poll();

            //Bước 3: Từ đỉnh đang xét, duyệt các ĐỈNH KỀ chưa duyệt: 
            // update khoảng cách và đỉnh trước của các đỉnh đó.
            for (Node nextNode : nodes) {
                if(a[curNode.index][nextNode.index] != 0 && visited.contains(nextNode) == false)
                {
                    int newDistance = curNode.distance + a[curNode.index][nextNode.index];
                    if(newDistance < nextNode.distance)
                    {
                        nextNode.distance = newDistance;
                        nextNode.previous = curNode;
                        if(priQueue.contains(nextNode) == false){
                            priQueue.add(nextNode);
                        }else{
                            priQueue.remove(nextNode);
                            priQueue.add(nextNode);
                            // System.out.println("==== ERRROR ==== "+ curNode.index + " - " + nextNode.index );
                        }
                    }
                }
            }

            //Bước 4: Đánh dấu đỉnh đang xét thành đỉnh đã duyệt.
            visited.add(curNode);
        }

        System.out.println("Khoang cach nho nhat tu " + start + " den " + finish + ": " + nodes[finish].distance);
        System.out.println("Duong di la:");

        Node iNode = nodes[finish];
        while(iNode != null){
            System.out.print(iNode.index + " <- ");
            iNode = iNode.previous;
        }
    }
}