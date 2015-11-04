package quiz.trying;

import org.junit.Test;

public class Q2 {
	
/**
 *  Q. Make a program that gets the sum of all answers.
 *  	- If integer A is divided by N, the quotient and the reminder IS SAME
 *  	- ex) for input N = 3, A is 4 (Q=1, R=1) and 8 (Q=2, R=2).
 *  		  So, the answer is 12 (4+8)
 *  	- N <= 2,000,000
 *  
 */
	
	final int MAX = 2000000;
	final int N = 7;
	
	/*
	 *  My Answer. I think.. It's rather a math problem. when N=4, 4*1.. 1 -> 5,  4*2..2 -> 10, 4*3..3 -> 15
	 *  So, Sigma (when n from 1 to (N-1)) (N+1)*n
	 */
	@Test
	public void run() {
		long sum = 0;
		for(int i=1; i<N; i++) {
			sum += (N+1) * i;
		}
		System.out.println(sum);
	}
	
}
