public class Bai2206 {
    public boolean divideArray(int[] nums) {
        int[] count = new int[501];
        for (int i : nums) {
            count[i]++;
        }
        for (int i : count) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
