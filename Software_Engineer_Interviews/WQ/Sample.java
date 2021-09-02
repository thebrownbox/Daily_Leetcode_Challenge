/**
 * Sample
 */
public class Sample {

    public static boolean check(String key, String sample){
        int k = 0;
        for (int i = 0; i < sample.length(); i++) {
            if(sample.charAt(i) == key.charAt(k)){
                k++;
                if(k >= key.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String key = "123";
        String sample1 = "a1...2..3...";
        String sample2 = "123";
        String sample3 = "...2...3..";
        String sample4 = "...123";
        String sample5 = "...12";
        System.out.println(check(key, sample1));
        System.out.println(check(key, sample2));
        System.out.println(check(key, sample3));
        System.out.println(check(key, sample4));
        System.out.println(check(key, sample5));
    }
}