import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Temp {

public static String toGoatLatin(String s) {
        String result = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i].toLowerCase();
            if (temp.startsWith("a") || temp.startsWith("i") || temp.startsWith("o") || temp.startsWith("e")
                    || temp.startsWith("u")) {
                arr[i] += "ma";
            } else {
                arr[i] = arr[i].substring(1) + arr[i].charAt(0);
                temp = arr[i];
                if(arr[i].startsWith("a") || arr[i].startsWith("i") || arr[i].startsWith("o") || arr[i].startsWith("e")
                || arr[i].startsWith("u")){
                    arr[i] += "ma";
                }
            }
            int j = i + 1;
            while (j > 0) {
                arr[i] += "a";
                j--;
            }
            if(i< arr.length - 1){
                arr[i] += " ";
            }
            result += arr[i];
        }
        return result;
    }

    public static int numRabbits(int[] a) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0){
                result++;
            }else{
                if(count.containsKey(a[i]) == false){
                    count.put(a[i], 1);
                }else{
                    int num = count.get(a[i]);
                    num++;
                    count.put(a[i], num);
                }
            }
        }


        boolean isContunue = true;
        while(count.isEmpty() == false && isContunue){
            isContunue = false;
            for (Map.Entry e : count.entrySet()) {
                int key = (int)e.getKey();
                int sameAwnser = (int)e.getValue();
                if(sameAwnser == 0){
                    continue;
                }
                isContunue = true;
                if(sameAwnser == (key + 1)){
                    result += (key + 1);
                    count.put(key, 0);
                    if(count.isEmpty())
                        break;
                }else{
                    if((key + 1) < sameAwnser){
                        result += (key + 1);
                        int temp = sameAwnser - (key+1);
                        count.put(key, temp);
                    }else{
                        result += (sameAwnser * (key+1));
                        count.put(key, 0);
                        if(count.isEmpty())
                            break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] s = {1,0,1,0,0};
        int[] s2 = {0,2,0,2,1};
        System.out.println(numRabbits(s2));
    }
}
