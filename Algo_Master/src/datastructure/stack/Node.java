package datastructure.stack;

public class Node {
	
	private char c;
	
	private Node prev;
	private Node next;
	
	public Node(char c) {
		this.c = c;
		prev = null;
		next = null;
	}

	
	// GETTERS AND SETTERS
	public char getC() {
		return c;
	}

	public Node getPrev() {
		return prev;
	}

	public Node getNext() {
		return next;
	}

	public void setC(char c) {
		this.c = c;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
