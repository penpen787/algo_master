package etc.kakao_2017;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author kyunghun.jeon
 *         created on 2017. 9. 30..
 *        
 * 풀이시간 : 00:28:20       
 */
public class Q1_Hidden_Map {

	public String[] getMap(int n, int[] arr1, int[] arr2) {

		String[] strArr = new String[n];
		for(int i=0; i<n; i++) {
			int a1 = arr1[i];
			int a2 = arr2[i];

			int or = a1 | a2;
			String orStr = Integer.toBinaryString(or);
//			System.out.println(orStr);
			String tmpStr = orStr.replace('0', ' ').replace('1', '#');
			
			// Padding 보정
			int tmpStrLength = tmpStr.length();
			if(tmpStrLength < n) {
				for(int j=tmpStrLength; j<n; j++) {
					tmpStr = " " + tmpStr;
				}
			}
			strArr[i] = tmpStr;
//			System.out.println(strArr[i]);
		}
		return strArr;
	}
	
	
	@Test
	public void test1() {
		
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};

		String[] correctAnser = {"#####", "# # #", "### #", "#  ##", "#####"};

		Assert.assertTrue(validate(correctAnser, getMap(n, arr1, arr2)));

	}
	
	@Test
	public void test2() {
		
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};

		String[] correctAnser = {"######", "###  #", "##  ##", " #### ", " #####", "### # "};

		Assert.assertTrue(validate(correctAnser, getMap(n, arr1, arr2)));

	}

	private boolean validate(String[] correctArr, String[] ansArr) {
		for(int i=0; i<correctArr.length; i++) {
			String correct = correctArr[i];
			String ans = ansArr[i];
			if(correct.equals(ans) == false) {
//				System.out.println("false / correct : '" + correct  + "' / ans : '" + ans + "'");
				return false;
			}
		}
		return true;
	}
	
}
