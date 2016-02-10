package quiz.solved;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Q9 {
	/**
	 * Remove Nth Node From End of List
	 * 
	 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2. After removing the second
	 * node from the end, the linked list becomes 1->2->3->5.
	 */

	ListNode head;

	@Before
	public void setup() {
		head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
	}

	@Test
	public void solve() {
		ListNode resultNode = removeNthFromEnd(head, 1);
		while(true) {
			if(resultNode != null) {
				System.out.println(resultNode.val);
				if(resultNode.next == null) break;
				else resultNode = resultNode.next;
			} else {
				System.out.println("NULL");
				break;
			}
		}
			
		
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> lists = new LinkedList<ListNode>();
		ListNode target = head;
		while(target != null) {
			lists.add(target);
			target = target.next;
		}
		
		int size = lists.size();
		if(n == 1) {
			if(size == 1) {
				head = null;
			} else {
				ListNode node = lists.get(size - 2);
				node.next = null;
			}
		} else if(n == size) {
			head = head.next;
		} else {
			ListNode prev = lists.get(size - n - 1);
			ListNode next = lists.get(size - n + 1);
			prev.next = next;
		}
		
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
