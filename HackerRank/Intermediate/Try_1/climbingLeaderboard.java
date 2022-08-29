import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class climbingLeaderboard {
    // Cach 1
    public static List<Integer> climbingLeaderboard1(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (Integer score : ranked) {
            treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
        }
        for (Integer score : player) {
            treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
            int index = 1;
            for (Integer rankedScore : treeMap.keySet()) {
                if (rankedScore.equals(score)) {
                    result.add(index);
                    break;
                }
                index++;
            }
        }
        return result;
    }

    // Cach 2
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (Integer score : ranked) {
            set.add(score);
        }
        for (Integer score : player) {
            set.add(score);
            int index = 1;
            for (Integer rankedScore : set) {
                if (rankedScore.equals(score)) {
                    result.add(index);
                    break;
                }
                index++;
            }
        }
        return result;
    }
}
