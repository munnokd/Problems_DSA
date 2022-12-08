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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum=0;
        if(root.val>=low && root.val<=high) sum+=root.val;

        int left=sumOf(root.left,low,high);
        int right=sumOf(root.right,low,high);

        return sum+left+right;
    }
    public int sumOf(TreeNode root,int low,int high){
        if(root==null) return 0;
        int sum=0;
        if(root.val>=low && root.val<=high) sum+=root.val;
        
        sum+=(root.left!=null) ? sumOf(root.left,low,high):0;
        sum+=(root.right!=null)? sumOf(root.right,low,high):0;

        return sum;
    }
}