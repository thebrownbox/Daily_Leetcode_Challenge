import java.util.ArrayList;
import java.util.List;

/**
 * _500_Keyboard_Row
 */
public class _500_Keyboard_Row {
    public static boolean isSameRow_Level1(String word){
        String[] keyBoards = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        char[] arr = word.toCharArray();
        int row = -1;
        for (char c : arr) {
            int curRow = -1;
            for (int i = 0; i < keyBoards.length; i++) {
                if(keyBoards[i].contains(String.valueOf(Character.toLowerCase(c)))){
                    curRow = i;
                    break;
                }
            }
            if(row == -1){
                row = curRow;
            }else{
                if(row != curRow){
                    return false;
                }
            }
        }
        return true;
    }

    //level 2: using hashtable / counting 

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
            if(isSameRow_Level1(s)){
                list.add(s);
            }
        }
        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        
    }
}