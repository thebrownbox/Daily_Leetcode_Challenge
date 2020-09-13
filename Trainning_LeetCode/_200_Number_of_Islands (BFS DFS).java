import javafx.util.Pair;

//https://leetcode.com/problems/number-of-islands/
public class _200_Number_of_Islands {
    class Solution {
        int N,M;
        boolean[][] marked;
        char[][] grid;

        void update(int i, int j)
        {
            // Out of bound
            if(i >= N || j >= M || i < 0 || j < 0) return;
            // already visited
            if(marked[i][j] == true) return;
            if(grid[i][j] == '0') return;

            // Update current Node
            marked[i][j] = true;

            // Up
            update(i,j-1);
            // Down
            update(i,j+1);
            // Left
            update(i-1, j);
            // Right
            update(i+1, j);
        }

        public int numIslands(char[][] grid) {
            if(grid.length == 0) return 0;
            this.grid = grid;
            N = grid.length;
            M = grid[0].length;
            marked = new boolean[N][M];

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(grid[i][j] == '1' && marked[i][j] == false){
                        count++;
                        update(i, j);
                    }
                }
            }

            return count;
        }
    }


    public static void main(String[] args) {
        Pair<Integer, Integer> p1 = new Pair<>(1,2);
        Pair<Integer, Integer> p2 = new Pair<>(1,2);

        System.out.println(p1.equals(p2));
    }
}
