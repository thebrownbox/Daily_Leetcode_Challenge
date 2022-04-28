import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bai1128 {
    public static class Domino {
        public int a;
        public int b;

        public Domino(int[] arr) {
            this.a = arr[0];
            this.b = arr[1];
        }

        @Override
        public int hashCode() {
            if (a > b) {
                return (this.a + "-" + this.b).hashCode();
            }
            return (this.b + "-" + this.a).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Domino) {
                Domino other = (Domino) obj;
                return (this.a == other.a && this.b == other.b) || (this.a == other.b && this.b == other.a);
            }
            return false;
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<Domino, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            Domino domino = new Domino(d);
            int c = map.getOrDefault(domino, 0);
            count += c;
            map.put(domino, map.getOrDefault(domino, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Domino d1 = new Domino(new int[] { 1, 2 });
        Domino d2 = new Domino(new int[] { 2, 1 });
        System.out.println(d1.equals(d2));
        Set<Domino> set = new HashSet<>();
        set.add(d1);
        set.add(d2);
        System.out.println(set.size());
    }
}
