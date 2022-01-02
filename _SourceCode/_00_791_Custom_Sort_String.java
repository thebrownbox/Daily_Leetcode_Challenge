import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 791. Custom Sort String [M]
 * https://leetcode.com/problems/custom-sort-string/
 * Tags: #string #sort
 */
public class _00_791_Custom_Sort_String {
    public static String customSortString(String order, String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int i1 = order.indexOf(o1);
                int i2 = order.indexOf(o2);
                if(i1 < 0) i1 = 100;
                if(i2 < 0) i2 = 100;
                return i1 - i2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        System.out.println(String.valueOf(list));
    }
}
