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
    List<Integer> ls=new ArrayList<Integer>();
    public Solution(ListNode head) {
        while(head != null){
            ls.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int rand = (int)(Math.random() * ls.size());
        return ls.get(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
