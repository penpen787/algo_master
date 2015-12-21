package datastructure.queue;



public class CircularQueue {
	
	private int capacity;
	private int front = 0;
	private int rear = 0;
	
	public Node[] nodes;
	
	public CircularQueue(int capacity) {
		this.nodes = new Node[capacity + 1];	// reserved a space for rear pointer
		this.capacity = capacity;
		
	}
	
	public void add(Node node) {
		
	}
	
	public Node peek() {
		return null;
	}
	
	public Node remove() {
		return null;
	}
	
	
}

