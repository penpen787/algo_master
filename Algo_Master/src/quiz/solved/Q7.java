package quiz.solved;

import org.junit.Before;
import org.junit.Test;

public class Q7 {
	/**
	 * Intersection of Two Linked Lists
	 * 
	 * https://leetcode.com/problems/intersection-of-two-linked-lists/
	 */

	ListNode a;
	ListNode b;

	@Before
	public void setup() {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);

		ListNode b1 = new ListNode(3);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(5);

		ListNode c1 = new ListNode(6);
		ListNode c2 = new ListNode(7);
		ListNode c3 = new ListNode(8);

		a1.next = a2;
		a2.next = c1;

		b1.next = b2;
		b2.next = b3;
		b3.next = c1;

		c1.next = c2;
		c2.next = c3;
		c3.next = null;

		a = a1;
		b = b1;
	}

	@Test
	public void test() {
		ListNode intersecationNode = getIntersectionNode(a, b);
		
		if(intersecationNode == null) System.out.println("NULL");
		else System.out.println(intersecationNode.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null) return null;
		
		int cntA = getSize(headA);
		int cntB = getSize(headB);
		
		ListNode theNode;
		
		if(cntA > cntB) theNode = getTheNode(headA, headB, cntA, cntB);
		else theNode = getTheNode(headB, headA, cntB, cntA);
		
		return theNode;
	}

	/* Big & Small node and count */
	private ListNode getTheNode(ListNode bNode, ListNode sNode, int bCnt, int sCnt) {
		for(int i=0; i<bCnt-sCnt; i++) bNode = bNode.next;
		
		for(int i=0; i<sCnt; i++) {
			if(bNode == sNode) return bNode;
			else {
				bNode = bNode.next;
				sNode = sNode.next;
			}
		}
		return null;
	}

	private int getSize(ListNode node) {
		int i=1;
		while(node.next != null) {
			++i;
			node = node.next;
		}
		return i;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
