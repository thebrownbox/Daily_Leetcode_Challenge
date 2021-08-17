import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai_4_OK {
    
    private static class Node{
        public int value;
        public int freq;
        public Node(int v, int f){
            this.value = v;
            this.freq = f;
        }
    }
    public static int longestSubarray(List<Integer> a) {
        // Write your code here
        int maxCount = 0;
        List<Node> listNode = new ArrayList<>();

        int preValue = 0;
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if(i == 0){
                preValue = a.get(i);
                count = 1;
            }else{
                if(a.get(i) != preValue){
                    listNode.add(new Node(preValue, count));
                    count = 1;
                    preValue = a.get(i);
                }else{
                    count++;
                }
            }
            if(i == a.size()-1){
                listNode.add(new Node(preValue, count));
            }
        }

        int n = listNode.size();
        int[] result = new int[n];
        int[] max = new int[n];
        int[] min = new int[n];

        for (int i = 0; i < n; i++) {
            Node x = listNode.get(i);
            if(i==0){
                result[i] = x.freq;
                min[i] = x.value;
                max[i] = x.value;
            }else{
                if(x.value <= max[i-1] && x.value >= min[i-1]){
                    result[i] = result[i-1] + x.freq;
                    min[i] = min[i-1];
                    max[i] = max[i-1];
                }else{
                    int maxDiff = Math.max(Math.abs(x.value-min[i-1]), Math.abs(x.value-max[i-1]));
                    if(maxDiff >= 2){
                        Node prevNode = listNode.get(i-1);
                        if(Math.abs(x.value - prevNode.value) > 1){
                            result[i] = x.freq;
                            min[i] = x.value;
                            max[i] = x.value;
                        }else{
                            result[i] = x.freq + prevNode.freq;
                            min[i] = Math.min(x.value, prevNode.value);
                            max[i] = Math.max(x.value, prevNode.value);
                        }
                    }else{
                        if(x.value < min[i-1]){
                            min[i] = x.value;
                            max[i] = max[i-1];
                        }else if(x.value > max[i-1]){
                            max[i] = x.value;
                            min[i] = min[i-1];
                        }
                        result[i] = result[i-1] + x.freq;
                    }
                }
            }
        
            maxCount = Math.max(maxCount, result[i]);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        // Integer[] a = {1,1,1,2,2,3,3,3,3};
        Integer[] a = {1,2,1,2,2,1,1,3,3,3};
        longestSubarray(Arrays.asList(a));
    }
}
