import java.util.ArrayList;
import java.util.List;

public class _15_448_Find_All_Numbers_Disappeared_in_an_Array
{
    public static List<Integer> findDisappearedNumbers(int[] nums)
    {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] exist = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
        {
            // 1 <= nums[i] <= n
            // 1 1 2 4
            // exist[a[0]] = exist[1] = true
            // exist[a[1]] = exist[1] = true
            // exist[a[2]] = exist[2] = true
            // exist[a[3]] = exist[4] = true
            //               exist[3] ====> false

            exist[nums[i]] = true;
        }

        // 1...4
        for (int i = 1; i <= nums.length; i++)
        {
            if(exist[i] == false)
            {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
