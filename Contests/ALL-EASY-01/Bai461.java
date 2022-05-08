public class Bai461 {
    public int hammingDistance1(int x, int y) {
        int kq = x ^ y;
        String s = Integer.toBinaryString(kq);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static String chuanHoa(String s) {
        if (s.length() < 32) {
            int k = 32 - s.length();
            for (int i = 0; i < k; i++) {
                s = '0' + s;
            }
        }
        return s;
    }

    public int hammingDistance(int x, int y) {
        String s1 = chuanHoa(Integer.toBinaryString(x));
        String s2 = chuanHoa(Integer.toBinaryString(y));
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
