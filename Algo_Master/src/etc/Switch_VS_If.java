package etc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Switch vs If-else 
 * performance test
 * @author PENPEN
 *
 */
public class Switch_VS_If {

	long startTime;
	long endTime;
	
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
	
	@Test
	public void testSwitch() {
		
		/**
		 * Time for loop 1 billion times (10억) = 3286 ms
		 */
		System.out.println("IF");
		for(int i=0;i<10;i++){
			for(long j=0; j< 1000000000L; j++) {
				
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
	public void testIf() {
		
		/**
		 * Time for loop 10 billion times = 3286 ms
		 */
		System.out.println("SWITCH");
		for(int i=0;i<10;i++){
			for(long j=0; j< 1000000000L; j++) {
				
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
	
}
