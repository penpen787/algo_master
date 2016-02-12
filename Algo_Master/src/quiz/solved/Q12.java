package quiz.solved;

import org.junit.Test;

public class Q12 {
	/**
	 * count primes https://leetcode.com/problems/count-primes/
	 */

	@Test
	public void solve() {
		int n = 100;
		int primes = countPrimes(n);
		System.out.println(primes);
	}

	public int countPrimes(int n) {

		if(n == 0 || n == 1)
			return 0;
		else if(n == 2)
			return 1;
			
		
		int[] arr = new int[n+1]; // from
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i< n/2 + 1; i++) {
			int cnt = 1;
			while(true) {
				int val = i * cnt++;
				if(val <= n) {
					
				} else {
					
				}
					
			}
			
		}
		
		return 0;
	}
}
