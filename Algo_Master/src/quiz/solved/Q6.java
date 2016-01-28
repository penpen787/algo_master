package quiz.solved;

import org.junit.Test;

public class Q6 {
	/**
	 * Look-and-say sequence 1 is read off as "one 1" or 11. 11 is read off as
	 * "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. 1211 is
	 * read off as "one 1, then one 2, then two 1s" or 111221. 111221 is read
	 * off as "three 1s, then two 2s, then one 1" or 312211.
	 * 
	 * Given an integer n, generate the nth sequence.
	 * https://leetcode.com/problems/count-and-say/
	 */

	@Test
	public void test() {
		
		int num = 70;
		
		countAndSay(num);
	}

	public String countAndSay(int n) {
		
		String val = "1";	// init value 1
		for(int i=1; i<n; i++) {
			
			// For performance
			StringBuilder sb = new StringBuilder(val.length() * 2); 
			
			char c = val.charAt(0);
			int num = 1;
			
			for(int j=1; j<val.length(); j++) {
				if(c == val.charAt(j)) {
					num++;
					continue;
				} else {
					sb.append(num + "" + c);
					num = 1;
					c = val.charAt(j);
				}
			}
			
			sb.append(num + "" + c);
			val = sb.toString();
			System.out.println(val.length());
		}
		
		System.out.println("LAST : " + val);
		return val;
	}
}
