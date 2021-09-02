import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    /**
     * I 1 V 5 X 10 L 50 C 100 D 500 M 1000
     */
    public String getName(int i){
        if(i == 1) return "Gold Medal";
        if(i == 1) return "Silver Medal";
        if(i == 1) return "Bronze Medal";
        return i + "";
    }
    public String[] findRelativeRanks(int[] score) {
        String result[] = new String[score.length];

        Map<Integer, Integer> myMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            myMap.put(score[i], i);
        }

        int i = 1;
        for (var entry : myMap.entrySet()) {
            int index = entry.getValue();
            result[index] = getName(i);
            i++;
        }


        return result;
    }


   

    public boolean isMonotonic(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        // Kiem tra mang tang dan
        List<Integer> tangDan = new ArrayList<>(list);
        tangDan.sort(Comparator.naturalOrder());

        boolean giongHetMangTangDan = true;
        for (int i = 0; i < arr.length; i++) {
            if(list.get(i) != tangDan.get(i)){
                giongHetMangTangDan = false;
                break;
            }
        }

        if(giongHetMangTangDan == true) return true;

        // Kiem tra mang giam dan
        List<Integer> giamDan = new ArrayList<>(list);
        giamDan.sort(Comparator.reverseOrder());

        boolean giongHetMangGiamDan = true;
        for (int i = 0; i < arr.length; i++) {
            if(list.get(i) != giamDan.get(i)){
                giongHetMangGiamDan = false;
                break;
            }
        }

        if(giongHetMangGiamDan == true) return true;

        return false;
    }

    public boolean isMonotonic(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        // Kiem tra mang tang dan
        List<Integer> tangDan = new ArrayList<>(list);
        tangDan.sort(Comparator.naturalOrder());
        if(tangDan.equals(list)) 
            return true;

        // Kiem tra mang giam dan
        List<Integer> giamDan = new ArrayList<>(list);
        giamDan.sort(Comparator.reverseOrder());
        if(giamDan.equals(list)) 
            return true;

        return false;
    }

    public static void main(String[] args) {
        
    }

}
