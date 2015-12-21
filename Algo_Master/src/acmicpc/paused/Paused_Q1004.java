package acmicpc.paused;

import java.util.Scanner;

public class Paused_Q1004 {
	public static void main(String args[]){
		Scanner sc = new  Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		int[][] stEndpoints = new int[2][2];
		int[][] circlePoints = new int[50][3];
		int[] totCrossCnt = new int[testCaseNum];
		
		// Temporary Variables
		int cnt = 0;
		int crossCnt = 0;
		int circlePointsNum = 0;
		
		// Getting inputs
		for(int i=0;i<testCaseNum;i++){
			circlePointsNum = 0;
			crossCnt = 0;
			// 2 Start, End point input
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++) stEndpoints[j][k] = sc.nextInt();
			}
			sc.nextLine(); // To avoid 'enter'

			circlePointsNum = sc.nextInt();
			for(int j=0;j<circlePointsNum;j++){
				cnt = 0;
				for(int k=0;k<3;k++) circlePoints[j][k] = sc.nextInt();
				sc.nextLine(); // To avoid 'enter'
				
				// Check which one is shorter the two points and the circle radius 
				for(int k=0;k<2;k++){
					if(getDt(stEndpoints[k][0], stEndpoints[k][1], circlePoints[j][0], circlePoints[j][1]) < circlePoints[j][2] ){
						cnt++;
					}
				}
				if(cnt == 1) crossCnt++;
				
			} // End of Inputs
			totCrossCnt[i] = crossCnt;
		}
		
		// Print out all the answers
		for(int i=0;i<totCrossCnt.length;i++){
			System.out.println(totCrossCnt[i]);
		}
		sc.close();
	}
	
	public static double getDt(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
}
