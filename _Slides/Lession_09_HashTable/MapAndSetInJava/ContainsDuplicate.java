import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> mySet = new HashSet<>();

        for (int n : nums) {
            if(mySet.contains(n) == true){ // Da ton tai trong mySet
                return true;
            }else{ // Chua ton tai
                mySet.add(n);
            }
        }

        return false;
    }
}
