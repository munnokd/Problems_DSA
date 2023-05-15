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
  public ListNode swapNodes(ListNode head, int k) {
    var n = 0;
    for (var ptr = head; ptr != null; ptr = ptr.next, n++);

    ListNode a = null, b = null, ptr = head;
    for (var i=1; i<=n; i++, ptr = ptr.next) {
      if (i == k) a = ptr;
      if (i == n+1-k) b = ptr;
    }
    var tmp = a.val;
    a.val = b.val;
    b.val = tmp;

    return head;
  }
}
