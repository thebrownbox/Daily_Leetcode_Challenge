public class _43_200_Number_of_Islands {
    boolean[][] daDuyet = new boolean[300][300];
    int soHang;
    int soCot;

    public boolean isValid(int i, int j){
        return i >= 0 && j >= 0 && i < soHang && j < soCot;
    }

    public void DFS(char[][] a, int i, int j){
        // B1: Dieu kien dung | Bai toan co so
        if(isValid(i, j) == false)
            return;
        if(a[i][j] == '0' || daDuyet[i][j] == true)
            return;

        // Danh dau da duyet
        daDuyet[i][j] = true;

        // B2: De quy | Cong thuc truy hoi
        DFS(a, i, j+1);
        DFS(a, i, j-1);
        DFS(a, i-1, j);
        DFS(a, i+1, j);
    }

    public int numIslands(char[][] a) {
        int count = 0;
        soHang = a.length;
        soCot = a[0].length;

        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                if(a[i][j] == '1' && daDuyet[i][j] == false){
                    DFS(a, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
