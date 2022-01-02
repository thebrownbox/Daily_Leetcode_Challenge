/**
 * 2022. Convert 1D Array Into 2D Array [E]
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 * Tags: #array
 */
public class _00_2022_Convert_1D_Array_Into_2D_Array {
    public int[][] construct2DArray(int[] a, int row, int col) {
        int total = a.length;
        if (row * col != total)
            return new int[0][0];
        int[][] result = new int[row][col];

        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = a[k++];
            }
        }
        return result;
    }
}
