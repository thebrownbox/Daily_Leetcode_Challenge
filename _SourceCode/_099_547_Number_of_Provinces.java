import java.util.HashSet;

/**
 * 547. Number of Provinces [M]
 * https://leetcode.com/problems/number-of-provinces/
 * Tags: #disjoin_set #union_find
 */

/**
 * _099_547_Number_of_Provinces
 */
public class _099_547_Number_of_Provinces {
    public class QuickFindSet {
        protected int[] root;

        public QuickFindSet(int n) {
            root = new int[n];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
        }

        public int find(int node) {
            return root[node];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                for (int i = 0; i < root.length; i++) {
                    if (root[i] == rootA) {
                        root[i] = rootB;
                    }
                }
            }
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int count() {
            var set = new HashSet<Integer>();
            for (int i = 0; i < root.length; i++) {
                set.add(root[i]);
            }

            return set.size();
        }
    }

    public int findCircleNum(int[][] a) {
        var set = new QuickFindSet(a.length);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i][j] == 1) {
                    set.union(i, j);
                }
            }
        }
        return set.count();
    }
}