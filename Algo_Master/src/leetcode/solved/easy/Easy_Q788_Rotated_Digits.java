package leetcode.solved.easy;

/**
 * https://leetcode.com/problems/rotated-digits
 */
public class Easy_Q788_Rotated_Digits {
    public int rotatedDigits(int n) {
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            boolean hasValidNum = false;
            for(int j=0; j<chars.length; j++) {
                char c = chars[j];
                if(c == '3' || c == '4' || c == '7') {
                    break;
                } else if(c == '2' || c == '5' || c == '6' || c == '9') {
                    hasValidNum = true;
                }
                if(j == (chars.length -1) && hasValidNum) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
