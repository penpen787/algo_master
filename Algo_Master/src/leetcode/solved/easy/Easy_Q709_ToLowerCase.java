package leetcode.solved.easy;

import org.junit.Test;

public class Easy_Q709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        char capA = 'A';
        char capZ = 'Z';
        int gap = 'A' - 'a';

        for(int i=0; i < chars.length; i++) {
            char c = chars[i];
            if(c >= capA && c <= capZ) {
                chars[i] = (char)(c - gap);
            }
        }
        return new String(chars);
    }

    @Test
    public void test1() {
        System.out.println(toLowerCase("Asdf"));
        System.out.println(toLowerCase("1928_ASDFZXCV"));
    }
}


