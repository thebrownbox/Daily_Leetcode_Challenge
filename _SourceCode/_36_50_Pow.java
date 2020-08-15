/**
 *
 */
public class _36_50_Pow {

    public static double myPow(double x, int n) {

        // Dieu kien dung
        if(n == 0)
            return 1;

        //10^-1 1/10
        int n_2 = 0;
        if(n < 0){
//            n = -n; // -1 => 1
            n_2 = n%2==0 ? -(n/2) : (-n-1)/2;
            x = 1/x; // 10 => 1/10
        }else{
            n_2 = n%2 == 0 ? n/2 : (n-1)/2;
        }

        double t = myPow(x, n_2);
        return n%2 == 0 ? (t*t) : (x * t * t);

    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
