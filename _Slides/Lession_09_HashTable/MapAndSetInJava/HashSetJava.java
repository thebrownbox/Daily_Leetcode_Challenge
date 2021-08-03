import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetJava {
    public static void main(String[] args) {
        Set<String> myIntSet = new LinkedHashSet<>();

        myIntSet.add("11111");
        myIntSet.add("333");
        myIntSet.add("22");
        myIntSet.add("11111");
        myIntSet.add("22");

        for (String s : myIntSet) {
            System.out.println(s);
        }

    }
}
