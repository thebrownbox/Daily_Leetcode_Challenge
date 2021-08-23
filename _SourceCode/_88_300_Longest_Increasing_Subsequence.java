public class _88_300_Longest_Increasing_Subsequence {

    public int lengthOfLIS1(int[] a) {
        int n = a.length;
        int[] maxLong = new int[n];
        int maxResult = 1;

        maxLong[0] = 1;
        for (int i = 1; i < maxLong.length; i++) {
            maxLong[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if(a[i] > a[j]){
                    maxLong[i] = Math.max(maxLong[i], maxLong[j]+1);
                }
            }
            maxResult = Math.max(maxResult, maxLong[i]);
        }

        return maxResult;
    }

    
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[] maxLong = new int[n];
        int maxResult = 1;

        maxLong[0] = 1;
        for (int i = 1; i < maxLong.length; i++) {
            maxLong[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if(a[i] > a[j]){
                    maxLong[i] = Math.max(maxLong[i], maxLong[j]+1);
                }
            }
            maxResult = Math.max(maxResult, maxLong[i]);
        }

        return maxResult;
    }


    public static int jump(int[] a) {
        int n = a.length;
        int[] minSteps = new int[n];

        int power = a[0];
        minSteps[0] = 1;
        for (int i = 1; i < a.length; i++) {
            power--;
            if(power >= a[0]){
                minSteps[i] = minSteps[i-1];
            }else{
                power = a[]
            }
            maxPowers[i] = Math.max(a[i], power);
            power = maxPowers[i];
        }

        
        minSteps[0] = 0;
        for (int i = 1; i < minSteps.length; i++) {
            if(maxPowers[i-1] >
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(jump(a));
    }
}
