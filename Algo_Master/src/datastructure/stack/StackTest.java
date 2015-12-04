package datastructure.stack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
	 * Expected : d | c | b | a
	 */
	@Test
	public void test1() {
		System.out.println("START TEST 1");
		
		String resultStr = getStackStr(stack);
		assertEquals("dcba", resultStr);
	}

	/**
	 * Expected : e | c | b | a
	 */
	@Test
	public void mixingTest() {
		System.out.println("START TEST 2");
		
		stack.pop();
		stack.push(new Node('e'));
		
		String resultStr = getStackStr(stack);
		
		assertEquals("ecba", resultStr);

	}

	public void printStack(Stack stack) {
		while (!stack.isEmpty()) {

			Node node = stack.pop();
			System.out.println(node.getC());
		}

	}
	
	public String getStackStr(Stack stack) {
		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()) {

			Node node = stack.pop();
			sb.append(node.getC());
		}		
		
		return sb.toString();
	}

}
