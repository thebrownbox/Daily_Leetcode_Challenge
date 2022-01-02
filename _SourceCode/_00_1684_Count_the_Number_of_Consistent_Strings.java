/**
 * 1684. Count the Number of Consistent Strings [E]
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 * Tags: #string #array
 */
public class _00_1684_Count_the_Number_of_Consistent_Strings {
    
    public boolean isConsistent(boolean[] isGood, String word){
        for (int i = 0; i < word.length(); i++) {
            if(isGood[word.charAt(i)] == false){
                return false;
            }
        }
        return true;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] isGood = new boolean['z'+1];
        for (int i = 0; i < allowed.length(); i++) {
            isGood[allowed.charAt(i) - 'a'] = true;
        }
        
        int count = 0;
        for (String s : words) {
            if(isConsistent(isGood, s)){
                count++;
            }
        }

        return count;
    }

}
