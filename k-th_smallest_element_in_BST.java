// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    ArrayList<Integer> arr;
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int K) {
        // Write your code here
        arr=new ArrayList<>();
        inorder(root,arr);
        if(arr.size()<K) return -1;
        return arr.get(K-1);
    }
    public void inorder(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
}