import java.util.Stack;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 * Level: M
 * Tags: Stack
 */
public class _856_Score_of_Parentheses {
    public int scoreOfParentheses(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')'){
                count++;
                stack.pop();
            }else{
                stack.push(c);
            } 
        }

        return count;
    }
}
