import java.util.Scanner;

/**
 * Temp1
 */
public class Temp1 {
    /**
     * Print the square like below:
     * Ex:   n = 4     
     *      * * * *
     *      *     *
     *      *     *
     *      * * * *
     */
    public static void printSquare_level_1(int n) {
        // Print 1st line
        if(n >= 1){
            for (int i = 0; i < n; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Print 2nd to (n-1)th line: k lines
        for (int line = 2; line <= n-1; line++) {
            // print: *      * (only print the first and the last)
            for (int i = 0; i < n; i++) {
                if(i == 0 || i == (n-1)){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
        // Print the last line (the same with first line)
        if(n >= 2){
            for (int i = 0; i < n; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printSquare_level_2(int n) {
        for (int line = 0; line < n; line++) {
            // The first and the last line
            if(line == 0 || line == (n-1)){
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }else{ // From 2nd line to (n-1)th line
                for (int j = 0; j < n; j++) {
                    // => Only print the first and the last character
                    if(j == 0 || j == (n-1)){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void printSquare_level_3(int n) {
        for (int line = 0; line < n; line++) {
            for (int pos = 0; pos < n; pos++) {
                if(line == 0 || line == (n-1) || pos == 0 || pos == (n-1)){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        // printSquare_level_1(n);
        // printSquare_level_2(n);
        printSquare_level_3(n);
    }
}