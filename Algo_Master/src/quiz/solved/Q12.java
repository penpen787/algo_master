package quiz.solved;

import org.junit.Test;

public class Q12 {
	/**
	 * count primes 
	 * https://leetcode.com/problems/count-primes/
	 */

	@Test
	public void solve() {
		long start = System.currentTimeMillis();
		
		int n = 1500000;
		int primes = countPrimes(n);
		System.out.println(primes);
		
		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start) + " ms");
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
		
		int cnt = 0;
		
		for(int i=2; i<= n; i++) {
			if(arr[i] == 0)
				continue;
			
			if(isPrime(arr[i])) {
//				System.out.println("Prime: " + arr[i]);
				cnt++;
			} else {
				arr[i] = 0;
			}
			
			int c = 2;
			while(true) {
				int val = i * c++;
				if(val <= n) {
					arr[val] = 0;
				} else {
					break;
				}
			}
		}
		
		return cnt;
	}
	
	// TODO: refactoring need
	public boolean isPrime(int num) {
		
		for(int i=2; i * i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
