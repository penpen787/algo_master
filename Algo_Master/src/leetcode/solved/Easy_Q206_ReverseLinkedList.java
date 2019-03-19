package leetcode.solved;


import leetcode.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Easy_Q206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
