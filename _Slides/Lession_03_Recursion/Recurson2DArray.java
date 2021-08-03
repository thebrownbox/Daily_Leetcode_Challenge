import java.security.Principal;

/**
 * Recurson2DArray
 */
public class Recurson2DArray {

    static void travel(int[][] a, int i, int j)
    {
        if(i >= 0 && i < a.length && a.length > 0)
        {
            if(j >= 0 && j < a[0].length)
            {
                System.out.println("["+i+","+j+"]");
                if(j == a[0].length - 1){ // Nếu là phần tử cuối cùng thì
                    // Di chuyển xuống phần tử đầu tiên của dòng dưới 
                    travel(a, i+1, 0);
                }else{ // Nếu không thì
                    // Di chuyển tới phần tử bên cạnh cùng hàng 
                    travel(a, i, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[2][3];
        travel(a, 0, 0);
    }
}