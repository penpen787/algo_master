package gcj.chap2.part1;

import gcj.common.Answer;

import org.junit.Test;


/**
 * @author 	: KyunghunJeon
 * @Project : Hun_GCJ
 * @Date 	: 2014. 7. 23. 
 * @desc	: 탐욕알고리즘 - 직선상에 N개의 점이 있을때, 점 i의 위치는 Xi임
 * 				반경 R이라 할때, 선택한 점은 R의 커버 범위를 가짐
 * 				N개중 최소 몇개를 선택해야 모든점이 커버되는가?
 */
public class SarumansArmy_A implements Answer {

	@Override
	@Test
	public void showAnswer() {
		
		int[] p = {1,7,15,20,30,50};
		SarumansArmy_Q q = new  SarumansArmy_Q(p, 10);
		q.showResult();
		

		
		int[] p1 = {1,2,4,5,7,9,10,13,17,19};
		SarumansArmy_Q q1 = new  SarumansArmy_Q(p1, 3);
		q1.showResult();
		
		
		int[] p2 = {10,30,70,100,150,180,200,210,300};
		SarumansArmy_Q q2 = new  SarumansArmy_Q(p2, 50);
		q2.showResult();
		
		
	}

	
}
