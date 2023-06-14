class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prevVal = null;
    
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        
        if (prevVal != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevVal));
        }
        
        prevVal = node.val;
        
        inorderTraversal(node.right);
    }
}
