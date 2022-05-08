public class Bai441 {
    public static int arrangeCoins(int n) {
        int kq = (int) Math.floor(Math.sqrt(n));
        long sum = kq * (kq + 1) / 2;
        while (sum < n) {
            kq++;
            sum += kq;
        }
        return sum > n ? (kq - 1) : kq;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(6));
    }
}
