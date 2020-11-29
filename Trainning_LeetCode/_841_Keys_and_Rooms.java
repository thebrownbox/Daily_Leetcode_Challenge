import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 */
public class _841_Keys_and_Rooms {
    List<List<Integer>> mRooms;
    int N = 0;
    int nCount = 0;
    boolean[] checked;
    public void DFS(int id)
    {
        // 1. Set hop le
        if(id < 0 || id >= N) return;
        
        // 2. Diem do phai chua duoc xet
        if(checked[id] == true) return;

        // 3. Xu ly
        nCount++;

        // 4. Danh dau da duyet
        checked[id] = true;

        // 5. Duyet sang cac dinh khac
        for (int i = 0; i < mRooms.get(id).size(); i++) {
            DFS(mRooms.get(id).get(i));
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        mRooms = rooms;
        N = mRooms.size();
        checked = new boolean[N];

        DFS(0);

        return nCount == N;
    }
    public static void main(String[] args) {
        
    }
}
