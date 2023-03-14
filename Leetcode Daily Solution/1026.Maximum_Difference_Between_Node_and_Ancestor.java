/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return find(root,root.val,root.val);
    }
    public int find(TreeNode root,int min,int max){
        if(root==null) return max-min;

        if(root.val<min) min=root.val;
        if(root.val>max) max=root.val;

        return Math.max(find(root.left,min,max),find(root.right,min,max));
    }
}