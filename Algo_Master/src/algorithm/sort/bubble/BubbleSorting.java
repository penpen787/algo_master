package algorithm.sort.bubble;

import algorithm.sort.common.Algorithm;

/**
 * Bubble Sorting Algorithm
 * @author PenPen
 *
 */
public class BubbleSorting implements Algorithm {

	@Override
	public int[] solveIntegers(int[] arr) {

		System.out.println("--- INPUT ---");
		printIntArr(arr);
		
		int size = arr.length - 1;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<(size-i); j++) {
				if( arr[j] > arr[j+1] ) {
					swap(arr, j, j+1);
				}
			}
//			printIntArr(arr);
		}
		
		return arr;
	}

	
	public void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public void printIntArr(int[] arr) {
		for(int a : arr) {
			System.out.printf("%3d", a);
		}
		System.out.println();
	}
	
}
