package leetcode.solved.easy;

import org.junit.Test;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class Easy_Q771_JewelAndStones {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        char[] jArr = J.toCharArray();
        char[] sArr = S.toCharArray();
        for(char s : sArr) {
            for(char j : jArr) {
                if(s == j) cnt++;
            }
        }
        return cnt;
    }
}
