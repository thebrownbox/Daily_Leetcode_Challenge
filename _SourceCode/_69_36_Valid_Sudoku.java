/**
 * 36. Valid Sudoku [M] 
 * https://leetcode.com/problems/valid-sudoku/ 
 * Tags: #hashtable #array
 */
public class _69_36_Valid_Sudoku {

    // Check row k
    private boolean checkRowAndCol(char[][] a, int k, boolean isRow) {
        boolean[] daXuatHien = new boolean[a.length+1];

        for (int j = 0; j < a.length; j++) {
            char c = isRow ? a[k][j] : a[j][k];
            if(c != '.')
            {
                int c_int = (int)c - (int)('0');
                if(daXuatHien[c_int] == true)
                    return false;
                daXuatHien[c_int] = true;
            }
        }

        return true;
    }

    // Check block 3x3 from (i,j)
    private boolean checkBlock(char[][] a, int i0, int j0) {
        boolean[] daXuatHien = new boolean[a.length+1];
        int i_end = i0 + 3;
        int j_end = j0 + 3;

        for (int i = i0; i < i_end; i++) {
            for (int j = j0; j < j_end; j++) {
                char c = a[i][j];
                if(c != '.')
                {
                    int c_int = (int)c - (int)('0');
                    if(daXuatHien[c_int] == true)
                        return false;
                    daXuatHien[c_int] = true;
                } 
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] a) {
        // Kiem tra cac hang ngang
        // Kiem tra cac hang doc
        for (int i = 0; i < a.length; i++) {
            if (!checkRowAndCol(a, i, true) || !checkRowAndCol(a, i, false))
                return false;
        }

        // Kiem tra cac block 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if(checkBlock(a, i, j) == false)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] a = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        _69_36_Valid_Sudoku test = new _69_36_Valid_Sudoku();
        System.out.println(test.isValidSudoku(a));
    }
}
