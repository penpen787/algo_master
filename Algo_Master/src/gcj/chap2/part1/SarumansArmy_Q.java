package gcj.chap2.part1;

import gcj.common.Solution;


/**
 * @author 	: KyunghunJeon
 * @Project : Hun_GCJ
 * @Date 	: 2014. 7. 23. 
 * @desc	: 탐욕알고리즘 - 직선상에 N개의 점이 있을때, 점 i의 위치는 Xi임
 * 				반경 R이라 할때, 선택한 점은 R의 커버 범위를 가짐
 * 				N개중 최소 몇개를 선택해야 모든점이 커버되는가?
 */
public class SarumansArmy_Q implements Solution{
	private int[] p;
	private final int R;
	int pCnt = 0;
	int[] t;

	public SarumansArmy_Q(int[] p, int r) {
		this.p = p;
		this.R = r;
		t = new int[p.length];
		this.solve();
	}
	
	@Override
	public void solve(){
		
		boolean isPoint = false;
		boolean loopFlag = true;
		int pos = 0;
		int posBack;
			
		while(loopFlag){

//			System.out.println(pos);
			
			if(isPoint){	// 이미포인트 
				
				for(int i=pos+1;i<p.length;i++){
					if(p[i]-p[pos] > R){
						pos = i;
						isPoint = false;
//						System.out.println("설마여기?"+pos);
						break;
					}
					if(i == p.length-1){
						loopFlag = false;
					}
					
				}
			} else {	// 신규포인트
//				System.out.println("첫진입" + pos);
				posBack = pos;
				for(int i=p.length-1;i>pos;i--){
					if(p[i] - p[pos] <= R){
						t[pCnt] = p[i];
						pCnt++;
						pos = i;
						isPoint = true;
					}
				}
				if(pos == p.length-1) loopFlag = false;
				
				if(posBack == pos){	// 반경안에 점이 없음
					t[pCnt] = p[pos];
					pCnt++;
					pos += 1;
				}

				
			}
		}
	}

	@Override
	public void showResult() {
		System.out.println("최소로 필요한 점 개수 : "+pCnt);
		System.out.print("점이 찍히는 좌표 : ");
		for(int i=0;i<t.length;i++){
			if(t[i] == 0) break;
			System.out.print(t[i]+" ");
		}
		System.out.println("\n");
	}
}
