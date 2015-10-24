package quiz;

import org.junit.Test;

/**
 * Number Combination
 * 임백준씨가 페북에 올린 문제
 * Input A = [1,2], Input B = 3
 * 일때, 1+1+1, 1+2, 총 2가지의 경우의 수 존재
 * Output = 2
 * 
 * Input A = [1,2,3], Input B = 4 
 * Output = 4
 * (1+1+1+1, 1+1+2, 1+3, 2+2)
 * @author PenPen
 * @date   2015.10.23
 */
public class NumberCombination {
	
	public static final int[] I1 = {1,2,3};
	public static final int   I2 = 4;
	
	public static int A = 0;
	
	@Test
	public void solve() {
		loop(0, 0);
		System.out.println("Result : " + A);
	}
	
	public void loop(int index, int s) {
		for(int i=index; i<I1.length; i++) {
			int sum = s;
			sum += I1[i];
			System.out.println("index : " + index + " /  i : " + i + "  /  Value : " + I1[i] + "  /  Sum : " + sum );
			if(sum < I2) {
				loop(i, sum);
			} else if(sum == I2) {
				A++;
				System.out.println("-- Matched i : " + i);
				return;
			} else {
				System.out.println("! Not");
				return;
			}
		}
	}
}
