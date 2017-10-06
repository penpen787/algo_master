package etc.kakao_2017;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.core.Is.is;

/**
 * http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author kyunghun.jeon
 *         created on 2017. 10. 6
 *
 * 풀이시간 : 01:53:37
 */
public class Q4_Shuttle_Bus {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	private String getLastTime(int n, int t, int m, List<String> timeList) throws ParseException {

		List<Date> orderedTimeTable = getOrderedTimeTable(timeList);

		LinkedHashMap<Date, List<Date>> busMap = getBusQueue(n, t, m, orderedTimeTable);

		System.out.println("busMap List : " + timeList);

		String answerTime = getProperTime(busMap, m);

		System.out.println("answer : " + answerTime);

		return answerTime;
	}

	private String getProperTime(LinkedHashMap<Date, List<Date>> busMap, int m) {
		Set<Date> dateSet = busMap.keySet();
		Iterator<Date> iterator = dateSet.iterator();

		Date lastBusDate = null;
		while (iterator.hasNext()) {
			lastBusDate = iterator.next();
		}

		List<Date> lastBusPassengers = busMap.get(lastBusDate);

		if (lastBusPassengers.isEmpty() || lastBusPassengers.size() < m) {
			return sdf.format(lastBusDate);
		} else {
			Date lastPassengerDate = lastBusPassengers.get(lastBusPassengers.size() - 1);
			Calendar c = Calendar.getInstance();
			c.setTime(lastPassengerDate);
			c.add(Calendar.MINUTE, -1);
			return sdf.format(c.getTime());
		}
	}

	private LinkedHashMap<Date,List<Date>> getBusQueue(int n, int t, int m, List<Date> waitingPassengers) throws ParseException {
		LinkedHashMap<Date, List<Date>> busMap = new LinkedHashMap<>();
		Date busTime = sdf.parse("09:00");

		int passengerPointer = 0;

		for(int i=0; i<n; i++) {
			List<Date> busPassengers = new ArrayList<>();

			if(i != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(busTime);
				c.add(Calendar.MINUTE, t);
				busTime = c.getTime();
			}

			// 탑승가능 승객 계산
			for(int j=0; j<m; j++) {
				// 더이상 남은 승객이 없음
				if (passengerPointer == waitingPassengers.size()) {
					break;
				}

				Date passengerTime = waitingPassengers.get(passengerPointer);
				if (passengerTime.compareTo(busTime) <= 0) {
					busPassengers.add(passengerTime);
					passengerPointer++;
				}
			}

			busMap.put(busTime, busPassengers);
		}
		return busMap;
	}

	private List<Date> getOrderedTimeTable(List<String> strList) {
		List<Date> timeList = new LinkedList<>();

		for (String t : strList) {
			Date d = null;
			try {
				d = sdf.parse(t);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("SDF error");
			}

			if (timeList.isEmpty()) {
				timeList.add(d);
				continue;
			}

			for(int i=0; i<timeList.size(); i++) {
				Date targetTime = timeList.get(i);
				if (d.before(targetTime)) {
					timeList.add(i, d);
					break;
				}

				if (i == timeList.size() - 1) {
					timeList.add(d);
					break;
				}
			}
		}

		return timeList;
	}

	@Test
	public void test() throws ParseException {

		List<Table> tableList = new ArrayList<>();
		tableList.add(new Table(1,	1, 5,   Arrays.asList("08:00", "08:01", "08:02", "08:03")                                                                                                                   ,      "09:00"));
		tableList.add(new Table(2,	10, 2,  Arrays.asList("09:10", "09:09", "08:00")                                                                                                                            ,      "09:09"));
		tableList.add(new Table(2,	1, 2,   Arrays.asList("09:00", "09:00", "09:00", "09:00")                                                                                                                   ,      "08:59"));
		tableList.add(new Table(1,	1, 5,   Arrays.asList("00:01", "00:01", "00:01", "00:01", "00:01")                                                                                                          ,      "00:00"));
		tableList.add(new Table(1,	1, 1,   Arrays.asList("23:59")                                                                                                                                              ,      "09:00"));
		tableList.add(new Table(10,	60, 45, Arrays.asList("23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59")        ,"18:00"));

		for(int i=0; i<tableList.size(); i++) {
			Table tb = tableList.get(i);
			Assert.assertThat(getLastTime(tb.getN(), tb.getT(), tb.getM(),tb.getTimeList()), is(tb.answer));
//			getLastTime(tb.getN(), tb.getT(), tb.getM(),tb.getTimeList());
		}
	}


	@Test
	public void sdfTest() throws ParseException {
		String[] times = {"00:00", "09:05", "23:59"};
		for (String t : times) {
			Date parsedDate = sdf.parse(t);
			System.out.println(parsedDate);
		}
	}

	public static class Table {
		int n;
		int t;
		int m;
		List<String> timeList;
		String answer;

		public Table(int n, int t, int m, List<String> timeList, String answer) {
			this.n = n;
			this.t = t;
			this.m = m;
			this.timeList = timeList;
			this.answer = answer;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public int getT() {
			return t;
		}

		public void setT(int t) {
			this.t = t;
		}

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}

		public List<String> getTimeList() {
			return timeList;
		}

		public void setTimeList(List<String> timeList) {
			this.timeList = timeList;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}
	}



}


/*
new Table(1,	1, 5,   {"08:00", "08:01", "08:02", "08:03"}                                                                                                                   ,      "09:00");
new Table(2,	10, 2,  {"09:10", "09:09", "08:00"}                                                                                                                            ,      "09:09");
new Table(2,	1, 2,   {"09:00", "09:00", "09:00", "09:00"}                                                                                                                   ,      "08:59");
new Table(1,	1, 5,   {"00:01", "00:01", "00:01", "00:01", "00:01"}                                                                                                          ,      "00:00");
new Table(1,	1, 1,   {"23:59"}                                                                                                                                              ,      "09:00");
new Table(10,	60, 45, {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}        ,"18:00");




		{"08:00", "08:01", "08:02", "08:03"}
		{"09:10", "09:09", "08:00"}
		{"09:00", "09:00", "09:00", "09:00"}
		{"00:01", "00:01", "00:01", "00:01", "00:01"}
		{"23:59"}
		{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
		*/








