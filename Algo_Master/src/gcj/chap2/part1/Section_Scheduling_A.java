package gcj.chap2.part1;

import org.junit.Test;

/**
 * @author 	: KyunghunJeon
 * @Project : Hun_GCJ
 * @Date 	: 2014. 7. 22. 
 * @desc	: 구간 스케줄링 문제 - n 개의 강의가 있을때, 각 강의의 시작시간-종료시간을 잘 고려하여 최대한 많이 강의를 듣는것이 목표
 * 				해결알고리즘 - 탐욕 알고리즘, 종료시간이 빠른것부터 탐색해 나감
 * 				해결 전제조건 - 시간표는 종료시간이 빠른것부터 정렬되어 있어야함
 * 							    - 수업시간은 0~100 사이에만 있음
 */
public class Section_Scheduling_A {
	
	@Test
	public void solve(){
		int[][] qArr = {
				{1,2},
				{3,5},
				{2,7},
				{5,8},
				{8,10},
				{10,12},
				{2,3},
				{5,7}
		};
		Section_Scheduling_Q q = new Section_Scheduling_Q(qArr);
		q.solve();
	}
	
}
