package datastructure.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketTester {

	// Missing close braket at the last
//	String inputStr = "2.3 + 23 / 12 + (3.14159 * .24";	
//	String inputStr = "2.3 + 23 / 12 + (3.14159 *} .24)";	
	String inputStr = "2.3 + 23 / 12} + (3.14159 *} .24)";	
	
	@Test
	public void test() {
		
		Stack stack = new Stack();
		
		char[] charArr = inputStr.toCharArray();
		
		for(int i=0; i<charArr.length; i++) {
			char c = charArr[i];
			
			if(isOpenBracket(c)) {
				stack.push(new Node(c));
				
			} else if(isCloseBracket(c)) {
				
				Node node = stack.peek();
				if(node == null)
					fail("Position : " + (i));
				
				char lastOpenBracket = stack.peek().getC();
				if(isPair(lastOpenBracket, c)) {
					stack.pop();
				} else {
					fail("Position : " + (i));
				}
			}
		}
		
		if(! stack.isEmpty())
			fail("Position : LAST");
		
	}
	
	boolean isOpenBracket(char c) {
		return c == '(' || c == '{' || c == '[';
	}
	
	boolean isCloseBracket(char c) {
		return c == ')' || c == '}' || c == ']';
	}
	
	boolean isPair(char o, char c) {
		if     (o == '(') return c == ')';
		else if(o == '{') return c == '}';
		else if(o == '[') return c == ']';
		else 			  return false;
	}
	
	
}