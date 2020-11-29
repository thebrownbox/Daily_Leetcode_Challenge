/**
 * https://leetcode.com/problems/backspace-string-compare/
 * Tags: Array, Stack
 */
import java.util.Stack;

public class _844_Backspace_String_Compare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == '#'){
                if(st1.isEmpty() == false)
                    st1.pop();
            }else{
                st1.push(c);
            }
        }


        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if(c == '#'){
                if(st2.isEmpty() == false)
                    st2.pop();
            }else{
                st2.push(c);
            }
        }

        if(st1.size() != st2.size()) return false;
        while(st1.isEmpty() == false)
        {
            char c1 = st1.pop();
            char c2 = st2.pop();
            if(c1 != c2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        
    }
}
