package leetcode.solved.easy;


import leetcode.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class Easy_Q876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }
        boolean move = false;
        ListNode mid = head;
        while(head != null) {
            if(move) {
                mid = mid.next;
            }
            move = !move;
            head = head.next;
        }
        return mid;
    }
}
