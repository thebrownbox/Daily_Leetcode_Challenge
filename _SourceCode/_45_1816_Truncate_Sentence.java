/**
 * 1816. Truncate Sentence [E]
 * https://leetcode.com/problems/truncate-sentence/
 * Tags: #string #array
 */
public class _45_1816_Truncate_Sentence {
    String f(String s, int k)
    {
        String[] arr = s.split(" ");
        StringBuilder resultSB = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if(i == 0){
                resultSB.append(arr[i]);
            }else{
                resultSB.append(" " + arr[i]);
            }
        }

        return resultSB.toString();
    }



    public String truncateSentence(String s, int k) {
        int countSpace = 0;
        s = s + " ";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                countSpace++;
            }
            if(countSpace == k){
                return s.substring(0, i);
            }
        }
        return "";
    }
}
