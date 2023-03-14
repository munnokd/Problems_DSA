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
    public int find(TreeNode root,List<Integer> li){
        if(root==null) return 0;

        int ls=find(root.left,li);
        int rs=find(root.right,li);

        int sum = ls + root.val + rs;
        li.add(sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        long maxi=0;
        List<Integer> li=new ArrayList<Integer>();

        int sum=find(root,li);

        for(long s:li){
            long pro=(sum-s)*s;
            maxi=Math.max(pro,maxi); 
        }

        return (int)(maxi%1000000007);
    }
}