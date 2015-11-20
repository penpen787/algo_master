package datastructure.list;

public class LinkedList {

	private Node firstNode;
	private int size;
	
	public LinkedList() {
		firstNode = null;
		size = 0;
	}
	
	public LinkedList(Node firstNode) {
		this.firstNode = firstNode;
		size = 1;
	}

	public void add(Node node) {
		if(firstNode == null) { 
			this.firstNode = node;
		} else {
			Node lastNode = firstNode;
			for (int i = 1; i < size; i++) {
				lastNode = lastNode.getNextNode();
			}
			lastNode.setNextNode(node);
			size++;
		}
	}
	
	public Node getNodeAt(int loc) {
		if(loc > size) return null;
		
		Node node = firstNode;
		for(int i=1; i < loc; i++) {
			node = node.getNextNode();
		}
		return node;
	}
	
	public int size() {   
		return this.size;
	}
	
}

class Node {
	
	private int value;
	private Node nextNode;
	
	public Node(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}