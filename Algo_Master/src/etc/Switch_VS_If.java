package etc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Switch vs If-else 
 * performance test
 * @author PENPEN
 * 
 * Test ENV
 * Windows 7 x64, SSD, 8GB ram, i5-4300M @2.6GHZ, 4core
 * 
 * -----   RESULT   -----
 * 	Iteration 20 billion times	
 * 
 * 	IF_1
	Time : 28561 ms
	IF_2
	Time : 37376 ms
	SWITCH_1
	Time : 17615 ms
	SWITCH_2
	Time : 17265 ms

 * 
 */
public class Switch_VS_If {

	long startTime;
	long endTime;
	
	int numbers = 20;
//	long times = 1000000000L;
	long times = 1000000000L;
	
	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void tearDown() {
		endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime) + " ms");
	}
	
	int t;
	
	/**
	 * Time for loop 1 billion times (10억) with no codes inside = 3286 ms
	 */
	@Test
	public void testIf1() {
		
		/**
		 * Time for loop 1 billion times (10억) = 3286 ms
		 */
		System.out.println("IF_1");
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
	public void testSwitch1() {
		
		/**
		 * Time for loop 10 billion times = 3286 ms
		 */
		System.out.println("SWITCH_1");
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
	public void testIf2() {
		
		System.out.println("IF_2");
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
	public void testSwitch2() {
		
		System.out.println("SWITCH_2");
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
