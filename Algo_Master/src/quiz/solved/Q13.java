package quiz.solved;

import org.junit.Before;
import org.junit.Test;

public class Q13 {
	/**
	 * Longest Common Prefix Write a function to find the longest common prefix
	 * string amongst an array of strings.
	 * https://leetcode.com/problems/longest-common-prefix/
	 */

	
	public String[] strs;
	
	@Before
	public void setup() {
		strs = new String[] {
				"TESTT",
				"TES1T", 
				"TEST!"
		};
	}
	
	@Test
	public void solve() {
		String commonPrefix = this.longestCommonPrefix(strs);
		System.out.println(commonPrefix);
	}

	public String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length == 0)
			return "";
		if(strs.length == 1)
			return strs[0];
		
		String common = strs[0];
		for(int i=1; i<strs.length; i++) {
			
			if(common.length() == 0)
				return "";
			
			if(common.length() <= strs[i].length()) {
				common = getCommonPrefixStr(common, strs[i]);
			} else {
				common = getCommonPrefixStr(strs[i], common);
			}
				
		}
		
		return common;
	}

	private String getCommonPrefixStr(String shortStr, String longStr) {
		
		int size = shortStr.length();
		
		for(int i=0; i<size; i++) {
			if(shortStr.charAt(i) != longStr.charAt(i)) {
				return shortStr.substring(0, i);
			}
		}
		
		return shortStr;
	}
}
