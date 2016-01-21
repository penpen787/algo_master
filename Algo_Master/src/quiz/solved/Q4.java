package quiz.solved;

import org.junit.Test;

public class Q4 {

	/*
	 * problem :
	 * https://leetcode.com/problems/plus-one/https://leetcode.com/problems
	 * /plus-one/ Given a non-negative number represented as an array of digits,
	 * plus one to the number. The digits are stored such that the most
	 * significant digit is at the head of the list.
	 */

	@Test
	public void solve() {
		
//		int[] arr = { 9, 9, 9 };
		int[] arr = { 3, 4, 7 };
		
		int[] result = this.plusOne(arr);
		
		for(int i : result) {
			System.out.print(i);
		}
	}

	public int[] plusOne(int[] arr) {
		
		boolean oversize = false;
		int c = arr.length;
		
		for(int i=c-1; i>=0; i--) {
			
			if(arr[i] == 9) {
				if(i == 0) oversize = true;
				arr[i] = 0;
			} else {
				arr[i] += 1;
				break;
			}
		}
		
		if(oversize) {
			int[] newArr = new int[c+1];
			newArr[0] = 1;
			for(int i=0; i<c; i++) {
				newArr[i+1] = arr[i];
			}
			return newArr;
		} else {
			return arr;
		}
	}

}
