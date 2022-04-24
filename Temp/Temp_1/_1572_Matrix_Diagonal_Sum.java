public class _1572_Matrix_Diagonal_Sum {
    public int diagonalSum(int[][] a) {
        int sum = 0;
        
        // Duong cheo chinh
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
            a[i][i] = 0;
        }

        // Duong cheo phu
        for (int i = 0, j = a.length - 1; i < a.length && j >= 0; i++,j--) {
            sum += a[i][j];
        }

        return sum;
    }
}
