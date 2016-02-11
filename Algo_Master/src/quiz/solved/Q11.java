package quiz.solved;

import org.junit.Test;

public class Q11 {
	/**
	 * prime selector
	 */

	Long i = 101L;

	@Test
	public void solve() {
		boolean isPrime = this.isPrime(i);
		System.out.println(isPrime);
	}

	// TODO: refactoring need
	public boolean isPrime(Long num) {
		
		for(long i=2; i < num/2 + 1; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
