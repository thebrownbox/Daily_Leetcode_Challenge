/**
 * 1221. Split a String in Balanced Strings [Easy]
 * URL: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * Tags: #string
 */

public class _44_1221_Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        int countResult = 0;
        char[] arr = s.toCharArray();
        int countR = 0;
        int countL = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'L'){
                countL++;
            } else{
                countR++;
            }
            if(countL == countR){
                countResult++;
            }
        }

        return countResult;
    }
    
}