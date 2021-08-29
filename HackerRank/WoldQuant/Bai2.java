import java.util.Arrays;
import java.util.List;

public class Bai2 {
    public static int countAnalogousArrays(List<Integer> diffArray, int MIN, int MAX) {

        long prevNumber = MIN;
        long nextNumber = 0;

        long curMin = prevNumber;
        long curMax = prevNumber;
        for (Integer diff : diffArray) {
            nextNumber = prevNumber - diff;
            curMin = Math.min(curMin, nextNumber);
            curMax = Math.max(curMax, nextNumber);
            prevNumber = nextNumber;
        }

        if(curMin < MIN){
            long addMore = MIN - curMin;
            curMax += addMore;
        }

        if(curMax > MAX){
            return 0;
        }

        return (int)(MAX - curMax + 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {-82, 15, -64, 69, -48, 30, 47, 1, -8, -76, 56, -75, 26, 127, -37, -87, -25, 115, 48, -34, -35, -15, 93, -172, 104, -83, 76, 5, -24, 1, 80, -25, 0, 20, -133, 67, 6, -45, 62, 57, -43, -113, -31, 22, 90, -42, 87, -133, -1, 176, -151, -10, 6, 120, -115, 51, 46, -115, 43, 0, -58, 103, 2, -41, -21, -22, 6, 145, -110, 18, 86, -140, -9, 54, 16, -94, 10, 103, -3, 16, 5, 10, -2, -118, 85, 24, 40, 10, -97, -7, -67, 157, -96, -6, 15, 55, -78, -25, 120};
        System.out.println(countAnalogousArrays(Arrays.asList(arr), -200, 200));
    }

}
