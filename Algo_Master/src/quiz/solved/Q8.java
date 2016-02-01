package quiz.solved;

import org.junit.Test;

public class Q8 {
	/**
	 * Two Sum
	 * 
	 * https://leetcode.com/problems/two-sum/
	 * 
	 * - the array and the target number can be zero(0)
	 * - the array is not sorted
	 */

	int[] numbers = {0, 4, 3, 0};
	int target = 0;

	@Test
	public void solve() {
		int[] solution = twoSum(numbers, target);
		for (int i : solution) {
			System.out.println(i);
		}
	}

	public int[] twoSum(int[] nums, int target) {

		int size = nums.length;
		int[] result = new int[2];
		
		for(int i=0; i<size-1; i++) {
			for(int j=i+1; j<size; j++) {
				int val = nums[i] + nums[j];
				if(val == target) {
					result[0] = i+1;
					result[1] = j+1;
					return result;
				} 
			}
		}
		return result;
	}
}
