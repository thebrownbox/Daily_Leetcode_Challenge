public class _1791_Find_Center_of_Star_Graph {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] soCanhNoiVoiToi = new int[n+1];

        for (int[] e : edges) {
            soCanhNoiVoiToi[e[0]]++;
            soCanhNoiVoiToi[e[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if(soCanhNoiVoiToi[i] == (n-1))
                return i;
        }

        return 0;
    }
}
