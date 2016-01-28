package quiz.solved;

import org.junit.Before;
import org.junit.Test;

public class Q5 {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 * 
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 * 
	 * 가정.
	 * 1. 주어진 list 는 size >= 2
	 * 2. 모든 원소는 > 0
	 */
	
	public ListNode head;
	
	@Before
	public void setup() {
		/* 
		 * Given 1->1->2->3->3, return 1->2->3.
		 */
		head = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		// Check
		this.printAllNodes(head);
		System.out.println("-- CHECK END --");
	}
	
	
	@Test
	public void solve() {
		this.deleteDuplicates(head);
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	int curval = head.val;
		ListNode before = head;
		ListNode now = head.next;
		
		while(true) {
			if(curval != now.val) {
				curval = now.val;
				before.next = now;
				before = now;
			} else {
				before.next = now.next;
			}
			
			if(now.next == null) break;
			else now = now.next;
		}
    	
		printAllNodes(head);
		return head;
    }
	
	public void printAllNodes(ListNode node) {
		while(true) {
			System.out.println(node.val);
			if(node.next == null) break;
			else node = node.next;
		}
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	
	
}
