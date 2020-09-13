// https://leetcode.com/problems/open-the-lock

import java.util.*;

public class Castle_on_the_Grid {
    static int N;
    static int M;
    static class ToaDo{
        ToaDo(){x = y = 0;}
        ToaDo(int x, int y) { this.x = x; this.y = y;}
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ToaDo toaDo = (ToaDo) o;
            return x == toaDo.x &&
                    y == toaDo.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        N = grid.length;
        M = grid[0].length();
        int[][] G = new int[N][M];
        int[][] D = new int[N][M];
        boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                D[i][j] = Integer.MAX_VALUE;
                G[i][j] = grid[i].charAt(j) == '.' ? 0 : 1;
            }
        }

        Queue<ToaDo> mQueue = new LinkedList<>();
        ToaDo start = new ToaDo(startX, startY);
        ToaDo finish = new ToaDo(goalX, goalY);

        mQueue.add(start);
        D[startX][startY] = 0;
        while (mQueue.isEmpty() == false)
        {
            ToaDo curNode = mQueue.poll();

            // Node dang xet la node can tim
            if(curNode.equals(finish)){
                return D[goalX][goalY];
            }

            // Danh dau node dang xet
            isVisited[curNode.x][curNode.y] = true;

            // Lay Node Canh No && chua tham
            //1. Duyet Len tren
            int x = curNode.x,y = curNode.y;
            while (x-1 >= 0 && G[x-1][y] == 0 && isVisited[x-1][y] == false){
                x--;
                D[x][y] = Math.min(D[curNode.x][curNode.y] + 1, D[x][y]);
                mQueue.add(new ToaDo(x,y));
            }

            //2. Duyet xuong duoi
            x = curNode.x; y = curNode.y;
            while (x+1 < N && G[x+1][y] == 0 && isVisited[x+1][y] == false){
                x++;
                D[x][y] = Math.min(D[curNode.x][curNode.y] + 1, D[x][y]);
                mQueue.add(new ToaDo(x,y));
            }

            //3. Duyet sang trai
            x = curNode.x; y = curNode.y;
            while (y-1 >= 0 && G[x][y-1] == 0 && isVisited[x][y-1] == false){
                y--;
                D[x][y] = Math.min(D[curNode.x][curNode.y] + 1, D[x][y]);
                mQueue.add(new ToaDo(x,y));
            }

            //3. Duyet sang phai
            x = curNode.x; y = curNode.y;
            while (y+1 < M && G[x][y+1] == 0 && isVisited[x][y+1] == false){
                y++;
                D[x][y] = Math.min(D[curNode.x][curNode.y] + 1, D[x][y]);
                mQueue.add(new ToaDo(x,y));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
    }
}
