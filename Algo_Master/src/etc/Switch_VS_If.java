package etc;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Switch vs If-else 
 * performance test
 * @author PENPEN
 * 
 * Test ENV
 * Windows 7 x64, SSD, 8GB ram, i5-4300M @2.6GHZ, 4core
 * Java 1.7
 * 
 * -----   RESULT   -----
 * 	Iteration 10 billion times	
 * 	20 Cases
 * 
	IF_2
	Time : 37376 ms
	SWITCH_2
	Time : 17265 ms
 * 
 */
public class Switch_VS_If {

	long startTime;
	long endTime;
	
//	int numbers = 10;
	int numbers = 5;
	long times = 1000000000L;
//	long times = 2000000000L;
	
	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void tearDown() {
		endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime) + " ms");
	}
	
	// times
	int t;
	
	
	@Test
	@Ignore
	public void testIf0_3_Cases() {
		
		/**
		 * Time for loop 1 billion times (10억) = 3286 ms
		 */
		
		numbers = 3;
		
		System.out.println("IF_3_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				if	   (i == 0  )	t = i ; 
				else if(i == 1  )	t = i ;
				else if(i == 2  )	t = i ;
				else 				t = i ;
				
			}
		}
	}
	
	@Test
	@Ignore

	public void testSwitch0_3_Cases() {
		
		numbers = 3;
		
		System.out.println("SWITCH_3_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				switch (i) {
				case 0:
					t = i;
					break;
				case 1:
					t = i;
					break;
				case 2:
					t = i;
					break;
				default:
					t = i;
					break;
				}
			}
		}
	}
	
	@Test
	@Ignore

	public void testSwitch_4_Cases() {
		
		numbers = 4;
		
		System.out.println("SWITCH_4_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				switch (i) {
				case 0:
					t = i;
					break;
				case 1:
					t = i;
					break;
				case 2:
					t = i;
					break;
				case 3:
					t = i;
					break;
				default:
					t = i;
					break;
				}
			}
		}
	}
	
	@Test
	@Ignore
	public void testIf_4_Cases() {
		
		numbers = 4;
		
		System.out.println("IF_4_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				if	   (i == 0  )	t = i ; 
				else if(i == 1  )	t = i ;
				else if(i == 2  )	t = i ;
				else if(i == 3  )	t = i ;
				else 				t = i ;
				
			}
		}
	}
	
	@Test
	@Ignore

	public void testIf_5_Cases() {
		
		numbers = 5;
		
		System.out.println("IF_5_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				if	   (i == 0  )	t = i ; 
				else if(i == 1  )	t = i ;
				else if(i == 2  )	t = i ;
				else if(i == 3  )	t = i ;
				else if(i == 4  )	t = i ;
				else 				t = i ;
				
			}
		}
	}
	
	@Test
	@Ignore

	public void testSwitch_5_Cases() {
		
		numbers = 5;
		
		System.out.println("SWITCH_5_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				switch (i) {
				case 0:
					t = i;
					break;
				case 1:
					t = i;
					break;
				case 2:
					t = i;
					break;
				case 3:
					t = i;
					break;
				case 4:
					t = i;
					break;
				default:
					t = i;
					break;
				}
			}
		}
	}
	
	
	
	
	/**
	 * Time for loop 1 billion times (10억) with no codes inside = 3286 ms
	 */
	@Test
	@Ignore
	public void testIf_10_Cases() {
		
		numbers = 10;
		
		System.out.println("IF_10_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				if	   (i == 0  )	t = i ; 
				else if(i == 1  )	t = i ;
				else if(i == 2  )	t = i ;
				else if(i == 3  )	t = i ;
				else if(i == 4  )	t = i ;
				else if(i == 5  )	t = i ;
				else if(i == 6  )	t = i ;
				else if(i == 7  )	t = i ;
				else if(i == 8  )	t = i ;
				else if(i == 9  )	t = i ;
				else 				t = i ;
				
			}
		}
	}
	
	@Test
	@Ignore
	public void testSwitch_10_Cases() {
		
		/**
		 * Time for loop 10 billion times = 3286 ms
		 */
		
		numbers = 10;

		System.out.println("SWITCH_10_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				switch (i) {
				case 0:
					t = i;
					break;
				case 1:
					t = i;
					break;
				case 2:
					t = i;
					break;
				case 3:
					t = i;
					break;
				case 4:
					t = i;
					break;
				case 5:
					t = i;
					break;
				case 6:
					t = i;
					break;
				case 7:
					t = i;
					break;
				case 8:
					t = i;
					break;
				case 9:
					t = i;
					break;
				default:
					t = i;
					break;
				}
			}
		}
	}
	
	@Test

	public void testIf_20_Cases() {
		
		numbers = 20;
		
		System.out.println("IF_20_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				if	   (i == 1   )	t = i ; 
				else if(i == 2   )	t = i ;
				else if(i == 3   )	t = i ;
				else if(i == 4   )	t = i ;
				else if(i == 5   )	t = i ;
				else if(i == 6   )	t = i ;
				else if(i == 7   )	t = i ;
				else if(i == 8   )	t = i ;
				else if(i == 9   )	t = i ;
				else if(i == 10  )	t = i ;
				else if(i == 11  )	t = i ;
				else if(i == 12  )	t = i ;
				else if(i == 13  )	t = i ;
				else if(i == 14  )	t = i ;
				else if(i == 15  )	t = i ;
				else if(i == 16  )	t = i ;
				else if(i == 17  )	t = i ;
				else if(i == 18  )	t = i ;
				else if(i == 19  )	t = i ;
				else 				t = i ;
				
			}
		}
	}
	
	@Test

	public void testSwitch_20_Cases() {
		
		numbers = 20;
		
		System.out.println("SWITCH_20_Cases");
		for(int i=0;i<numbers;i++){
			for(long j=0; j< times; j++) {
				
				switch (i) {
				case 0:
					t = i;
					break;
				case 1:
					t = i;
					break;
				case 2:
					t = i;
					break;
				case 3:
					t = i;
					break;
				case 4:
					t = i;
					break;
				case 5:
					t = i;
					break;
				case 6:
					t = i;
					break;
				case 7:
					t = i;
					break;
				case 8:
					t = i;
					break;
				case 9:
					t = i;
					break;
				case 10:
					t = i;
					break;
				case 11:
					t = i;
					break;
				case 12:
					t = i;
					break;
				case 13:
					t = i;
					break;
				case 14:
					t = i;
					break;
				case 15:
					t = i;
					break;
				case 16:
					t = i;
					break;
				case 17:
					t = i;
					break;
				case 18:
					t = i;
					break;
				case 19:
					t = i;
					break;
				default:
					t = i;
					break;
				}
			}
		}
	}
	
}
