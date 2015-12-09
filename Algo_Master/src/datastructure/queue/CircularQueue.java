package datastructure.queue;

public class CircularQueue {
	
	public int capacity;
	public int front;
	public int rear;
	
	public Node[] nodes;
	
	public CircularQueue(int capacity) {
		this.nodes = new Node[capacity + 1];	// reserved a space for rear pointer
		this.capacity = capacity;
	}

	
	
}

