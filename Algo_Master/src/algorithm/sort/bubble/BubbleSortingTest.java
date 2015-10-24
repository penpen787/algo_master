package algorithm.sort.bubble;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithm.sort.common.AlgoUtil;

public class BubbleSortingTest {

	int[] arr;
	public static long startTime;
	
	@Before
	public void setup() {
		arr = AlgoUtil.makeRandomIntArr(10000);
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void post() {
		long endTime = System.currentTimeMillis();
		
		System.out.println("--- Result Time ---");
		System.out.println(endTime - startTime);
	}
	
	@Test
	public void test1() {
		BubbleSorting bs = new BubbleSorting();
		
		bs.solveIntegers(arr);
		
		
	}
	
	
}
