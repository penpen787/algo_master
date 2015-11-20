package datastructure.list;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		
		LinkedList list = new LinkedList(new Node(1));		
		
		list.add(new Node(2));
		list.add(new Node(3));
		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(6));
		list.add(new Node(7));
		System.out.println(list.size());
		
		System.out.println(list.getNodeAt(10).getValue());
		
	}
}
