package quiz.solved;

import java.util.HashMap;
import java.util.Map;

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

	int[] numbers = {-3, 4, 3, 0};
	int target = 0;

	@Test
	public void solve() {
		int[] solution = twoSum(numbers, target);
		for (int i : solution) {
			System.out.println(i);
		}
	}

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		int size = nums.length;
		
		for(int i=1; i<size; i++) {
			map.put(nums[i], i);
		}
		
		for(int i=0; i<size; i++) {
			if(map.containsKey(target - nums[i]) 
					&& i != map.get(target - nums[i])) {
				return new int[] {i + 1, map.get(target - nums[i]) + 1};
			}
		}
		
		return null;
	}
}
