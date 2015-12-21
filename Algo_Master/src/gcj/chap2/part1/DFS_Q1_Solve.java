package gcj.chap2.part1;

import org.junit.Test;

public class DFS_Q1_Solve {

	@Test
	public void solve(){
		int[] nums = {1,2,3,5,7,9};
		DFS_Q1 q1 = new DFS_Q1(8,nums);
		q1.solve();
	}
}
