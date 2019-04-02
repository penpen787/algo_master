package leetcode.solved.medium;

import leetcode.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Medium_Q24_SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		boolean isFirstTime = true;
		ListNode before = new ListNode(0);
		before.next = head;
		ListNode n1 = null;
		ListNode n2 = null;
		ListNode after = null;

		while(true) {
			n1 = before.next;
			if(n1 == null) {
				break;
			}
			n2 = n1.next;
			if(n2 == null) {
				break;
			}
			after = n2.next;

			// swap
			n2.next = n1;
			n1.next = after;
			before.next = n2;
			before = n1;

			if(isFirstTime) {
				head = n2;
				isFirstTime = false;
			}

		}
		return head;
	}
}