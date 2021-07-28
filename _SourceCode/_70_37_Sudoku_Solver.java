import java.util.ArrayList;
import java.util.List;

/**
 * 37. Sudoku Solver [H]
 * https://leetcode.com/problems/sudoku-solver/
 * Tags: #backtracking #recursion
 */
public class _70_37_Sudoku_Solver {
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



    private final int SIZE = 9;
    public boolean bIsFound = false;
    private char[][] result = new char[SIZE][SIZE];

    private void copyTo(char[][] a, char[][] b)
    {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[i][j];
            }
        }
    }

    // Check is a[i][j] is a valid config?
    private boolean isValidCell(char[][] a, int cur_i, int cur_j, char c)
    {
        for (int k = 0; k < a.length; k++) {
            if(a[cur_i][k] == c || a[k][cur_j] == c)
                return false;
        }
        int i0 = (cur_i / 3) * 3;
        int j0 = (cur_j / 3) * 3;
        for (int i = i0; i < i0+3; i++) {
            for (int j = j0; j < j0+3; j++) {
                if(a[i][j] == c)
                    return false;
            }
        }
        return true;
    }

    private void backtrack(int i, int j, char[][] a)
    {
        if(i >= 0 && i <= 8 && j >= 0 && j <= 8 && bIsFound == false)
        {
            if(a[i][j] == '.')// chi xu ly nhung o dang trong
            {
                //Thu cac truong hop tai (i,j)
                for (int k = 1; k <= 9 && !bIsFound; k++) {
                    char c = (char)('0' + k);
                    if(isValidCell(a, i, j, c))
                    {
                        a[i][j] = c;
                    
                        if(i == 8 && j == 8)
                        {
                            //check
                            if(isValidSudoku(a)){
                                bIsFound = true;
                                copyTo(a, result);
                                return;
                            }
                        }
                        else
                        {
                            int next_i = i, next_j = j;
                            if(next_j < 8){// Dich sang phai
                                next_j++;
                            }else{ // Xuong dong, lui ve dau dong
                                next_i++;
                                next_j = 0;
                            }
                            backtrack(next_i, next_j, a);
                        }
                    }

                    a[i][j] = '.';
                }
                a[i][j] = '.';
                
            }
            else// Di chuyen den o tiep theo
            {
                if(i == 8 && j == 8)
                {
                    //check
                    if(isValidSudoku(a)){
                        bIsFound = true;
                        copyTo(a, result);
                        return;
                    }
                }
                else
                {
                    if(bIsFound == false)
                    {
                        if(j < 8){// Dich sang phai
                            j++;
                        }else{ // Xuong dong, lui ve dau dong
                            i++;
                            j = 0;
                        }
                        backtrack(i, j, a);
                    }
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
        copyTo(result, board);
    }


 

    public static void main(String[] args) {
        _70_37_Sudoku_Solver solver = new _70_37_Sudoku_Solver();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solver.solveSudoku(board);
        System.out.println("Found: " + solver.bIsFound);
    }
}