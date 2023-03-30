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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null|| inorder.length!=postorder.length) return null;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<postorder.length;i++)
            mp.put(inorder[i],i);
        return buildTreeIn(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mp);
    }
    public TreeNode buildTreeIn(int[] postorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer> mp){
        if(ps>pe|| is>ie) return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int ir=mp.get(root.val);
        int num=ir-is;
        root.left=buildTreeIn(postorder,ps,ps+num-1,inorder,is,ir-1,mp);
        root.right=buildTreeIn(postorder,ps+num,pe-1,inorder,ir+1,ie,mp);
        return root;
    }
}
