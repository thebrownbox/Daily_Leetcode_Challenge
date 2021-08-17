import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai_2_FAILED {
    private static ArrayList<Integer>[] childrenList;
    private static int[] mFolderSizes;
    private static List<Integer> mFileSizeList;
    private static int MIN_DIFF = Integer.MAX_VALUE;

    // Update size của từng folder một | Trả về size của folder hiện tại
    private static int updateFolderSizeDFS(int curFolderIndex){
        // Nếu là lá thì update đúng giá trị của nó
        var myChildren = childrenList[curFolderIndex];
        if(myChildren == null){
            mFolderSizes[curFolderIndex] = mFileSizeList.get(curFolderIndex);
        }else{
            // Tính toán các note con rồi cộng lại
            int sumChildrenSize = 0;
            for (Integer childIndex : myChildren) {
                sumChildrenSize += updateFolderSizeDFS(childIndex);
            }
            mFolderSizes[curFolderIndex] = sumChildrenSize + mFileSizeList.get(curFolderIndex);
        }
        return mFolderSizes[curFolderIndex];
    }

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        int n = parent.size();
        childrenList = new ArrayList[n];
        mFolderSizes = new int[n];
        mFileSizeList = files_size;
        int rootIndex = -1;

        //B1: Cập nhật children của các phần tử
        for (int childIndex = 0; childIndex < childrenList.length; childIndex++) {
            int parentIndex = parent.get(childIndex);
            if(parentIndex >= 0){
                if(childrenList[parentIndex] == null){
                    childrenList[parentIndex] = new ArrayList<>();
                }
                childrenList[parentIndex].add(childIndex);
            }else{
                rootIndex = childIndex;
            }

        }

        //B2: DFS Tính lại file size của từng folder
        updateFolderSizeDFS(rootIndex);

        //B3: tìm xem đoạn nào có thể cắt được
        int totalSize = 0;
        for (Integer fileSize : files_size) {
            totalSize += fileSize;
        }

        for (int i = 0; i < n; i++) {
            int otherSize = totalSize - mFolderSizes[i];
            MIN_DIFF = Math.min(MIN_DIFF, Math.abs(otherSize - mFolderSizes[i]));
        }

        return MIN_DIFF;
    }

    public static void main(String[] args) {
        // testcase 1: expected output: 2
        Integer[] a = { -1, 0, 1, 2 };
        Integer[] fileSize = { 1, 4, 3, 4 };

        // testcase 2: expected output: 19
        // Integer[] a = { -1, 0, 0, 0 };
        // Integer[] fileSize = { 10, 11, 10, 10 };

        // testcase 3: expected output: 0
        // Integer[] a = { -1, 0, 0, 1, 1, 2 };
        // Integer[] fileSize = { 1, 2, 2, 1, 1, 1 };

        mostBalancedPartition(Arrays.asList(a), Arrays.asList(fileSize));
    }
}
