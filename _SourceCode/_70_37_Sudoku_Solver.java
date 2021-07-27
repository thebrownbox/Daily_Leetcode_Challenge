/**
 * _69_37_Sudoku_Solver
 */
public class _70_37_Sudoku_Solver {
    private final int SIZE = 9;
    private boolean[][] isVariables = new boolean[SIZE][SIZE];

    private void backtrack(int i, int j, char[][] a)
    {
        if(a[i][j] == '.')// chi xu ly nhung o dang trong
        {

        }
        else// Di chuyen den o tiep theo
        {

        }
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                
            }
        }
    }


    public static void main(String[] args) {
        _70_37_Sudoku_Solver solver = new _70_37_Sudoku_Solver();
        char[][] board = {{'5','3','4','6','7','8','9','1','2'},{'6','7','2','1','9','5','3','4','8'},{'1','9','8','3','4','2','5','6','7'},{'8','5','9','7','6','1','4','2','3'},{'4','2','6','8','5','3','7','9','1'},{'7','1','3','9','2','4','8','5','6'},{'9','6','1','5','3','7','2','8','4'},{'2','8','7','4','1','9','6','3','5'},{'3','4','5','2','8','6','1','7','9'}};
        solver.solveSudoku(board);
    }
}