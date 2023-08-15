/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fdum = new ListNode(0), bdum = new ListNode(0),
                 front = fdum, back = bdum, curr = head;
        while (curr != null) {
            if (curr.val < x) {
                front.next = curr;
                front = curr;
            } else {
                back.next = curr;
                back = curr;
            }
            curr = curr.next;
        }
        front.next = bdum.next;
        back.next = null;
        return fdum.next;
    }
}
