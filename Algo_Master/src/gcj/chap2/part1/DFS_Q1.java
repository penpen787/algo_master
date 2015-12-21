package gcj.chap2.part1;


/**
 * @author 	: KyunghunJeon
 * @Project : Hun_GCJ
 * @Date 	: 2014. 7. 22. 
 * @desc	: 정수 a1,a2..an 이 있을때 몇개의 수를 골라 합이 K 가 될 수 있는지 판별
 * 				풀이법 : 깊이우선탐색(Depth-First Search)를 한다
 */
public class DFS_Q1 {
	
	public static int count;
	
	int k;
	int n;
	int[] nums;
	
	
	public DFS_Q1(int k, int[] nums){
		this.k=k;
		this.n=nums.length;
		this.nums = nums;
		DFS_Q1.count = 0;
	}
	
	
	public boolean dfs(int i, int sum){	// sum의 시작값은 당연히 0이 되어야함
		count++;
		if(i==n) return sum==k; // 현재 탐색깊이가 last depth
		
		if(dfs( i+1 , nums[i]+sum )) return true;	// num[i] 를 사용하는경우
		
		if(dfs( i+1 , sum )) return true;	// num[i] 를 사용하지 않는 경우
		
		return false; // k 를 만들수 없으면 false
	}
	
	public void solve(){
		System.out.println("DFS 결과 : " + dfs(0,0));
		System.out.println("총 dfs 루프 수 : " + count);
	}
}
