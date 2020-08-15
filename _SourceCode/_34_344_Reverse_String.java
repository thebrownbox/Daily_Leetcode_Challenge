/**
 *
 */
public class _34_344_Reverse_String {

    public static void swap(char[] arr, int i, int j){
        // Dieu kien dung
        if(i < j){
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            swap(arr, i+1, j-1);
        }
    }

    public static void reverseString(char[] s) {
        swap(s, 0, s.length-1);
    }

    public static void main(String[] args) {
        char[] s = {'1', '2', '3', '4', '5'};
        swap(s, 0 ,s.length-1);

    }
}
