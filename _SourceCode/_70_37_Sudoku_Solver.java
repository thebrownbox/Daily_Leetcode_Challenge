/**
 * 37. Sudoku Solver [H]
 * https://leetcode.com/problems/sudoku-solver/
 * Tags: #backtracking #recursion #hashtable 
 */

public class _70_37_Sudoku_Solver {

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
        for (int i = 0; i < a.length; i++) {
            if (!checkRowAndCol(a, i, true) || !checkRowAndCol(a, i, false))
                return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if(checkBlock(a, i, j) == false)
                    return false;
            }
        }

        return true;
    }


    private boolean mIsFound = false;

    private void backtrackToNext(char[][] a, int i, int j)
    {
        int next_i, next_j;
        if(j < 8){
            next_i = i;
            next_j = j+1;
        }else{
            next_i = i+1;
            next_j = 0;
        }
        backtrack(a, next_i, next_j);
    }

    private boolean checkValidValue(char[][] a, int cur_i, int cur_j, char c) {
        //Kiểm tra hàng ngang và dọc xem c đã tồn tại hay chưa?
        for (int k = 0; k < 9; k++) {
            if(a[cur_i][k] == c || a[k][cur_j] == c)
                return false;
        }

        // Kiểm tra block
        int i0 = (cur_i/3)*3;
        int j0 = (cur_j/3)*3;
        for (int i = i0; i < i0+3; i++) {
            for (int j = j0; j < j0+3; j++) {
                if(a[i][j] == c)
                    return false;
            }
        }

        return true;
    }

    private void copyTo(char[][] a, char[][] b)
    {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                b[i][j] = a[i][j];
            }
        }
    }
    private char[][] result = new char[9][9];
    private void backtrack(char[][] a, int i, int j)
    {
        if(i >= 0 && i <= 8 && j >= 0 && j <= 8 && !mIsFound)
        {
            if(a[i][j] == '.')
            {
                for (char c = '1'; c <= '9' && !mIsFound; c++){
                    if(checkValidValue(a, i, j, c))
                    {
                        a[i][j] = c;
                        if(i == 8 && j == 8) // Kiem tra cấu hình hoàn thiện này có đúng ko?
                        {
                            if(isValidSudoku(a))
                            {
                                copyTo(a, result);
                                mIsFound = true;
                                return;
                            }
                        }
                        else
                        {
                            backtrackToNext(a, i, j);
                        }
                    }
                }
                a[i][j] = '.';
            }
            else
            {
                if(i == 8 && j == 8)// Kiem tra cấu hình hoàn thiện này có đúng ko?
                {
                    if(isValidSudoku(a))
                    {
                        copyTo(a, result);
                        mIsFound = true;
                        return;
                    }
                }
                else if(!mIsFound)
                {
                    backtrackToNext(a, i, j);
                }
            }
        }
    }


    public void solveSudoku(char[][] a) {
        backtrack(a, 0, 0);
        copyTo(result, a);
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        _70_37_Sudoku_Solver solver = new _70_37_Sudoku_Solver();
        solver.solveSudoku(board);
    }
}