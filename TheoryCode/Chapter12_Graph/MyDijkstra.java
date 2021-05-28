import java.util.HashSet;
import java.util.Set;

public class MyDijkstra {
    public static void main(String[] args) {
        int n = 5; // 0- 4
        int[][] a = {   {0, 6, 0, 1, 0},
                        {6, 0, 5, 2, 2},
                        {0, 5, 0, 0, 5},
                        {1, 2, 0, 0, 1},
                        {0, 2, 5, 1, 0} };
        
        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[n]; // distance[i]: khoang cach tu dinh dau cho den i
        int[] previous = new int[n]; // previous[i]: là đỉnh ngay phía trước của i

        int start = 0;
        int finish = 2;
        int oo = Integer.MAX_VALUE;

        // Bước 1: Khởi tạo khoảng cách
        for (int i = 0; i < n; i++) {
            distance[i] = oo;
        }
        distance[start] = 0;

        while(visited.size() < n)
        {
            //Bước 2: Chọn đỉnh chưa duyệt  
            // và đang có khoảng cách nhỏ nhất (từ đỉnh xuất phát) làm đỉnh đang xét.
            int dangXet = 0;
            int minDist = oo;
            for (int i = 0; i < n; i++) {
                if(visited.contains(i) == false && distance[i] < minDist){
                    minDist = distance[i];
                    dangXet = i;
                }
            }

            //Bước 3: Từ đỉnh đang xét, duyệt các ĐỈNH KỀ chưa duyệt: 
            // update khoảng cách và đỉnh trước của các đỉnh đó.
            for (int i = 0; i < n; i++) 
            {
                if(visited.contains(i) == false && a[dangXet][i] != 0)
                {
                    int newDistance = distance[dangXet] + a[dangXet][i];
                    if(newDistance < distance[i])
                    {
                        distance[i] = newDistance;
                        previous[i] = dangXet;
                    }
                }
            }

            //Bước 4: Đánh dấu đỉnh đang xét thành đỉnh đã duyệt.
            visited.add(dangXet);
        }

        System.out.println("Khoang cach nho nhat tu " + start + " den " + finish + ": " + distance[finish]);
        System.out.println("Duong di la:");

        int chay = finish;
        while(chay != start){
            System.out.print(chay + " <- ");
            chay = previous[chay];
        }
        System.out.print(chay);
    }
}
