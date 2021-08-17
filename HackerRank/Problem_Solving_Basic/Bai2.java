import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai2 {
    private static int[] totalSizeArr = null;
    private static List<Integer> mFileSize;
    private static List<Integer> mParent;
    private static Map<Integer, List<Integer> > childrenMap = new HashMap<>();

    private static void recalculateSize(int folderIndex, int addSize){
        int parentIndex = mParent.get(folderIndex);
        if(parentIndex >= 0)
        {
            totalSizeArr[folderIndex] += addSize;
            recalculateSize(parentIndex, addSize);
        }
    }


    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        // Write your code here
        mFileSize = files_size;
        mParent = parent;
        int n = parent.size();
        totalSizeArr = new int[n];

        for (int childIndex = 0; childIndex < n; childIndex++) {
            int parentIndex = parent.get(childIndex);
            List<Integer> chidrenList = childrenMap.get(parentIndex);
            if(chidrenList == null){
                chidrenList = new ArrayList<>();
                chidrenList.add(childIndex);
                childrenMap.put(parentIndex, chidrenList);
            }else{
                chidrenList.add(childIndex);
            }
            totalSizeArr[childIndex] = files_size.get(childIndex);
        }

        for (int i = 0; i < n; i++) {
            if(childrenMap.get(i) == null){
                recalculateSize(i, mFileSize.get(i));
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        Integer[] a = { -1, 0, 1, 2 };
        Integer[] fileSize = { 1, 4, 3, 4 };
        mostBalancedPartition(Arrays.asList(a), Arrays.asList(fileSize));
    }
}
