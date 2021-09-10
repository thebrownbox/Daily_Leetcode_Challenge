import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * HoangVanCong
 */
public class HoangVanCong {
    // ***************************** DS ****************************/
    public static final int MAX = 100;

    public static class Range {
        public final int begin;
        public final int end;
        public final int size;

        public Range(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.size = this.end - this.begin - 1;
        }

        public boolean isValid() {
            return this.size > 0;
        }

        public void show() {
            System.out.println("size: " + size);
            for (int i = begin + 1; i < this.end; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        public boolean isDistinct(Range other){
            if((this.end <= other.begin) || (this.begin >= other.end)){
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "(" + this.begin + "; " + this.end + ")";
        }
    }

    public static class SortByBegin implements Comparator<Range> {
        @Override
        public int compare(HoangVanCong.Range o1, HoangVanCong.Range o2) {
            return Integer.compare(o1.begin, o2.begin);
        }
    }

    public static class SortBySize implements Comparator<Range> {
        @Override
        public int compare(HoangVanCong.Range o1, HoangVanCong.Range o2) {
            if(o1.size != o2.size){
                return Integer.compare(o1.size, o2.size);
            }
            return Integer.compare(o1.begin, o2.begin);
        }
    }

    // ***************************** Main Processes ****************************/
    // ! Task 1
    public static List<Range> generateRange(int N) {
        List<Range> list = new ArrayList<>();
        Random random = new Random();

        // 30% Generate nagative range
        int negativeCount = (int) Math.ceil((N / 10.0) * 3);
        int positiveCount = N - negativeCount;
        // System.out.println("negativeCount: " + negativeCount + " othersCount: " + positiveCount);

        for (int i = 0; i < N; i++) {
            int begin, end;
            if (i < negativeCount) {
                begin = random.nextInt(MAX) - MAX;
            } else {
                begin = random.nextInt(MAX);
            }
            end = begin + 2 + random.nextInt(MAX);
            list.add(new Range(begin, end));
        }

        return list;
    }

    // ! Task 2
    public static List<Range> findMaxNumDistinctRanges(List<Range> ranges) {
        List<Range> results = new ArrayList<>();
        int N = ranges.size();
        
        //maxCount[i] = max number of distinct that have to include the ith range
        int maxCount[] = new int[N];

        // k = previous[i] means If I have to take ith range, the previous range I should take i k
        int previousSelected[] = new int[N];

        // Preprocess the range
        Collections.sort(ranges, new SortByBegin());

        int finalMaxIndex = 0;
        int maxNumberOfRange = 0;
        for (int i = 0; i < ranges.size(); i++) {
            previousSelected[i] = -1;
            int curMaxCount = 1;
            Range curRange = ranges.get(i);
            // Find previous maxCount that can add currentRange
            for (int j = i-1; j >= 0; j--) {
                Range prevRange = ranges.get(j);
                if(curRange.isDistinct(prevRange)){
                    if(maxCount[j] + 1 > curMaxCount){
                        curMaxCount = maxCount[j] + 1;
                        previousSelected[i] = j;
                    }
                }
            }
            maxCount[i] = curMaxCount;
            if(maxCount[i] > maxNumberOfRange){
                maxNumberOfRange = maxCount[i];
                finalMaxIndex = i;
            }
        }

        // trace back to get results
        int i = finalMaxIndex;
        while(i != -1){
            results.add(ranges.get(i));
            i = previousSelected[i];
        }

        Collections.sort(results, new SortBySize());

        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");
        int N = scanner.nextInt();

        //! Task 1
        System.out.println("=== Task 1 ===");
        var generatedList = generateRange(N);
        System.out.println(N);
        for (Range range : generatedList) {
            System.out.println(range);
        }

        //! Task 2
        var result = findMaxNumDistinctRanges(generatedList);
        System.out.println("=== Task 2 ===");
        for (Range range : result) {
            System.out.println(range);
        }

        // TEST_1();
        // TEST_2();
    }

    public static void TEST_1(){
        List<Range> inputs = new ArrayList<>();
        inputs.add(new Range(1, 4));
        inputs.add(new Range(-1, 10));
        inputs.add(new Range(-4, 0));
        var result = findMaxNumDistinctRanges(inputs);
    }

    public static void TEST_2(){
        List<Range> inputs = new ArrayList<>();
        inputs.add(new Range(5, 7));
        inputs.add(new Range(3, 5));
        inputs.add(new Range(1, 3));
        var result = findMaxNumDistinctRanges(inputs);
    }
}