package quiz.solved;

import org.junit.Before;
import org.junit.Test;

public class Q10 {
	/**
	 * Move zeroes https://leetcode.com/problems/move-zeroes/
	 * 
	 */

	int[] nums;

	@Before
	public void setup() {
		nums = new int[] { 0, 1, 0, 3, 12 };
	}

	@Test
	public void solve() {
		moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	public void moveZeroes(int[] nums) {
		int zeroCnt = 0;
		int pointer = 0;
		int size = nums.length;
		for(int i=0; i<size; i++) {
			if(nums[i] == 0)
				zeroCnt++;
			else 
				nums[pointer++] = nums[i];
		}
		
		for(int j=size - zeroCnt; j<size; j++) {
			nums[j] = 0;
		}
	}
}
