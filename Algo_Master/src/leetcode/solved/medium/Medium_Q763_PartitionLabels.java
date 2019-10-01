package leetcode.solved.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Medium_Q763_PartitionLabels {

	public List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<>();

		char[] cArr = S.toCharArray();

		int[] a = new int[26];
		for(int i=0; i<a.length; i++) { // initialize to -1, -1 means the character does not exist in String S
			a[i] = -1;
		}

		for(int i=0; i<cArr.length; i++) {
			int idx = cArr[i] - 'a';
			a[idx] = i;
		}

		int start = 0;
		int end = 0;

		for(int i=0; i<cArr.length; i++) {
			int idx = cArr[i] - 'a';

			if(i == start || a[idx] > end) {
				end = a[idx];
			}
			if(i == end) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}

		return result;
	}

	@Test
	public void test1() {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(s);
		System.out.println(result);
	}

	@Test
	public void test2() {
		String s = "a";
		List<Integer> result = partitionLabels(s);
		System.out.println(result);
	}

	@Test
	public void test3() {
		String s = "ab";
		List<Integer> result = partitionLabels(s);
		System.out.println(result);
	}

	@Test
	public void test4() {
		String s = "aa";
		List<Integer> result = partitionLabels(s);
		System.out.println(result);
	}


}
