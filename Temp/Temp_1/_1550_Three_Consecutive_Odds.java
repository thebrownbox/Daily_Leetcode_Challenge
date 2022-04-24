public class _1550_Three_Consecutive_Odds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int ai : arr) {
            count = ai % 2 == 0 ? 0 : (count + 1);
            if(count == 3){
                return true;
            }
        }

        return false;
    }
}
