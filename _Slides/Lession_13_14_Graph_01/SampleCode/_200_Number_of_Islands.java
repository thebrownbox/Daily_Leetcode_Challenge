import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * _200_Number_of_Islands Url: https://leetcode.com/problems/number-of-islands/
 */

public class _200_Number_of_Islands {

    public int numIslandsBFS(char[][] grid) {
        int count = 0;

        return count;
    }

    public int numIslands(char[][] grid) {
        return numIslandsBFS(grid);
    }

    public static class ToaDo {
        int x, y;

        ToaDo() {
        }

        ToaDo(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public static void main(String[] args) {
        Set<ToaDo> set = new HashSet<>();
        ToaDo s1 = new ToaDo(1, 1);
        ToaDo s2 = new ToaDo(1, 1);

        System.out.println("set.add(s1): " + set.add(s1));
        System.out.println("set.add(s2): " + set.add(s2));
        System.out.println("set.size(): " + set.size());
    }

}