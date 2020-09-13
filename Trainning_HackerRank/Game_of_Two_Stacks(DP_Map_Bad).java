// https://leetcode.com/problems/open-the-lock


import java.lang.annotation.Target;
import java.util.*;

public class Game_of_Two_Stacks {

    static class ToaDo{
        int x,y;
        ToaDo() {x=y=0;}
        ToaDo(int x, int y){ this.x = x; this.y = y;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ToaDo toaDo = (ToaDo) o;
            return x == toaDo.x &&
                    y == toaDo.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static int twoStacks(int x, int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        Map<ToaDo, Integer> Count = new HashMap<>();

        int max = 0;
        Count.put(new ToaDo(0, 0), 0);
        for (int i = 1; i <=n ; i++) {
            int newVal = Count.get(new ToaDo(i-1,0)) + a[i-1];
            Count.put(new ToaDo(i, 0), newVal);
            if(newVal <= x)
                max = Math.max(max, i);
            else break;
        }

        for (int j = 1; j <= m; j++) {
            int newVal = Count.get(new ToaDo(0,j-1)) + b[j-1];
            Count.put(new ToaDo(0, j), newVal);
            if(newVal <= x)
                max = Math.max(max, j);
            else break;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(Count.containsKey(new ToaDo(i,0)) == false || Count.containsKey(new ToaDo(0,j)) == false)
                    break;
                int newVal = Count.get(new ToaDo(i,0)) + Count.get(new ToaDo(0,j));

                if(newVal <= x)
                    max = Math.max(max, i+j);
                else
                    break;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int x = 10;
        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};
        System.out.println(twoStacks(x, a, b));
    }
}
