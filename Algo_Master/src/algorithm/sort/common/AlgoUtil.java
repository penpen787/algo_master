package algorithm.sort.common;

import java.util.Random;

public class AlgoUtil {

	public static int[] makeRandomIntArr(int size) {
		int[] arr = new int[size];
		for(int i=0; i<size; i++) arr[i] = i+1;
		
		// Suffle
		Random ran = new Random(System.currentTimeMillis());
		for(int i=0; i<size; i++) {
			int randomIndex = ran.nextInt(size);
			int tmpValue = arr[i];
			arr[i] = arr[randomIndex];
			arr[randomIndex] = tmpValue;
		}
		return arr;
	}
	
}
