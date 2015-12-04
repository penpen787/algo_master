package datastructure.stack;

public class Stack {
	
	private Node bottom;
	private Node top;
	
	public Stack() {
		bottom = null;
		top = null;
	}

	public void push(Node node) {
		if(this.bottom == null) {
			this.bottom = node;
			this.top = node;
		} else {
			Node lastTop = this.top;
			lastTop.setNext(node);
			
			node.setPrev(lastTop);
			this.top = node;
		}
	}
	
	public Node pop() {
		if(bottom == null) {
			return null;
		} else {
			Node curTop = this.top;
			Node nextTop = curTop.getPrev();
			
			if(nextTop == null) {
				this.top = null;
				this.bottom = null;
			} else {
				nextTop.setNext(null);
				this.top = nextTop;
			}
			
			return curTop;
		}
	}
	
	public Node peek() {
		return this.top;
	}
	
	public boolean isEmpty() {
		return this.bottom == null;
	}
}
