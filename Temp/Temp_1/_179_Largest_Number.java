import java.util.Arrays;
import java.util.Comparator;

public class _179_Largest_Number {
    
    public static String removeFirstZero(String s){
        while(s.length() > 1 && s.charAt(0) == '0'){
            s = s.substring(1);
        }
        return s;
    }

    public static String largestNumber(int[] a) {
        String[] arr = new String[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(a[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2+o1);
            }
        });

        String result = "";
        for (String s : arr) {
            result = s + result; 
        }

        return removeFirstZero(result);
    }
}
