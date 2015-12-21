package gcj.chap2.part1;

/**
 * @author 	: KyunghunJeon
 * @Project : Hun_GCJ
 * @Date 	: 2014. 7. 23. 
 * @desc	: 탐욕알고리즘 - N개의 문자로 된 문자열 S가 있을때, 이 S로 T를 새로 만듬
 * 				규칙 1. S의 선두문자 or 마지막문자 1개를 빼서 T에 추가
 * 				-> 사전순으로 가능한 앞인 문자 T를 만들것
 */
public class BestCowLine_Q {
	String str;
	int size;
	int s;
	int e;
	public BestCowLine_Q(String str){
		this.str = str;
		this.size = str.length();
		s = 0;
		e = size-1;
	}
	
	public void solve(){
		char[] a = str.toCharArray();
		String t = "";
		for(int i=0;i<size-1;i++){
			if(a[s] <= a[e]){
				t=t+a[s];
				s++;
			} else {
				t=t+a[e];
				e--;
			}
		}
		t=t+a[s]; // 마지막 글자 추가
		
		System.out.println(t);
	}
	
	
}
