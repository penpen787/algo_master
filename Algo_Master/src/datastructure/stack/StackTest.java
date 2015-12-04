package datastructure.stack;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	static String inputStr = "abcd";
	
	static Stack stack;
	
	@Before
	public void setup() {
		stack = new Stack();
		
		// insert chars
		char[] chars = inputStr.toCharArray();
		
		for (char c : chars) {
			stack.push(new Node(c));
		}
		
	}

	/**
	 * test the input string was pushed correctly
	 */
	@Test
	public void test1(){
		
		System.out.println("START TEST 1");
		
		while (! stack.isEmpty()) {
			
			Node node = stack.pop();
			System.out.println(node.getC());
		}
		
		
		
	}
}
