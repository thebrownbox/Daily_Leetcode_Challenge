import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 * Level: E
 * Tags: Array
 */

public class _929_Unique_Email_Addresses {
    static public String reformatEmail(String email)
    {
        int index = email.lastIndexOf("@");
        String localName = email.substring(0, index);
        String hostName = email.substring(index+1);

        localName = localName.replace(".", "");
        index = localName.indexOf("+");
        if(index >= 0)
        {
            localName = localName.substring(0, index);
        }

        return localName + "@" + hostName;
    }

    static public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            String fomartedEmail = reformatEmail(emails[i]);
            set.add(fomartedEmail);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String s = reformatEmail("m.y+name@email.com");
        System.out.println(s);
    }
}
