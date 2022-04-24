/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 187. Repeated DNA Sequences [M]
 * Tags: #hashtable
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        StringBuilder sb = new StringBuilder();
        Set<String> mySet = new HashSet<>();
        Set<String> myResults = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(sb.length() >= 10){
                sb.deleteCharAt(0);
            }
            sb.append(c);
            String temp = sb.toString();
            if(mySet.add(temp) == false){
                myResults.add(temp);
            }
        }
        List<String> results = new ArrayList<>();
        for (String str : myResults) {
            results.add(str);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
