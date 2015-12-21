package gcj.chap2.part1;

/**
 * @author 	: KyunghunJeon
 * @Project : Hun_GCJ
 * @Date 	: 2014. 7. 22. 
 * @desc	: 구간 스케줄링 문제 - n 개의 강의가 있을때, 각 강의의 시작시간-종료시간을 잘 고려하여 최대한 많이 강의를 듣는것이 목표
 * 				해결알고리즘 - 탐욕 알고리즘, 종료시간이 빠른것부터 탐색해 나감
 * 				해결 전제조건 - 시간표는 종료시간이 빠른것부터 정렬되어 있어야함
 * 							    - 수업시간은 0~100 사이에만 있음
 */
public class Section_Scheduling_Q {
	int n;	// 수업수
	int[] s;	// 시작 시간
	int[] e;	// 종료 시간
	
	public Section_Scheduling_Q(int[][] tb) {
		
		this.n = tb.length;
		sortByEndTime(tb);
		
	}

	public void sortByEndTime(int[][] tb) {
		int endTime = 1000; 
		int pos = 0;
		s = new int[tb.length];
		e = new int[tb.length];
		
		for(int i=0;i<tb.length;i++){
			for(int j=0;j<tb.length;j++){
				if(tb[j][1] <= endTime){
					pos = j;
					endTime = tb[j][1];
				}
			}
			s[i] = tb[pos][0];
			e[i] = tb[pos][1];
			tb[pos][1] = 10000;
			endTime = 1000;
			System.out.println(i + " :  " + s[i] + " " + e[i]);
		}
	}
	
	public void solve(){
		
		int cnt=0;
		int pos = 0;
		int[] resultArr = new int[e.length];
		for(int i=0;i<s.length;i++){
			if(i==0){
				resultArr[cnt] = i;
				cnt++;
				continue;
				
			}
			if(e[pos] <= s[i]){
				resultArr[cnt] = i;
				cnt++;
				pos = i;
			}
		}
		System.out.println("가능한 수업수 : " + cnt);
		System.out.print("가능 수업 : ");
		for(int i=0;i<cnt;i++){
			System.out.print(resultArr[i] + " ");
		}
	}
}
