/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {
    HashMap<Node, Node> mp = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (mp.containsKey(node)) return mp.get(node);

        mp.put(node, new Node(node.val));
        for (Node val : node.neighbors) {
            mp.get(node).neighbors.add(cloneGraph(val));
        }

        return mp.get(node);
    }
}
