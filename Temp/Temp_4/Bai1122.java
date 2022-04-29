import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bai1122 {
    public int[] relativeSortArray(int[] a, int[] p) {
        List<Integer> list = new ArrayList<>();
        int[] indexs = new int[1001];

        for (int i = 0; i < p.length; i++) {
            indexs[p[i]] = (i + 1);
        }

        for (Integer i : a) {
            list.add(i);
            if (indexs[i] == 0) {
                indexs[i] = 1000 + i;
            }
        }

        list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return indexs[o1] - indexs[o2];
            }

        });

        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        return a;
    }
}
