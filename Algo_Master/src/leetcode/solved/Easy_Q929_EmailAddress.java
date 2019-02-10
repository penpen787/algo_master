package leetcode.solved;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class Easy_Q929_EmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String m : emails) {
            String[] divided = m.split("@");
            String localName = divided[0].split("\\+")[0];
            String org = localName.replace(".", "");
            set.add(org + "@" + divided[1]);
        }
        return set.size();
    }
}
