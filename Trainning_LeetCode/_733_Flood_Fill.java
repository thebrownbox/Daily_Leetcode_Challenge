/**
 * https://leetcode.com/problems/flood-fill/
 * Tags: #DFS, #BFS
 */

public class _733_Flood_Fill {

    int nRow = 0;
    int nCol = 0;
    boolean[][] checked;
    public void DFS(int[][] image, int i, int j, int oldColor, int newColor)
    {
        // 1. Check valid
        if(i < 0 || i >= nRow || j < 0 || j >= nCol) return;
        // 2. Not checked and have the color need to change
        if(checked[i][j] == true || image[i][j] != oldColor) return;
        
        // 3. Change the color
        image[i][j] = newColor;

        // 4. Marked as checked.
        checked[i][j] = true;

        // 5. Check neighbors
        DFS(image, i+1, j, oldColor, newColor);
        DFS(image, i-1, j, oldColor, newColor);
        DFS(image, i, j+1, oldColor, newColor);
        DFS(image, i, j-1, oldColor, newColor);
    }

    public int[][] floodFill(int[][] image, int startI, int startJ, int newColor) {
        nRow = image.length;
        nCol = image[0].length;
        int oldColor = image[startI][startJ];
        checked = new boolean[nRow][nCol];

        DFS(image, startI, startJ, oldColor, newColor);

        return image;
    }
}
