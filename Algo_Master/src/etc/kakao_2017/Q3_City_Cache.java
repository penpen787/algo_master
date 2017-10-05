package etc.kakao_2017;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;

/**
 * http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author kyunghun.jeon
 *         created on 2017. 10. 1
 *        
 * 풀이시간 : 00:41:09
 */
public class Q3_City_Cache {
	
	
	public int getProcessTime(int cacheSize, String[] cities) {
		Map<String, Integer> cacheMap = new HashMap<>(cacheSize);
		int pTime = 0;

		for(int i=0; i<cities.length; i++) {
			String city = cities[i].toLowerCase();

			if (cacheMap.get(city) != null) {
				cacheMap.put(city, i);
				pTime++;
			} else {
				if(cacheSize == 0) {
					// do nothing
				} else if(cacheMap.size() < cacheSize) {
					cacheMap.put(city, i);
				} else {
					doLRU(cacheMap, city, i);
				}
				pTime += 5;
			}
		}

		return pTime;
	}

	private void doLRU(Map<String, Integer> cacheMap, String city, int count) {
		String candidateCity = null;
		int leastRecentCnt = 100_000;
		for (Map.Entry<String, Integer> entry : cacheMap.entrySet()) {
			if (entry.getValue() < leastRecentCnt) {
				candidateCity = entry.getKey();
				leastRecentCnt = entry.getValue();
			} 
		}

		cacheMap.remove(candidateCity);
		cacheMap.put(city, count);
	}
	
	@Test
	public void test() {
		int[] cacheSizeArr = {3, 3, 2, 5, 2, 0};
		String[][] cities = {
				{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
				{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
				{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
				{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
				{"Jeju", "Pangyo", "NewYork", "newyork"},
				{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
		};
		int[] processTimeArr = {50, 21, 60, 52, 16, 25};
		
		for(int i=0; i<cacheSizeArr.length; i++) {
			Assert.assertThat(getProcessTime(cacheSizeArr[i], cities[i]), is(processTimeArr[i]));
		}
	}
}
