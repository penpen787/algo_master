package etc.kakao_2017;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author kyunghun.jeon
 *         created on 2017. 10. 1
 *        
 * 풀이시간 : 00:43:18      
 */
public class Q2_Dart_Game {

	public int getPoint(String dartResult) {

		int[] points = new int[3];
		char[] chars = dartResult.toCharArray();
		
		// 다트의 순서 : 0,1,2
		int dartIndex = 0;
		// 마지막 다트 종료문자 순서 (이번 다트에서 점수 추출용)
		int lastDartCharIndex = 0; 
		
		for(int i=0; i<chars.length; i++) {
			if (dartIndex == 4) {
				break;
			}
			char c = chars[i];

			if (c == 'S' || c == 'D' || c == 'T') {
				points[dartIndex] = getSquredPoints(Integer.valueOf(dartResult.substring(lastDartCharIndex, i)), c);

				if (i != chars.length - 1) {
					char nextChar = chars[i + 1];
					if (nextChar == '*' || nextChar == '#') {
						
						lastDartCharIndex = i + 2;
						if (nextChar == '*') {
							points[dartIndex] = points[dartIndex] * 2;
							if(dartIndex > 0) {
								points[dartIndex - 1] = points[dartIndex - 1] * 2;
							}
						} else {
							points[dartIndex] = - points[dartIndex];
						}
						
					} else {
						lastDartCharIndex = i + 1;
					}
				}
				dartIndex++;
			}
		}

		int sum = points[0] + points[1] + points[2];
		System.out.println("intput : " + dartResult + " result : " + sum);

		return sum;
	}

	private int getSquredPoints(Integer integer, char c) {
		if (c == 'S') {
			return integer;
		} else if (c == 'D') {
			return (int) Math.pow(integer, 2);
		} else {
			return (int) Math.pow(integer, 3);
		}
	}


	@Test
	public void test() {

		String[] dartResults = {
				"1S2D*3T",
				"1D2S#10S",
				"1D2S0T",
				"1S*2T*3S",
				"1D#2S*3S",
				"1T2D3D#",
				"1D2S3T*"};

		int[] pointResults = {
				37,
				9,
				3,
				23,
				5,
				-4,
				59};

		for(int i=0; i<dartResults.length; i++) {
			Assert.assertThat(this.getPoint(dartResults[i]), is(pointResults[i]));
		}
	}
}