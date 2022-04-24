import java.util.ArrayList;
import java.util.List;

public class _1380_Lucky_Numbers_in_a_Matrix {

    public List<Integer> luckyNumbers (int[][] a) {
        List<Integer> list = new ArrayList<>();
        int nRow = a.length;
        int nCol = a[0].length;

        for (int row = 0; row < nRow; row++) {
            // Min at row
            int minColIndex = 0;
            for (int col = 0; col < nCol; col++) {
                if(a[row][col] < a[row][minColIndex]){
                    minColIndex = col;
                }
            }
            //Max at col
            boolean isLucky = true;
            for (int i = 0; i < nRow; i++) {
                if(a[row][minColIndex] < a[i][minColIndex] && row != i){
                    isLucky = false;
                    break;
                }
            }
            if(isLucky){
                list.add(a[row][minColIndex]);
            }
        }

        return list;
    }
}
