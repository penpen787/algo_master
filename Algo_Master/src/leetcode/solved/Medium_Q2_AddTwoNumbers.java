package leetcode.solved;

import leetcode.TreeNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Medium_Q938_RangeSumOfBST {

	public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
		int bal = 0;
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while(true) {
			if(n1 == null && n2 == null) {
				if(bal != 0) curr.next = new ListNode(bal);
				break;
			}

			int num1 = n1 == null ? 0 : n1.val;
			int num2 = n2 == null ? 0 : n2.val;
			int sum = num1 + num2 + bal;
			bal = sum / 10;

			curr.next = new ListNode(sum % 10);
			n1 = n1 == null ? n1 : n1.next;
			n2 = n2 == null ? n2 : n2.next;
			curr = curr.next;
		}
		return head.next;
	}
}
