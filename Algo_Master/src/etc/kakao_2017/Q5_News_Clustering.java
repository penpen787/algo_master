package etc.kakao_2017;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

/**
 * http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author kyunghun.jeon
 *         created on 2017. 10. 7
 *
 * 풀이시간 : 01:10:03
 * Q1~Q5 총 시간 : 04:56:27
 */
public class Q5_News_Clustering {

	public int getJaccardSimilarity(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		List<String> parsedList1 = getParsedAndFilteredList(str1);
		List<String> parsedList2 = getParsedAndFilteredList(str2);

		Map<String, Integer> str1CountMap = getStrCountMap(parsedList1);
		Map<String, Integer> str2CountMap = getStrCountMap(parsedList2);
		System.out.println("-- strCountMap --");
		System.out.println(str1CountMap);
		System.out.println(str2CountMap);

		int intersection = getIntersection(str1CountMap, str2CountMap);
		int union = getUnion(str1CountMap, str2CountMap);
		System.out.println("intersection : " + intersection);
		System.out.println("union : " + union);

		double divide = 0;
		if (intersection == 0 || union == 0) {
			divide = 1;
		} else {
			divide = (double)intersection / (double)union;
		}

		int answer = (int) (divide * 65536);
		System.out.println("Answer : " + answer);

		return answer;
	}

	private int getUnion(Map<String, Integer> str1CountOrgMap, Map<String, Integer> str2CountOrgMap) {
		int value = 0;

		// deep copy
		Map<String, Integer> str1CountMap = new HashMap(str1CountOrgMap);
		Map<String, Integer> str2CountMap = new HashMap(str2CountOrgMap);

		Set<String> str1Keys = str1CountMap.keySet();
		Set<String> str2Keys = str2CountMap.keySet();

		Iterator<String> iter1 = str1Keys.iterator();
		while (iter1.hasNext()) {
			String key1 = iter1.next();
			int s1Cnt = str1CountMap.get(key1);

			if (str2Keys.contains(key1)) {
				int s2Cnt = str2CountMap.get(key1);
				value += s1Cnt > s2Cnt ? s1Cnt : s2Cnt;
				str2Keys.remove(key1);
			} else {
				value += s1Cnt;
			}
			iter1.remove();
		}

		Iterator<String> iter2 = str2Keys.iterator();
		while (iter2.hasNext()) {
			String key2 = iter2.next();
			int s2Cnt = str2CountMap.get(key2);

			value += s2Cnt;
		}
		return value;
	}

	private int getIntersection(Map<String, Integer> str1CountOrgMap, Map<String, Integer> str2CountOrgMap) {
		int value = 0;

		// deep copy
		Map<String, Integer> str1CountMap = new HashMap(str1CountOrgMap);
		Map<String, Integer> str2CountMap = new HashMap(str2CountOrgMap);

		Set<String> str1Keys = str1CountMap.keySet();
		Set<String> str2Keys = str2CountMap.keySet();

		Iterator<String> iter1 = str1Keys.iterator();
		while (iter1.hasNext()) {
			String key1 = iter1.next();

			if (str2Keys.contains(key1)) {
				int s1Cnt = str1CountMap.get(key1);
				int s2Cnt = str2CountMap.get(key1);
				value += s1Cnt < s2Cnt ? s1Cnt : s2Cnt;
				str2Keys.remove(key1);
			}
			iter1.remove();
		}
		return value;
	}


	private Map<String, Integer> getStrCountMap(List<String> parsedList) {

		Map<String, Integer> map = new HashMap<>();
		for (String s : parsedList) {
			if (map.containsKey(s)) {
				map.put(s, (map.get(s)+1));
			} else {
				map.put(s, 1);
			}
		}
		return map;
	}

	private List<String> getParsedAndFilteredList(String str) {
		List<String> list = new LinkedList<>();

		for(int i=0; i<str.length()-1; i++) {
			list.add(str.substring(i, i + 2));
		}

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			for (char c : s.toCharArray()) {
				if (Character.isLetter(c) == false) {
					iter.remove();
					break;
				}
			}
		}
		return list;
	}

	@Test
	public void testIsLetter() {
		char a = 'a';
		char b = '2';
		char c = '$';
		System.out.println(Character.isLetter(a));
		System.out.println(Character.isLetter(b));
		System.out.println(Character.isLetter(c));
	}

	@Test
	public void test() {
		String[] str1Arr = {"FRANCE",
				"handshake",
				"aa1+aa2",
				"E=M*C^2"};
		String[] str2Arr = {
				"french",
				"shake hands",
				"AAAA12",
				"e=m*c^2"
		};
		int[] answers = {
				16384,
				65536,
				43690,
				65536
		};

		for(int i=0; i<str1Arr.length; i++) {
			Assert.assertThat(getJaccardSimilarity(str1Arr[i],str2Arr[i]), is(answers[i]));
		}
	}
}




