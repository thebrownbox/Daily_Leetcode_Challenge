/**
 * _997_Find_the_Town_Judge
 */
public class _997_Find_the_Town_Judge {

    public int findJudge(int N, int[][] trust) {
        int[] soNguoiTinToi = new int[N+1];
        int[] soNguoiToiTin = new int[N+1];

        for (int[] t : trust) {
            soNguoiToiTin[t[0]]++;
            soNguoiTinToi[t[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if(soNguoiTinToi[i] == (N-1) && soNguoiToiTin[i] == 0)
                return i;
        }

        return -1;
    }
}